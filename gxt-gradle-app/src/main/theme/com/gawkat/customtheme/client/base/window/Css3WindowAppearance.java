/**
 * Sencha GXT 4.0.2 - Sencha for GWT
 * Copyright (c) 2006-2016, Sencha Inc.
 *
 * licensing@sencha.com
 * http://www.sencha.com/products/gxt/license/
 *
 * ================================================================================
 * Commercial License
 * ================================================================================
 * This version of Sencha GXT is licensed commercially and is the appropriate
 * option for the vast majority of use cases.
 *
 * Please see the Sencha GXT Licensing page at:
 * http://www.sencha.com/products/gxt/license/
 *
 * For clarification or additional options, please contact:
 * licensing@sencha.com
 * ================================================================================
 *
 *
 *
 *
 *
 *
 *
 *
 * ================================================================================
 * Disclaimer
 * ================================================================================
 * THIS SOFTWARE IS DISTRIBUTED "AS-IS" WITHOUT ANY WARRANTIES, CONDITIONS AND
 * REPRESENTATIONS WHETHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION THE
 * IMPLIED WARRANTIES AND CONDITIONS OF MERCHANTABILITY, MERCHANTABLE QUALITY,
 * FITNESS FOR A PARTICULAR PURPOSE, DURABILITY, NON-INFRINGEMENT, PERFORMANCE AND
 * THOSE ARISING BY STATUTE OR FROM CUSTOM OR USAGE OF TRADE OR COURSE OF DEALING.
 * ================================================================================
 */
package com.gawkat.customtheme.client.base.window;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.dom.XElement;
import com.gawkat.customtheme.client.base.panel.Css3FramedPanelAppearance;
import com.sencha.gxt.widget.core.client.Window.WindowAppearance;

public class Css3WindowAppearance extends Css3FramedPanelAppearance implements WindowAppearance {

  public interface Css3WindowResources extends Css3FramedPanelResources {
    @Override
    @Source("Css3Window.gss")
    Css3WindowStyle style();
  }

  public interface Css3WindowStyle extends Css3FramedPanelStyle {
    String ghost();
  }

  private final Css3WindowResources resources;

  private final Css3WindowStyle style;

  public Css3WindowAppearance() {
    this(GWT.<Css3WindowResources>create(Css3WindowResources.class));
  }

  public Css3WindowAppearance(Css3WindowResources resources) {
    this(resources, GWT.<FramedPanelTemplate>create(FramedPanelTemplate.class));
  }

  public Css3WindowAppearance(Css3WindowResources resources, FramedPanelTemplate template) {
    super(resources, template);
    this.resources = resources;
    this.style = this.resources.style();
  }

  @Override
  public int getFrameHeight(XElement parent) {
    return Math.max(theme.window().borderRadius(), theme.window().border().top())
        + Math.max(theme.window().borderRadius(), theme.window().border().bottom());
  }

  @Override
  public int getFrameWidth(XElement parent) {
    return Math.max(theme.window().borderRadius(), theme.window().border().left())
        + Math.max(theme.window().borderRadius(), theme.window().border().right());
  }

  @Override
  public String ghostClass() {
    return style.ghost();
  }

}
