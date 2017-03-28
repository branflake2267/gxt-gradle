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

import com.google.gwt.core.client.GWT;
import com.gawkat.customtheme.client.base.panel.Css3ContentPanelAppearance;
import com.gawkat.customtheme.client.base.panel.Css3HeaderAppearance;
import com.gawkat.customtheme.client.base.panel.Css3HeaderAppearance.Css3HeaderResources;
import com.gawkat.customtheme.client.base.panel.Css3HeaderAppearance.Css3HeaderStyle;
import com.sencha.gxt.widget.core.client.Header.HeaderAppearance;
import com.sencha.gxt.widget.core.client.button.IconButton.IconConfig;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;

public class Css3AccordionLayoutAppearance extends Css3ContentPanelAppearance implements AccordionLayoutAppearance {

  public interface Css3AccordionResources extends Css3ContentPanelResources {
    @Override
    @Source({"Css3AccordionLayout.gss"})
    Css3AccordionStyle style();
  }

  public interface Css3AccordionStyle extends Css3ContentPanelStyle {

  }

  public interface Css3AccordionHeaderStyle extends Css3HeaderStyle {

  }

  public interface Css3AccordionHeaderResources extends Css3HeaderResources {
    @Override
    @Source({"com/sencha/gxt/theme/base/client/widget/Header.gss", "Css3AccordionLayoutHeader.gss"})
    Css3AccordionHeaderStyle style();
  }

  public Css3AccordionLayoutAppearance() {
    this(GWT.<Css3AccordionResources>create(Css3AccordionResources.class));
  }

  public Css3AccordionLayoutAppearance(Css3AccordionResources resources) {
    this(resources, GWT.<Css3ContentPanelTemplate>create(Css3ContentPanelTemplate.class));
  }

  public Css3AccordionLayoutAppearance(Css3AccordionResources resources, Css3ContentPanelTemplate template) {
    super(resources, template);
  }

  @Override
  public HeaderAppearance getHeaderAppearance() {
    return new Css3HeaderAppearance(GWT.<Css3AccordionHeaderResources>create(Css3AccordionHeaderResources.class));
  }

  @Override
  public IconConfig collapseIcon() {
    return ToolButton.MINUS;
  }

  @Override
  public IconConfig expandIcon() {
    return ToolButton.PLUS;
  }
}
