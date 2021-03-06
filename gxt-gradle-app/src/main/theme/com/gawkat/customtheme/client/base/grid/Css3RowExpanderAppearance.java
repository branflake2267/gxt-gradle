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

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.Import;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.grid.GridView.GridStateStyles;
import com.sencha.gxt.widget.core.client.grid.RowExpander.RowExpanderAppearance;

/**
 *
 */
public class Css3RowExpanderAppearance<M> implements RowExpanderAppearance<M> {

  public interface Css3RowExpanderResources extends ClientBundle {
    @Import(GridStateStyles.class)
    @Source({"Css3RowExpander.gss"})
    Css3RowExpanderStyle style();

    ThemeDetails theme();

    ImageResource expand();

    ImageResource collapse();
  }

  public interface Css3RowExpanderStyle extends CssResource {
    String rowCollapsed();

    String rowExpanded();

    String rowExpander();

    String hasExpander();

    String cell();
  }

  private final Css3RowExpanderStyle style;

  public Css3RowExpanderAppearance() {
    this(GWT.<Css3RowExpanderResources>create(Css3RowExpanderResources.class));
  }

  public Css3RowExpanderAppearance(Css3RowExpanderResources resources) {
    this.style = resources.style();

    StyleInjectorHelper.ensureInjected(style, true);
  }

  @Override
  public void finishInit(XElement gridParent) {
    gridParent.addClassName(style.hasExpander());
  }

  @Override
  public String getCellClassName() {
    return style.cell();
  }

  @Override
  public String getRowStyles(M model, int rowIndex) {
    return style.rowCollapsed();
  }

  @Override
  public boolean isExpanded(XElement row) {
    return row.hasClassName(style.rowExpanded());
  }

  @Override
  public void onExpand(XElement row, boolean expand) {
    if (expand) {
      row.replaceClassName(style.rowCollapsed(), style.rowExpanded());
    } else {
      row.replaceClassName(style.rowExpanded(), style.rowCollapsed());
    }
  }

  @Override
  public void renderExpander(Context context, M value, SafeHtmlBuilder sb) {
    sb.appendHtmlConstant("<div class='" + style.rowExpander() + "'>&nbsp;</div>");
  }

  @Override
  public boolean isExpandElement(XElement target) {
    return target.hasClassName(style.rowExpander());
  }
}
