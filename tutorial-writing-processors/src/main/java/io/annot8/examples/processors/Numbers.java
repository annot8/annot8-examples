package io.annot8.examples.processors;

import io.annot8.api.capabilities.Capabilities;
import io.annot8.api.components.annotations.ComponentDescription;
import io.annot8.api.components.annotations.ComponentName;
import io.annot8.api.components.annotations.SettingsClass;
import io.annot8.api.context.Context;
import io.annot8.common.components.AbstractProcessorDescriptor;
import io.annot8.common.components.capabilities.SimpleCapabilities;
import io.annot8.common.data.bounds.SpanBounds;
import io.annot8.common.data.content.Text;

/*
  The class annotations below are intended for use by user interfaces to show meaningful information
  about a component
 */
@ComponentName("Numbers")   //The display name of the processor
@ComponentDescription("Extracts numbers from text")   //A short description of the processor
@SettingsClass(NumbersSettings.class)   //The class that contains settings for this processor, may be the NoSettings class
/*
  AbstractProcessorDescriptor provides a good starting point for creating process descriptors.
  It takes the processor and settings objects as generic types, so that we can accept/return the appropriate classes/
 */
public class Numbers extends AbstractProcessorDescriptor<NumbersProcessor, NumbersSettings> {

  /*
    This allows querying of the capabilities of a component.
    The capabilities returned may be dependent on the current settings, which can be accessed via getSettings()
   */
  @Override
  public Capabilities capabilities() {
    return new SimpleCapabilities.Builder()
        //.from(super.capabilities())   //This isn't needed here as our parent is abstract, but if the parent did have capabilities you may want to inherit them
        .withCreatesAnnotations("number", SpanBounds.class) //Declare that we create "number" annotations
        .withProcessesContent(Text.class)   //Declare that we process Text content
        .build();
  }

  /*
    This creates our actual processor.

    The context holds resources such as logging and metrics.
    These are configured for you in the Abstract*Descriptor classes, so you probably won't need to use this but are provided in case you do.

    Settings are provided as a convenience to save multiple calls to getSettings()
   */
  @Override
  protected NumbersProcessor createComponent(Context context, NumbersSettings settings) {
    return new NumbersProcessor(settings.getMinDigits());
  }
}
