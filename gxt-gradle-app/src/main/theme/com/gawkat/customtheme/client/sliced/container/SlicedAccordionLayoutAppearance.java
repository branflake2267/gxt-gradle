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
package com.gawkat.customtheme.client.sliced.container;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.gawkat.customtheme.client.base.container.Css3AccordionLayoutAppearance.Css3AccordionHeaderResources;
import com.gawkat.customtheme.client.base.panel.Css3HeaderAppearance;
import com.gawkat.customtheme.client.base.panel.Css3HeaderAppearance.Css3HeaderResources;
import com.gawkat.customtheme.client.base.panel.Css3HeaderAppearance.Css3HeaderStyle;
import com.gawkat.customtheme.client.sliced.panel.SlicedContentPanelAppearance;
import com.sencha.gxt.widget.core.client.Header.HeaderAppearance;
import com.sencha.gxt.widget.core.client.button.IconButton.IconConfig;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;

public class SlicedAccordionLayoutAppearance extends SlicedContentPanelAppearance implements AccordionLayoutAppearance {
  public interface SlicedAccordionLayoutResources extends SlicedContentPanelResources {
    @Override
    @Source("accordionlayout-background.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource headerBackground();

    @Override
    @Source("SlicedAccordionLayout.gss")
    SlicedAccordionLayoutStyle style();
  }
  public interface SlicedAccordionLayoutStyle extends SlicedContentPanelStyle {

  }

  public interface SlicedAccordionHeaderResources extends Css3HeaderResources {
    @Source("accordionlayout-background.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource headerBackground();

    @Override
    @Source({"com/sencha/gxt/theme/base/client/widget/Header.gss", "SlicedAccordionHeader.gss"})
    SlicedAccordionHeaderStyle style();
  }
  public interface SlicedAccordionHeaderStyle extends Css3HeaderStyle {

  }

  public SlicedAccordionLayoutAppearance() {
    this(GWT.<SlicedAccordionLayoutResources>create(SlicedAccordionLayoutResources.class));
  }

  public SlicedAccordionLayoutAppearance(SlicedAccordionLayoutResources resources) {
    super(resources);
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
