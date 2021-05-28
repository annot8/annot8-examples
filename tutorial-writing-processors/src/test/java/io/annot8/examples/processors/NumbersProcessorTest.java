package io.annot8.examples.processors;

import io.annot8.api.annotations.Annotation;
import io.annot8.api.exceptions.BadConfigurationException;
import io.annot8.common.data.content.Text;
import io.annot8.conventions.AnnotationTypes;
import io.annot8.testing.testimpl.TestItem;
import io.annot8.testing.testimpl.content.TestStringContent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumbersProcessorTest {

  /*
    Test that we process text correctly
   */
  @Test
  public void testProcessText(){
    TestStringContent content = new TestStringContent();    //TestStringContent is a test implementation of the Text content class
    content.setData("Should extract 12345, but not 123");

    NumbersProcessor np = new NumbersProcessor(4);
    np.processText(content);

    //Check that it's only extracted a single number, as the second number doesn't have enough digits
    assertEquals(1, content.getAnnotations().getAll().count());

    //Check the properties, bounds and type of the annotation
    Annotation annotation = content.getAnnotations().getAll().findFirst().get();
    assertEquals("12345", annotation.getBounds().getData(content).get());
    assertEquals(12345, annotation.getProperties().get("value").get());
    assertEquals(AnnotationTypes.ANNOTATION_TYPE_NUMBER, annotation.getType());
  }

  /*
    Test that we process multiple content within the same item
   */
  @Test
  public void testProcess(){
    TestItem item = new TestItem();
    item.createContent(Text.class).withData("Extract 12345").withDescription("First content").save();
    item.createContent(Text.class).withData("Extract 67890").withDescription("Second content").save();

    NumbersProcessor np = new NumbersProcessor(4);
    np.process(item);

    assertEquals(2, item.getContents().count());
    item.getContents().forEach(c -> {
      assertEquals(1, c.getAnnotations().getAll().count());
    });
  }

  /*
    Test that bad configuration is rejected
   */
  @Test
  public void testBadConfig(){
    assertThrows(BadConfigurationException.class, () -> new NumbersProcessor(0));
    assertThrows(BadConfigurationException.class, () -> new NumbersProcessor(-3));
  }
}
