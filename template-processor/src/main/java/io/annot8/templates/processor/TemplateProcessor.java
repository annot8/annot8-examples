package io.annot8.templates.processor;

import io.annot8.api.components.responses.ProcessorResponse;
import io.annot8.api.data.Item;
import io.annot8.common.components.AbstractProcessor;

public class TemplateProcessor extends AbstractProcessor {

  public TemplateProcessor() {
    //TODO: Accept configuration and intialise
  }

  @Override
  public ProcessorResponse process(Item item) {
    //TODO: Process an item

    return ProcessorResponse.ok();
  }
}
