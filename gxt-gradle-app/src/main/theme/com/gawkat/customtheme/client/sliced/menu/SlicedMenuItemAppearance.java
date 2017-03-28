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
package com.gawkat.customtheme.client.sliced.menu;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.gawkat.customtheme.client.base.menu.Css3MenuItemAppearance;

public class SlicedMenuItemAppearance extends Css3MenuItemAppearance {
  public interface SlicedMenuItemResources extends Css3MenuItemResources {

    @Override
    @Source("SlicedMenuItem.gss")
    SlicedMenuItemStyle style();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("menuitem-hover.png")
    ImageResource itemOver();
  }

  public interface SlicedMenuItemStyle extends Css3MenuItemStyle {
  }

  public SlicedMenuItemAppearance() {
    this(GWT.<SlicedMenuItemResources>create(SlicedMenuItemResources.class));
  }

  public SlicedMenuItemAppearance(SlicedMenuItemResources resources) {
    this(resources, GWT.<MenuItemTemplate>create(MenuItemTemplate.class));
  }

  public SlicedMenuItemAppearance(SlicedMenuItemResources resources, MenuItemTemplate template) {
    super(resources, template);
  }
}
