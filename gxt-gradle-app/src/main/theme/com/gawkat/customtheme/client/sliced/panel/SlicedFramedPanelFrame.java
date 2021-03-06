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
package com.gawkat.customtheme.client.sliced.panel;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.core.client.util.Size;
import com.sencha.gxt.theme.base.client.frame.CollapsibleFrame;

public class SlicedFramedPanelFrame implements CollapsibleFrame {
  public interface Style extends CssResource {
    String outer();

    String borderTopLeft();
    String borderTopRight();
    String borderTop();

    String contentLeft();
    String contentRight();

    String headerContent();

    String bodyContent();

    String borderBottomLeft();
    String borderBottomRight();
    String borderBottom();
  }
  public interface Resources extends ClientBundle {
    Style style();
    ImageResource topLeftBorder();
    ImageResource topRightBorder();
    ImageResource topBorder();

    ImageResource bottomLeftBorder();
    ImageResource bottomRightBorder();
    ImageResource bottomBorder();

    ImageResource leftBorder();
    ImageResource rightBorder();
  }

  public interface Template extends XTemplates {
    @XTemplate(source = "SlicedFramedPanelFrame.html")
    SafeHtml render(Style style, SafeHtml content);
  }

  private final Template template;
  private final Resources resources;

  public SlicedFramedPanelFrame(Resources resources) {
    this(resources, GWT.<Template>create(Template.class));
  }

  public SlicedFramedPanelFrame(Resources resources, Template template) {
    this.resources = resources;
    this.template = template;

    StyleInjectorHelper.ensureInjected(this.resources.style(), true);
  }

  @Override
  public XElement getCollapseElem(XElement parent) {
    return getContentElem(parent);
  }

  @Override
  public XElement getContentElem(XElement parent) {
    return parent.child("." + resources.style().bodyContent());
  }

  @Override
  public Size getFrameSize(XElement parent) {
    int h = resources.topLeftBorder().getHeight();
    int w = resources.topLeftBorder().getWidth();

    // EXTGWT-2074 workaround for framed content panel where header is part of
    // the frame
    // we assume if frame height > frame width then we have a header which
    // clears frame height
    if (h > w) {
      if (parent == null || !getHeaderElem(parent).isVisible()) {
        h = parent.getFirstChildElement().<XElement>cast().getFrameSize().getHeight();
      } else {
        h = getHeaderElem(parent).getOffsetHeight();
      }
    }

    // we can't get height of topBorder as it is includes the header, using
    // width of topLeftBorder assuming equally rounded corners
    return new Size(resources.leftBorder().getWidth() + resources.rightBorder().getWidth(), h
            + resources.bottomBorder().getHeight());  }

  @Override
  public XElement getHeaderElem(XElement parent) {
    return parent.child("." + resources.style().headerContent());
  }

  @Override
  public void onFocus(XElement parent, boolean focus) {
  }

  @Override
  public void onHideHeader(XElement parent, boolean hide) {
    getHeaderElem(parent).setVisible(!hide);
  }

  @Override
  public void onOver(XElement parent, boolean over) {
  }

  @Override
  public void onPress(XElement parent, boolean pressed) {
  }

  @Override
  public String overClass() {
    return null;
  }

  @Override
  public String pressedClass() {
    return null;
  }

  @Override
  public void render(SafeHtmlBuilder builder, FrameOptions options, SafeHtml content) {
    builder.append(template.render(resources.style(), content));
  }
}
