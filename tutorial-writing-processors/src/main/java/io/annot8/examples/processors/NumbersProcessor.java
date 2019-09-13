package io.annot8.examples.processors;

import io.annot8.common.components.AbstractProcessor;
import io.annot8.common.data.bounds.SpanBounds;
import io.annot8.common.data.content.Text;
import io.annot8.conventions.PropertyKeys;
import io.annot8.core.components.responses.ProcessorResponse;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.BadConfigurationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  The actual processor which does the work
 */
public class NumbersProcessor extends AbstractProcessor {

  private final Pattern numberPattern;

  public NumbersProcessor(int minDigits) {
    //Whilst in theory settings should have been validated with validate() before being used to create the processor, it doesn't hurt to check!
    if(minDigits <= 0)
      throw new BadConfigurationException("Minimum digits must be at least 1");

    //Create our extraction pattern based on the configuration
    numberPattern = Pattern.compile("\\b[0-9]{"+minDigits+",}\\b");
  }

  @Override
  public ProcessorResponse process(Item item) {
    //Process is the method called to process an item. An item can have multiple Content objects, so here we extract all the Text content and then process each in turn.
    item.getContents(Text.class).forEach(this::processText);

    //Once we're done, we return ok (if there were errors, we could return a different response optionally with exceptions).
    return ProcessorResponse.ok();
  }

  public void processText(Text content){
    //Create a Regex matcher for the current content
    Matcher m = numberPattern.matcher(content.getData());

    //Find all of the matches, and for each one create a new annotation
    while(m.find()){
      content.getAnnotations().create()
          .withBounds(new SpanBounds(m.start(), m.end()))   //Set the bounds
          .withType("number")   //Set the type, using a hard coded value as there isn't an appropiate one in the annot8-conventions project
          .withProperty(PropertyKeys.PROPERTY_KEY_VALUE, Integer.parseInt(m.group()))   //Set a property on the annotation, using the appropriate convention
          .save();
    }
  }
}
