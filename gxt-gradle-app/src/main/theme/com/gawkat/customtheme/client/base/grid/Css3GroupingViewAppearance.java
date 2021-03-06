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
package com.gawkat.customtheme.client.base.grid;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.CssResource.Import;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.theme.base.client.grid.GroupingViewDefaultAppearance;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.grid.GridView.GridStateStyles;

public class Css3GroupingViewAppearance extends GroupingViewDefaultAppearance {

  public interface Css3GroupingViewResources extends GroupingViewResources {

    @Override
    ImageResource groupBy();

    ImageResource expand();

    ImageResource collapse();

    @Override
    @Import(GridStateStyles.class)
    @Source("Css3GroupingView.gss")
    Css3GroupingViewStyle style();

    ThemeDetails theme();
  }

  public interface Css3GroupingViewStyle extends GroupingViewStyle {

  }

  public Css3GroupingViewAppearance() {
    this(GWT.<Css3GroupingViewResources>create(Css3GroupingViewResources.class));
  }

  public Css3GroupingViewAppearance(Css3GroupingViewResources resources) {
    super(resources);
  }
}
