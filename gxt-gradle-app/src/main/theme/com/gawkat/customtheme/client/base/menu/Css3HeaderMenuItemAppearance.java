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
package com.gawkat.customtheme.client.base.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.menu.HeaderMenuItem.HeaderMenuItemAppearance;

public class Css3HeaderMenuItemAppearance implements HeaderMenuItemAppearance {

  public interface Css3HeaderMenuItemResources extends ClientBundle {
    @Source("Css3HeaderMenuItem.gss")
    Css3HeaderMenuItemStyle headerStyle();

    ThemeDetails theme();
  }

  public interface Css3HeaderMenuItemStyle extends CssResource {

    public String menuText();

  }

  private Css3HeaderMenuItemStyle style;

  public Css3HeaderMenuItemAppearance() {
    this(GWT.<Css3HeaderMenuItemResources>create(Css3HeaderMenuItemResources.class));
  }

  public Css3HeaderMenuItemAppearance(Css3HeaderMenuItemResources resources) {
    this.style = resources.headerStyle();
    StyleInjectorHelper.ensureInjected(this.style, true);
  }

  @Override
  public void applyItemStyle(Element element) {
    element.addClassName(style.menuText());
  }

  @Override
  public void onActivate(XElement parent) {
  }

  @Override
  public void onDeactivate(XElement parent) {
  }
}
