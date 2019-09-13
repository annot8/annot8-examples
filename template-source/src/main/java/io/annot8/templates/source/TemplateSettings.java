package io.annot8.templates.source;

import io.annot8.core.settings.Settings;

import javax.json.bind.annotation.JsonbCreator;

public class TemplateSettings implements Settings {

  @JsonbCreator
  public TemplateSettings() {
    //TODO: Populate constructor, remembering to add @JsonbProperty annotations
  }

  @Override
  public boolean validate() {
    //TODO: Validate settings
    return true;
  }
}
