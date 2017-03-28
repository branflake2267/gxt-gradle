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
package com.gawkat.customtheme.client.base.panel;


import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

/**
 */
public class Css3HeaderAppearance extends HeaderDefaultAppearance {

  public interface Css3HeaderStyle extends HeaderStyle {
    @Override
    String header();

    @Override
    String headerBar();

    @Override
    String headerHasIcon();

    @Override
    String headerIcon();

    @Override
    String headerText();
  }

  public interface Css3HeaderResources extends HeaderResources {

    @Override
    @Source({"com/sencha/gxt/theme/base/client/widget/Header.gss", "Css3Header.gss"})
    Css3HeaderStyle style();
    
    ThemeDetails theme();
  }
  
  public Css3HeaderAppearance() {
    this(GWT.<Css3HeaderResources>create(Css3HeaderResources.class));
  }

  public Css3HeaderAppearance(Css3HeaderResources resources) {
    super(resources);
  }
}
