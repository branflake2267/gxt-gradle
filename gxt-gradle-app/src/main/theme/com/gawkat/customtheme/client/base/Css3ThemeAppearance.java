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
package com.gawkat.customtheme.client.base;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.core.client.resources.ThemeStyles.Styles;
import com.sencha.gxt.core.client.resources.ThemeStyles.ThemeAppearance;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

/**
 *
 */
public class Css3ThemeAppearance implements ThemeAppearance {

  public interface Css3ThemeResources extends ClientBundle {
    @Source("Css3Theme.gss")
    Css3ThemeStyles style();

    ThemeDetails theme();
  }

  public interface Css3ThemeStyles extends Styles {

  }


  private final Css3ThemeStyles style;
  private final Css3ThemeResources resources;

  public Css3ThemeAppearance() {
    this(GWT.<Css3ThemeResources>create(Css3ThemeResources.class));
  }

  public Css3ThemeAppearance(Css3ThemeResources resources) {
    this.resources = resources;
    this.style = resources.style();

    StyleInjectorHelper.ensureInjected(style, true);
  }


  @Override
  public Styles style() {
    return style;
  }

  @Override
  public String borderColor() {
    return resources.theme().borderColor();
  }

  @Override
  public String borderColorLight() {
    return resources.theme().borderColor();
  }

  @Override
  public String backgroundColorLight() {
    return resources.theme().backgroundColor();
  }
}
