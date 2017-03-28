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
package com.gawkat.customtheme.client.base.mask;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.core.client.GXT;
import com.sencha.gxt.core.client.dom.Mask.MaskAppearance;
import com.sencha.gxt.core.client.dom.Mask.MaskDefaultAppearance.MaskStyle;
import com.sencha.gxt.core.client.dom.Mask.MessageTemplates;
import com.sencha.gxt.core.client.dom.XDOM;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

public class Css3MaskAppearance implements MaskAppearance {

  public interface Css3MaskResources extends ClientBundle {
    @Source("Css3Mask.gss")
    Css3MaskStyles styles();

    @Source("com/sencha/gxt/theme/base/client/grid/loading.gif")
    ImageResource loading();

    ThemeDetails theme();
  }

  public interface Css3MaskStyles extends MaskStyle {

  }

  private final Css3MaskResources resources;
  private final MessageTemplates template;

  public Css3MaskAppearance() {
    this(GWT.<Css3MaskResources>create(Css3MaskResources.class));
  }

  public Css3MaskAppearance(Css3MaskResources resources) {
    this(resources, GWT.<MessageTemplates>create(MessageTemplates.class));
  }

  public Css3MaskAppearance(Css3MaskResources resources, MessageTemplates template) {
    this.resources = resources;
    this.template = template;
    StyleInjectorHelper.ensureInjected(resources.styles(), true);
  }

  @Override
  public void mask(XElement parent, String message) {
    XElement mask = XElement.createElement("div");
    mask.setClassName(resources.styles().mask());
    parent.appendChild(mask);

    XElement box = null;
    if (message != null) {
      box = XDOM.create(template.template(resources.styles(), SafeHtmlUtils.htmlEscape(message))).cast();
      parent.appendChild(box);
    }

    if (GXT.isIE() && "auto".equals(parent.getStyle().getHeight())) {
      mask.setSize(parent.getOffsetWidth(), parent.getOffsetHeight());
    }

    if (box != null) {
      box.updateZIndex(0);
      box.center(parent);
    }

  }

  @Override
  public String masked() {
    return resources.styles().masked();
  }

  @Override
  public String positioned() {
    return resources.styles().positioned();
  }

  @Override
  public void unmask(XElement parent) {
    XElement mask = parent.selectNode("> ." + resources.styles().mask());
    if (mask != null) {
      mask.removeFromParent();
    }
    XElement box = parent.selectNode("> ." + resources.styles().box());
    if (box != null) {
      box.removeFromParent();
    }
  }
}
