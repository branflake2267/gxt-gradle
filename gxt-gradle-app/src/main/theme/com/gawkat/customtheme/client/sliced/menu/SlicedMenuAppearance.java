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
import com.gawkat.customtheme.client.base.menu.Css3MenuAppearance;

public class SlicedMenuAppearance extends Css3MenuAppearance {

  public interface SlicedMenuResources extends Css3MenuResources {
    @Override
    @Source("SlicedMenu.gss")
    SlicedMenuStyle style();

    @Source("menu-bg.png")
    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    ImageResource background();
  }

  public interface SlicedMenuStyle extends Css3MenuStyle {

  }

  public SlicedMenuAppearance() {
    this(GWT.<SlicedMenuResources>create(SlicedMenuResources.class));

  }

  public SlicedMenuAppearance(SlicedMenuResources resources) {
    this(resources, GWT.<BaseMenuTemplate>create(BaseMenuTemplate.class));
  }

  public SlicedMenuAppearance(SlicedMenuResources resources, BaseMenuTemplate template) {
    super(resources, template);
  }
}
