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
package com.gawkat.customtheme.client.base.tabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.widget.core.client.PlainTabPanel.PlainTabPanelAppearance;

/**
 *
 */
public class Css3PlainTabPanelAppearance extends Css3TabPanelAppearance implements PlainTabPanelAppearance {

  public interface Css3PlainTabPanelResources extends Css3TabPanelResources {
    @Override
    @Source({"Css3TabPanel.gss", "Css3PlainTabPanel.gss"})
    Css3PlainTabPanelStyle style();

    ImageResource activePlainTabClose();

    ImageResource activePlainTabCloseOver();

    ImageResource plainTabClose();

    ImageResource plainTabCloseOver();
  }

  public interface Css3PlainTabPanelStyle extends Css3TabPanelStyle {

    String tabStripSpacer();
  }

  public interface Css3PlainTabPanelTemplates extends Css3TabPanelTemplates {
    @Override
    @XTemplate(source = "Css3TabPanel.html")
    SafeHtml render(Css3TabPanelStyle style);

    @XTemplate(source = "Css3PlainTabPanel.html")
    SafeHtml renderPlain(Css3PlainTabPanelStyle style);
  }

  private final Css3PlainTabPanelTemplates template;
  private final Css3PlainTabPanelStyle style;

  public Css3PlainTabPanelAppearance() {
    this(GWT.<Css3PlainTabPanelResources>create(Css3PlainTabPanelResources.class));
  }

  public Css3PlainTabPanelAppearance(Css3PlainTabPanelResources resources) {
    this(resources, GWT.<Css3PlainTabPanelTemplates>create(Css3PlainTabPanelTemplates.class));
  }

  public Css3PlainTabPanelAppearance(Css3PlainTabPanelResources resources, Css3PlainTabPanelTemplates template) {
    super(resources, template);
    this.style = resources.style();
    this.template = template;
  }

  @Override
  public void render(SafeHtmlBuilder builder) {
    builder.append(template.renderPlain(style));
  }
}
