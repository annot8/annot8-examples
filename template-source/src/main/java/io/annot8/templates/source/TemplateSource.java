package io.annot8.templates.source;

import io.annot8.common.components.AbstractSource;
import io.annot8.core.components.responses.SourceResponse;
import io.annot8.core.data.ItemFactory;

public class TemplateSource extends AbstractSource {

  public TemplateSource() {
    //TODO: Accept configuration and intialise
  }

  @Override
  public SourceResponse read(ItemFactory itemFactory) {
    //TODO: Create new items

    return SourceResponse.ok();
  }
}
