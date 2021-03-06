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
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.dom.XDOM;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.core.client.util.IconHelper;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel.TabPanelAppearance;

/**
 *
 */
public class SlicedTabPanelAppearance implements TabPanelAppearance {

  public interface SlicedItemTemplate extends XTemplates {
    @XTemplate(source = "SlicedTabItem.html")
    SafeHtml renderItem(SlicedTabPanelStyle style, TabItemConfig config);

    @XTemplate(source = "SlicedTabPanel.html")
    SafeHtml render(SlicedTabPanelStyle style);
  }

  public interface SlicedTabPanelResources extends ClientBundle {
    @Source({"SlicedTabPanel.gss"})
    SlicedTabPanelStyle style();

    @Source("inactive-tab-l.png")
    ImageResource tabLeft();

    @Source("inactive-tab-r.png")
    @ImageOptions(repeatStyle = RepeatStyle.None)
    ImageResource tabRight();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("inactive-tab-bg.png")
    ImageResource tabCenter();

    @Source("hover-tab-l.png")
    ImageResource tabLeftOver();

    @Source("hover-tab-r.png")
    @ImageOptions(repeatStyle = RepeatStyle.None)
    ImageResource tabRightOver();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("hover-tab-bg.png")
    ImageResource tabCenterOver();

    @Source("tab-l.png")
    ImageResource tabLeftActive();

    @Source("tab-r.png")
    @ImageOptions(repeatStyle = RepeatStyle.None)
    ImageResource tabRightActive();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("tab-bg.png")
    ImageResource tabCenterActive();


    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("tab-strip-bg.png")
    ImageResource tabStripBackground();

    ImageResource scrollerLeft();

    ImageResource scrollerRight();

    ImageResource scrollerLeftOver();

    ImageResource scrollerRightOver();

    @Source("com/gawkat/customtheme/client/base/tabs/scrollerLeft.png")
    ImageResource scrollerLeftArrow();

    @Source("com/gawkat/customtheme/client/base/tabs/scrollerRight.png")
    ImageResource scrollerRightArrow();

    @Source("com/gawkat/customtheme/client/base/tabs/tabClose.png")
    ImageResource tabClose();

    ThemeDetails theme();
  }

  public interface SlicedTabPanelStyle extends CssResource {

    String tab();

    String tabItem();

    String tabBody();

    String tabEdge();

    String tabBar();

    String tabImage();

    String tabLeft();

    String tabRight();

    String tabScrollerLeft();

    String tabScrollerLeftDisabled();

    String tabScrollerLeftOver();

    String tabScrollerRight();

    String tabScrollerRightDisabled();

    String tabScrollerRightOver();

    String tabScrolling();

    String tabStrip();

    String tabStripActive();

    String tabStripClosable();

    String tabStripClose();

    String tabStripInner();

    String tabStripOver();

    String tabStripText();

    String tabStripWrap();

    String tabWithIcon();
  }

  private final SlicedItemTemplate template;
  protected final SlicedTabPanelResources resources;


  public SlicedTabPanelAppearance() {
    this(GWT.<SlicedTabPanelResources>create(SlicedTabPanelResources.class));
  }

  public SlicedTabPanelAppearance(SlicedTabPanelResources resources) {
    this(resources, GWT.<SlicedItemTemplate>create(SlicedItemTemplate.class));
  }

  public SlicedTabPanelAppearance(SlicedTabPanelResources resources, SlicedItemTemplate template) {
    this.resources = resources;
    this.template = template;

    StyleInjectorHelper.ensureInjected(resources.style(), true);
  }

  @Override
  public void createScrollers(XElement parent) {
    int h = getStripWrap(parent).getOffsetHeight();
    SafeHtml html = SafeHtmlUtils.fromTrustedString("<div class='" + resources.style().tabScrollerLeft() + "'></div>");
    XElement scrollLeft = getBar(parent).insertFirst(html);
    scrollLeft.setId(XDOM.getUniqueId());
    scrollLeft.setHeight(h);

    html = SafeHtmlUtils.fromTrustedString("<div class='" + resources.style().tabScrollerRight() + "'></div>");
    XElement scrollRight = getBar(parent).insertFirst(html);
    scrollRight.setId(XDOM.getUniqueId());
    scrollRight.setHeight(h);
  }

  @Override
  public XElement getBar(XElement parent) {
    return parent.getFirstChildElement().cast();
  }

  @Override
  public XElement getBody(XElement parent) {
    return parent.selectNode("." + resources.style().tabBody());
  }

  @Override
  public String getItemSelector() {
    return "li";
  }

  @Override
  public XElement getScrollLeft(XElement parent) {
    return getBar(parent).selectNode("." + resources.style().tabScrollerLeft());
  }

