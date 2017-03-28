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
package com.gawkat.customtheme.client.base.toolbar;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.gawkat.customtheme.client.base.container.Css3HBoxLayoutContainerAppearance;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar.ToolBarAppearance;

/**
 *
 */
public class Css3ToolBarAppearance extends Css3HBoxLayoutContainerAppearance implements ToolBarAppearance {

  public interface Css3ToolBarResources extends Css3HBoxLayoutContainerResources {
    @Source({"com/sencha/gxt/theme/base/client/container/BoxLayout.gss", "com/gawkat/customtheme/client/base/container/Css3HBoxLayoutContainer.gss", "Css3ToolBar.gss"})
    Css3ToolBarStyle style();

    ThemeDetails theme();
  }

  public interface Css3ToolBarStyle extends Css3HBoxLayoutContainerStyle {
    String toolBar();
  }

  @Override
  public String toolBarClassName() {
    return style.toolBar();
  }


  private final Css3ToolBarResources resources;
  private final Css3ToolBarStyle style;

  public Css3ToolBarAppearance() {
    this(GWT.<Css3ToolBarResources>create(Css3ToolBarResources.class));
  }

  public Css3ToolBarAppearance(Css3ToolBarResources resources) {
    this.resources = resources;
    this.style = this.resources.style();

    StyleInjectorHelper.ensureInjected(this.style, true);
  }
}
