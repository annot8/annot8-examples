package io.annot8.templates.processor;

import io.annot8.api.capabilities.Capabilities;
import io.annot8.api.components.annotations.ComponentDescription;
import io.annot8.api.components.annotations.ComponentName;
import io.annot8.api.components.annotations.SettingsClass;
import io.annot8.api.context.Context;
import io.annot8.common.components.AbstractProcessorDescriptor;
import io.annot8.common.components.capabilities.SimpleCapabilities;

@ComponentName("Component name")   //TODO: Update this
@ComponentDescription("Component description")   //TODO: Update this
@SettingsClass(TemplateSettings.class)   //TODO: Update this
public class Template extends AbstractProcessorDescriptor<TemplateProcessor, TemplateSettings> {

  @Override
  public Capabilities capabilities() {
    return new SimpleCapabilities.Builder()
        //.from(super.capabilities()) //TODO: Uncomment this if parent also has capabilities
        //TODO: Declare capabilities here
        .build();
  }

  @Override
  protected TemplateProcessor createComponent(Context context, TemplateSettings settings) {
    return new TemplateProcessor(); //TODO: Create an instance of the processor
  }
}
