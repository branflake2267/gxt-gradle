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
package com.gawkat.customtheme.client.sliced.tabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.widget.core.client.TabPanel.TabPanelBottomAppearance;

/**
 *
 */
public class SlicedTabPanelBottomAppearance extends SlicedTabPanelAppearance implements TabPanelBottomAppearance {

  public interface SlicedTabPanelBottomTemplate extends XTemplates {
    @XTemplate(source = "SlicedTabPanelBottom.html")
    SafeHtml render(SlicedTabPanelBottomStyle style);
  }

  public interface SlicedTabPanelBottomResources extends SlicedTabPanelResources {
    @Source("SlicedTabPanelBottom.gss")
    @Override
    SlicedTabPanelBottomStyle style();

    @Override
    @Source("inactive-bottom-tab-l.png")
    ImageResource tabLeft();


    @Override
    @Source("bottom-tab-l.png")
    ImageResource tabLeftOver();

    @Override
    @Source("bottom-tab-l.png")
    ImageResource tabLeftActive();

    @Override
    @Source("inactive-bottom-tab-r.png")
    ImageResource tabRight();

    @Override
    @Source("bottom-tab-r.png")
    ImageResource tabRightOver();

    @Override
    @Source("bottom-tab-r.png")
    ImageResource tabRightActive();

    @Override
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("inactive-bottom-tab-bg.png")
    ImageResource tabCenter();

    @Override
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("bottom-tab-bg.png")
    ImageResource tabCenterOver();

    @Override
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("bottom-tab-bg.png")
    ImageResource tabCenterActive();


    @Override
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("bottom-tab-strip-bg.png")
    ImageResource tabStripBackground();
  }

  public interface SlicedTabPanelBottomStyle extends SlicedTabPanelStyle {
  }

  private final SlicedTabPanelBottomTemplate template;
  private final SlicedTabPanelBottomStyle style;

  public SlicedTabPanelBottomAppearance() {
    this(GWT.<SlicedTabPanelBottomResources>create(SlicedTabPanelBottomResources.class));
  }

  public SlicedTabPanelBottomAppearance(SlicedTabPanelBottomResources resources) {
    this(resources, GWT.<SlicedTabPanelBottomTemplate>create(SlicedTabPanelBottomTemplate.class));
  }

  public SlicedTabPanelBottomAppearance(SlicedTabPanelBottomResources resources, SlicedTabPanelBottomTemplate template) {
    super(resources);
    this.template = template;
    this.style = resources.style();
  }

  @Override
  public XElement getBar(XElement parent) {
    return parent.getLastChild().cast();
  }

  @Override
  public void render(SafeHtmlBuilder builder) {
    builder.append(template.render((SlicedTabPanelBottomStyle) style));
  }
}
