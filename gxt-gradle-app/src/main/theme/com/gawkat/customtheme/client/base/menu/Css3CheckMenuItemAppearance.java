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
package com.gawkat.customtheme.client.base.menu;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.widget.core.client.menu.CheckMenuItem.CheckMenuItemAppearance;

public class Css3CheckMenuItemAppearance extends Css3MenuItemAppearance implements CheckMenuItemAppearance {

  public interface Css3CheckMenuItemResources extends Css3MenuItemResources {
    ImageResource checked();

    ImageResource unchecked();

    ImageResource groupChecked();
  }

  private final Css3CheckMenuItemResources resources;

  @Override
  public void applyChecked(XElement parent, boolean state) {
  }

  @Override
  public XElement getCheckIcon(XElement parent) {
    return parent.<XElement>cast().selectNode("." + resources.style().menuItemIcon());
  }

  @Override
  public ImageResource checked() {
    return resources.checked();
  }

  @Override
  public ImageResource unchecked() {
    return resources.unchecked();
  }

  @Override
  public ImageResource radio() {
    return resources.groupChecked();
  }

  public Css3CheckMenuItemAppearance() {
    this(GWT.<Css3CheckMenuItemResources>create(Css3CheckMenuItemResources.class));
  }

  public Css3CheckMenuItemAppearance(Css3CheckMenuItemResources resources) {
    this(resources, GWT.<MenuItemTemplate>create(MenuItemTemplate.class));
  }

  public Css3CheckMenuItemAppearance(Css3CheckMenuItemResources resources, MenuItemTemplate template) {
    super(resources, template);
    this.resources = resources;
  }
}
