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
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.widget.core.client.PlainTabPanel.PlainTabPanelBottomAppearance;

/**
 *
 */
public class Css3PlainTabPanelBottomAppearance extends Css3TabPanelBottomAppearance implements PlainTabPanelBottomAppearance {

  public interface Css3PlainTabPanelBottomResources extends Css3TabPanelBottomResources {
    @Override
    @Source({"Css3TabPanelBottom.gss", "Css3PlainTabPanelBottom.gss"})
    Css3PlainTabPanelBottomStyle style();

    ImageResource plainTabClose();

    ImageResource plainTabCloseOver();
  }

  public interface Css3PlainTabPanelBottomStyle extends Css3TabPanelBottomStyle {
    String tabStripSpacer();
  }

  public interface Css3PlainTabPanelBottomTemplates extends XTemplates {
    @XTemplate(source = "Css3PlainTabPanelBottom.html")
    SafeHtml render(Css3PlainTabPanelBottomStyle style);
  }

  private final Css3PlainTabPanelBottomTemplates template;
  private final Css3PlainTabPanelBottomStyle style;

  public Css3PlainTabPanelBottomAppearance() {
    this(GWT.<Css3PlainTabPanelBottomResources>create(Css3PlainTabPanelBottomResources.class));
  }

  public Css3PlainTabPanelBottomAppearance(Css3PlainTabPanelBottomResources resources) {
    this(resources, GWT.<Css3PlainTabPanelBottomTemplates>create(Css3PlainTabPanelBottomTemplates.class));
  }

  public Css3PlainTabPanelBottomAppearance(Css3PlainTabPanelBottomResources resources, Css3PlainTabPanelBottomTemplates template) {
    super(resources);
    this.style = resources.style();
    this.template = template;
  }

  @Override
  public void render(SafeHtmlBuilder builder) {
    builder.append(template.render(style));
  }
}
