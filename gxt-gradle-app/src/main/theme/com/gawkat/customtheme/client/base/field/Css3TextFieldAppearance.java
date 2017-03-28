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
package com.gawkat.customtheme.client.base.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.cell.core.client.form.FieldCell.FieldAppearanceOptions;
import com.sencha.gxt.cell.core.client.form.TextInputCell.TextFieldAppearance;
import com.sencha.gxt.core.client.GXT;
import com.sencha.gxt.core.client.dom.XElement;

public class Css3TextFieldAppearance extends Css3ValueBaseFieldAppearance implements TextFieldAppearance {

  public interface Css3TextFieldResources extends Css3ValueBaseFieldResources, ClientBundle {

    @Override
    @Source({"Css3ValueBaseField.gss", "Css3TextField.gss"})
    Css3TextFieldStyle style();
  }

  public interface Css3TextFieldStyle extends Css3ValueBaseFieldStyle {

    String area();

    String file();

    String text();

  }

  private final Css3TextFieldStyle style;

  public Css3TextFieldAppearance() {
    this(GWT.<Css3TextFieldResources>create(Css3TextFieldResources.class));
  }

  public Css3TextFieldAppearance(Css3TextFieldResources resources) {
    super(resources);
    this.style = resources.style();
  }

  @Override
  public XElement getInputElement(Element parent) {
    return parent.getFirstChildElement().getFirstChildElement().cast();
  }

  @Override
  public void onResize(XElement parent, int width, int height) {
    Element wrap = parent.getFirstChildElement();

    if (width != -1 && width > 0) {
      wrap.getStyle().setPropertyPx("width", width);

      width = adjustTextAreaWidth(width);

      if (width > 0) {
        getInputElement(parent).getStyle().setPropertyPx("width", width);
      }
    }
  }

  @Override
  public void render(SafeHtmlBuilder sb, String type, String value, FieldAppearanceOptions options) {
    String inputStyles = "";
    String wrapStyles = "";

    int width = options.getWidth();

    String name = options.getName() != null ? " name='" + options.getName() + "' " : "";
    String disabled = options.isDisabled() ? "disabled=true" : "";
    String placeholder = options.getEmptyText() != null ? " placeholder='" + SafeHtmlUtils.htmlEscape(options.getEmptyText()) + "' " : "";

    boolean empty = false;

    if ((value == null || value.equals("")) && options.getEmptyText() != null) {
      if (GXT.isIE8() || GXT.isIE9()) {
        value = options.getEmptyText();
      }
      empty = true;
    }

    if (width != -1) {
      wrapStyles += "width:" + width + "px;";
      width = adjustTextAreaWidth(width);
      inputStyles += "width:" + width + "px;";
    }

    String cls = style.text() + " " + style.field();
    if (empty) {
      cls += " " + style.empty();
    }

    String ro = options.isReadonly() ? " readonly" : "";

    value = SafeHtmlUtils.htmlEscape(value);

    sb.appendHtmlConstant("<div style='" + wrapStyles + "' class='" + style.wrap() + "'>");
    sb.appendHtmlConstant("<input " + name + disabled + " value='" + value + "' style='" + inputStyles + "' type='"
        + type + "' class='" + cls + "'" + ro + placeholder + ">");
    sb.appendHtmlConstant("</div>");

  }

  protected int adjustTextAreaWidth(int width) {
    // 6px margin, 2px border  FIXME
    if (width != -1) {
      width = Math.max(0, width); // - 8
    }
    return width;
  }
}
