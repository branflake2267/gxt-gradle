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

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.gawkat.customtheme.client.base.menu.Css3MenuBarItemAppearance;

public class SlicedMenuBarItemAppearance extends Css3MenuBarItemAppearance {
  public interface SlicedMenuBarItemResources extends Css3MenuBarItemResources {
    @Override
    @Source("SlicedMenuBarItem.gss")
    SlicedMenuBarItemStyle css();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("menubaritem-hover.png")
    ImageResource itemOver();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("menubaritem-active.png")
    ImageResource itemActive();
  }

  public interface SlicedMenuBarItemStyle extends Css3MenuBarItemStyle {

  }

  public SlicedMenuBarItemAppearance() {
    this(GWT.<SlicedMenuBarItemResources>create(SlicedMenuBarItemResources.class));
  }

  public SlicedMenuBarItemAppearance(SlicedMenuBarItemResources resources) {
    super(resources);
  }

}
