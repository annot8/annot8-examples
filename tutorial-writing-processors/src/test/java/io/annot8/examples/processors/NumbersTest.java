package io.annot8.examples.processors;

import io.annot8.common.data.bounds.SpanBounds;
import io.annot8.common.data.content.Text;
import io.annot8.core.capabilities.AnnotationCapability;
import io.annot8.core.capabilities.Capabilities;
import io.annot8.core.capabilities.ContentCapability;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumbersTest {

  @Test
  public void testCapabilities(){
    Numbers n = new Numbers();

    //Get the capabilities and check that we have the expected number
    Capabilities c = n.capabilities();
    assertEquals(1, c.creates().count());
    assertEquals(1, c.processes().count());
    assertEquals(0, c.deletes().count());

    //Check that we're creating an Annotation and that it has the correct definitions
    AnnotationCapability annotCap = c.creates(AnnotationCapability.class).findFirst().get();
    assertEquals(SpanBounds.class, ((AnnotationCapability)annotCap).getBounds());
    assertEquals("number", ((AnnotationCapability)annotCap).getType());

    //Check that we're processing a Content and that it has the correct definitions
    ContentCapability contentCap = c.processes(ContentCapability.class).findFirst().get();
    assertEquals(Text.class, ((ContentCapability)contentCap).getType());
  }

  @Test
  public void testCreateComponent(){
    Numbers n = new Numbers();

    //Test that we actually get a component when we create it
    NumbersProcessor np = n.createComponent(null, new NumbersSettings(3));
    assertNotNull(np);
  }
}
