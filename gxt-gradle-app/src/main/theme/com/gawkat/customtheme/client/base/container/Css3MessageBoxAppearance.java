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
package com.gawkat.customtheme.client.base.container;

import com.google.gwt.core.shared.GWT;
import com.sencha.gxt.theme.base.client.container.MessageBoxDefaultAppearance;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

public class Css3MessageBoxAppearance extends MessageBoxDefaultAppearance {
  public interface Css3MessageBoxResources extends MessageBoxResources {
    @Override
    @Source("Css3MessageBox.gss")
    Css3MessageBoxStyles style();

    ThemeDetails theme();
  }

  public interface Css3MessageBoxStyles extends MessageBoxBaseStyle {

  }

  public Css3MessageBoxAppearance() {
    this(GWT.<Css3MessageBoxResources>create(Css3MessageBoxResources.class));
  }

  public Css3MessageBoxAppearance(Css3MessageBoxResources resources) {
    super(resources);
  }
}
