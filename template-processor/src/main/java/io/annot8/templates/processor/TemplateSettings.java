package io.annot8.templates.processor;


import io.annot8.api.settings.Settings;
import jakarta.json.bind.annotation.JsonbCreator;

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
