package io.annot8.templates.source;

import io.annot8.common.components.AbstractSourceDescriptor;
import io.annot8.common.components.capabilities.SimpleCapabilities;
import io.annot8.core.capabilities.Capabilities;
import io.annot8.core.components.annotations.ComponentDescription;
import io.annot8.core.components.annotations.ComponentName;
import io.annot8.core.components.annotations.SettingsClass;
import io.annot8.core.context.Context;

@ComponentName("Component name")   //TODO: Update this
@ComponentDescription("Component description")   //TODO: Update this
@SettingsClass(TemplateSettings.class)   //TODO: Update this
public class Template extends AbstractSourceDescriptor<TemplateSource, TemplateSettings> {

  @Override
  public Capabilities capabilities() {
    return new SimpleCapabilities.Builder()
        //.from(super.capabilities()) //TODO: Uncomment this if parent also has capabilities
        //TODO: Declare capabilities here
        .build();
  }

  @Override
  protected TemplateSource createComponent(Context context, TemplateSettings settings) {
    return new TemplateSource(); //TODO: Create an instance of the source
  }
}
