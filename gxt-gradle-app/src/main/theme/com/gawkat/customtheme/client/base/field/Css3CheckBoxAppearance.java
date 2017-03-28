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
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.cell.core.client.form.CheckBoxCell;
import com.sencha.gxt.core.client.GXT;
import com.sencha.gxt.core.client.dom.XDOM;
import com.sencha.gxt.core.client.dom.XElement;

public class Css3CheckBoxAppearance extends Css3ValueBaseFieldAppearance implements CheckBoxCell.CheckBoxAppearance {

  public interface Css3CheckBoxResources extends Css3ValueBaseFieldResources, ClientBundle {
    @Source({"Css3ValueBaseField.gss", "Css3CheckBox.gss"})
    Css3CheckBoxStyle style();

    ImageResource checked();

    ImageResource unchecked();
  }

  public interface Css3CheckBoxStyle extends Css3ValueBaseFieldStyle {
    String checkBoxLabel();
  }

  protected final Css3CheckBoxResources resources;
  protected final Css3CheckBoxStyle style;
  protected String type = "checkbox";

  public Css3CheckBoxAppearance() {
    this(GWT.<Css3CheckBoxResources> create(Css3CheckBoxResources.class));
  }

  public Css3CheckBoxAppearance(Css3CheckBoxResources resources) {
    super(resources);
    this.resources = resources;
    this.style = resources.style();
  }

  @Override
  public void render(SafeHtmlBuilder sb, Boolean value, CheckBoxCell.CheckBoxCellOptions options) {
    String checkBoxId = XDOM.getUniqueId();

    String nameParam = options.getName() != null ? " name='" + options.getName() + "' " : "";
    String disabledParam = options.isDisabled() ? " disabled=true" : "";
    String readOnlyParam = options.isReadonly() ? " readonly" : "";
    String idParam = " id=" + checkBoxId;
    String typeParam = " type=" + type;
    String checkedParam = value ? " checked" : "";

    sb.appendHtmlConstant("<div class=" + style.wrap() + ">");
    sb.appendHtmlConstant("<input " + typeParam + nameParam + disabledParam + readOnlyParam + idParam + checkedParam + " />");
    // on IE11, clicking the checkbox label fires an event for both the label and the input.
    final String labelHtml;
    if (GXT.isIE11()) {
      labelHtml = "<label class=" + style.checkBoxLabel() + ">";
    } else {
      labelHtml = "<label for=" + checkBoxId + " class=" + style.checkBoxLabel() + ">";
    }
    sb.appendHtmlConstant(labelHtml);
    if (options.getBoxLabel() != null) {
      sb.append(options.getBoxLabel());
    }
    sb.appendHtmlConstant("</label></div>");
  }

  @Override
  public void setBoxLabel(SafeHtml boxLabel, XElement parent) {
    parent.selectNode("." + resources.style().checkBoxLabel()).<LabelElement> cast().setInnerSafeHtml(boxLabel);
  }

  @Override
  public XElement getInputElement(Element parent) {
    return parent.<XElement> cast().selectNode("input");
  }

  @Override
  public void setReadOnly(Element parent, boolean readOnly) {
    getInputElement(parent).<InputElement> cast().setReadOnly(readOnly);
  }

  @Override
  public void onEmpty(Element parent, boolean empty) {

  }

  @Override
  public void onFocus(Element parent, boolean focus) {
    // Override method to prevent outline from being applied to check boxes on
    // focus
  }

  @Override
  public void onValid(Element parent, boolean valid) {
    // no-op, cb is true or false...
  }
}
