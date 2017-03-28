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
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.widget.core.client.PlainTabPanel.PlainTabPanelBottomAppearance;

/**
 *
 */
public class SlicedPlainTabPanelBottomAppearance extends SlicedTabPanelBottomAppearance implements PlainTabPanelBottomAppearance {

  public interface SlicedPlainTabPanelBottomResources extends SlicedTabPanelBottomResources {
    @Override
    @Source({"SlicedTabPanelBottom.gss", "SlicedPlainTabPanelBottom.gss"})
    SlicedPlainTabPanelBottomStyle style();
  }

  public interface SlicedPlainTabPanelBottomStyle extends SlicedTabPanelBottomStyle {
    String tabStripSpacer();
  }

  public interface SlicedPlainTabPanelBottomTemplates extends XTemplates {
    @XTemplate(source = "SlicedPlainTabPanelBottom.html")
    SafeHtml render(SlicedPlainTabPanelBottomStyle style);
  }

  private final SlicedPlainTabPanelBottomTemplates template;
  private final SlicedPlainTabPanelBottomStyle style;

  public SlicedPlainTabPanelBottomAppearance() {
    this(GWT.<SlicedPlainTabPanelBottomResources>create(SlicedPlainTabPanelBottomResources.class));
  }

  public SlicedPlainTabPanelBottomAppearance(SlicedPlainTabPanelBottomResources resources) {
    this(resources, GWT.<SlicedPlainTabPanelBottomTemplates>create(SlicedPlainTabPanelBottomTemplates.class));
  }

  public SlicedPlainTabPanelBottomAppearance(SlicedPlainTabPanelBottomResources resources, SlicedPlainTabPanelBottomTemplates template) {
    super(resources);
    this.style = resources.style();
    this.template = template;
  }


  @Override
  public void render(SafeHtmlBuilder builder) {
    builder.append(template.render(style));
  }
}
