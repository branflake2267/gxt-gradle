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
package com.gawkat.customtheme.client.base.button;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.widget.core.client.button.IconButton.IconButtonAppearance;

public class Css3IconButtonAppearance implements IconButtonAppearance {
  public interface Css3ToolButtonResources extends ClientBundle {
    @Source("Css3IconButton.gss")
    Css3IconButtonStyle style();
  }

  public interface Css3IconButtonStyle extends CssResource {
    String button();
  }

  public interface Template extends XTemplates {
    @XTemplate(source = "Css3IconButton.html")
    SafeHtml render(Css3IconButtonStyle style);
  }

  private final Template template;
  private final Css3IconButtonStyle style;

  public Css3IconButtonAppearance() {
    this(GWT.<Css3ToolButtonResources>create(Css3ToolButtonResources.class));
  }

  public Css3IconButtonAppearance(Css3ToolButtonResources resources) {
    this.style = resources.style();
    StyleInjectorHelper.ensureInjected(this.style, false);

    this.template = GWT.create(Template.class);
  }

  @Override
  public void render(SafeHtmlBuilder sb) {
    sb.append(template.render(style));
  }

  @Override
  public XElement getIconElem(XElement parent) {
    return parent;
  }
}
