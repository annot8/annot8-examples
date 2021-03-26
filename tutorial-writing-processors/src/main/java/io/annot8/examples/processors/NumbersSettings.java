package io.annot8.examples.processors;

import io.annot8.api.settings.Description;
import io.annot8.api.settings.Settings;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

/*
  Settings class for our processor, which is used to hold and validate configuration information.
  This class should be de/serializable with JSON-B, so the relevant JSON-B annotations should be included
 */
public class NumbersSettings implements Settings {
  private final int minDigits;

  /*
    Constructor for the settings class, with JSON-B annotations so that the class can be deserialized
   */
  @JsonbCreator
  public NumbersSettings(@JsonbProperty("minDigits") int minDigits) {
    this.minDigits = minDigits;
  }

  /*
    The description annotation is provided by Annot8 as a way of describing configuration parameters to UIs
   */
  @Description("The minimum number of digits to accept")
  public int getMinDigits() {
    return minDigits;
  }

  /*
    Validate is used to check that the configuration is valid
   */
  @Override
  public boolean validate() {
    return minDigits > 0;
  }
}