  @Override
  public XElement getScrollRight(XElement parent) {
    return getBar(parent).selectNode("." + resources.style().tabScrollerRight());
  }

  @Override
  public XElement getStripEdge(XElement parent) {
    return getBar(parent).selectNode("." + resources.style().tabEdge());
  }

  @Override
  public XElement getStripWrap(XElement parent) {
    return getBar(parent).selectNode("." + resources.style().tabStripWrap());
  }

  @Override
  public void insert(XElement parent, TabItemConfig config, int index) {
    XElement item = XDOM.create(template.renderItem(resources.style(), config));
    item.setClassName(ThemeStyles.get().style().disabled(), !config.isEnabled());

    getStrip(parent).insertChild(item, index);

    if (config.getIcon() != null) {
      setItemIcon(item, config.getIcon());
    }

    if (config.isClosable()) {
      item.addClassName(resources.style().tabStripClosable());
    }
  }

  private void setItemIcon(XElement item, ImageResource icon) {
    XElement node = item.selectNode("." + resources.style().tabImage());
    if (node != null) {
      node.removeFromParent();
    }
    if (icon != null) {
      Element e = IconHelper.getElement(icon);
      e.setClassName(resources.style().tabImage());
      item.appendChild(e);
    }
    item.setClassName(resources.style().tabWithIcon(), icon != null);
  }

  private XElement getStrip(XElement parent) {
    return getBar(parent).selectNode("." + resources.style().tabStrip());
  }

  @Override
  public boolean isClose(XElement target) {
    return target.is("." + resources.style().tabStripClose());
  }

  @Override
  public void onDeselect(Element item) {
    item.removeClassName(resources.style().tabStripActive());
  }

  @Override
  public void onMouseOut(XElement parent, XElement target) {
    NodeList<Element> nodeList = parent.select("." + resources.style().tabStripOver());
    for (int i = 0; i < nodeList.getLength(); i++) {
      nodeList.getItem(i).removeClassName(resources.style().tabStripOver());
    }
    if (target.is("." + resources.style().tabScrollerLeft())) {
      target.removeClassName(resources.style().tabScrollerLeftOver());
    } else if (target.is("." + resources.style().tabScrollerRight())) {
      target.removeClassName(resources.style().tabScrollerRightOver());
    }
  }

  @Override
  public void onMouseOver(XElement parent, XElement target) {
    Element item = findItem(target);
    if (item != null) {
      item.addClassName(resources.style().tabStripOver());
    } else if (target.is("." + resources.style().tabScrollerLeft())) {
      target.addClassName(resources.style().tabScrollerLeftOver());
    } else if (target.is("." + resources.style().tabScrollerRight())) {
      target.addClassName(resources.style().tabScrollerRightOver());
    }
  }

  @Override
  public void onScrolling(XElement parent, boolean scrolling) {
    parent.selectNode("." + resources.style().tabBar()).setClassName(resources.style().tabScrolling(), scrolling);
  }

  @Override
  public void onSelect(Element item) {
    item.addClassName(resources.style().tabStripActive());
  }

  @Override
  public void render(SafeHtmlBuilder builder) {
    builder.append(template.render(resources.style()));
  }

  @Override
  public void setItemWidth(XElement element, int width) {
    XElement inner = element.selectNode("." + resources.style().tabStripInner());
    int tw = element.getOffsetWidth();
    int iw = inner.getOffsetWidth();
    inner.setWidth(width - (tw - iw));
  }

  @Override
  public void updateItem(XElement item, TabItemConfig config) {
    XElement contentEl = item.selectNode("." + resources.style().tabStripText());
    contentEl.setInnerSafeHtml(config.getContent());

    setItemIcon(item, config.getIcon());

    item.setClassName(ThemeStyles.get().style().disabled(), !config.isEnabled());

    item.setClassName(resources.style().tabStripClosable(), config.isClosable());
  }

  @Override
  public void updateScrollButtons(XElement parent) {
    int pos = getScrollPos(parent);
    getScrollLeft(parent).setClassName(resources.style().tabScrollerLeftDisabled(), pos == 0);
    getScrollRight(parent).setClassName(resources.style().tabScrollerRightDisabled(),
        pos >= (getScrollWidth(parent) - getScrollArea(parent) - 2));
  }

  protected Element findItem(Element target) {
    return target.<XElement>cast().findParentElement(getItemSelector(), -1);
  }

  private int getScrollPos(XElement parent) {
    return getStripWrap(parent).getScrollLeft();
  }

  private int getScrollArea(XElement parent) {
    return Math.max(0, getStripWrap(parent).getClientWidth());
  }

  private int getScrollWidth(XElement parent) {
    return getStripEdge(parent).getOffsetsTo(getStripWrap(parent)).getX() + getScrollPos(parent);
  }
}
