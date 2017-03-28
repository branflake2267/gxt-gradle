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
package com.gawkat.customtheme.client.sliced.mask;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.core.client.GXT;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.dom.Mask.MaskAppearance;
import com.sencha.gxt.core.client.dom.XDOM;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.theme.base.client.frame.DivFrame;
import com.sencha.gxt.theme.base.client.frame.DivFrame.DivFrameResources;
import com.sencha.gxt.theme.base.client.frame.DivFrame.DivFrameStyle;
import com.sencha.gxt.theme.base.client.frame.Frame;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

public class SlicedMaskAppearance implements MaskAppearance {
  public interface SlicedMaskTemplate extends XTemplates {
    @XTemplate("<div class=\"{style.text}\">{message}</div>")
    SafeHtml template(SlicedMaskStyles style, String message);
  }

  public interface SlicedMaskResources extends DivFrameResources, ClientBundle {
    @Override
    @Source({"com/sencha/gxt/theme/base/client/frame/DivFrame.gss", "SlicedMask.gss"})
    SlicedMaskStyles style();

    @Source("com/sencha/gxt/theme/base/client/grid/loading.gif")
    ImageResource loading();

    @Source("background.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource background();

    @Override
    @Source("corner-bc.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource bottomBorder();

    @Override
    @Source("corner-bl.png")
    ImageResource bottomLeftBorder();

    @Override
    @Source("corner-br.png")
    ImageResource bottomRightBorder();

    @Override
    @Source("side-l.png")
    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    ImageResource leftBorder();

    @Override
    @Source("side-r.png")
    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    ImageResource rightBorder();

    @Override
    @Source("corner-tc.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource topBorder();

    @Override
    @Source("corner-tl.png")
    ImageResource topLeftBorder();

    @Override
    @Source("corner-tr.png")
    ImageResource topRightBorder();

    ThemeDetails theme();
  }

  public interface SlicedMaskStyles extends DivFrameStyle {
    String mask();

    String text();

    String masked();

    String positioned();
  }

  private final SlicedMaskResources resources;
  private final DivFrame frame;
  private final SlicedMaskTemplate template;

  public SlicedMaskAppearance() {
    this(GWT.<SlicedMaskResources>create(SlicedMaskResources.class));
  }

  public SlicedMaskAppearance(SlicedMaskResources resources) {
    this(resources, GWT.<SlicedMaskTemplate>create(SlicedMaskTemplate.class));
  }

  public SlicedMaskAppearance(SlicedMaskResources resources, SlicedMaskTemplate template) {
    this(resources, template, new DivFrame(resources));
  }

  public SlicedMaskAppearance(SlicedMaskResources resources, SlicedMaskTemplate template, DivFrame frame) {
    this.resources = resources;
    this.template = template;
    this.frame = frame;

    StyleInjectorHelper.ensureInjected(resources.style(), true);
  }

  @Override
  public void mask(XElement parent, String message) {
    XElement mask = XElement.createElement("div");
    mask.setClassName(resources.style().mask());
    parent.appendChild(mask);

    XElement box = null;
    if (message != null) {
      SafeHtmlBuilder sb = new SafeHtmlBuilder();
      SafeHtml content = template.template(resources.style(), SafeHtmlUtils.htmlEscape(message));
      frame.render(sb, Frame.EMPTY_FRAME, content);
      box = XDOM.create(sb.toSafeHtml()).cast();
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
    return resources.style().masked();
  }

  @Override
  public String positioned() {
    return resources.style().positioned();
  }

  @Override
  public void unmask(XElement parent) {
    XElement mask = parent.selectNode("> ." + resources.style().mask());
    if (mask != null) {
      mask.removeFromParent();
    }
    XElement box = parent.selectNode("> ." + resources.style().contentArea());
    if (box != null) {
      box.removeFromParent();
    }
  }
}
