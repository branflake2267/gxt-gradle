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
package com.gawkat.customtheme.client.sliced.grid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.gawkat.customtheme.client.base.grid.Css3ColumnHeaderAppearance;

public class SlicedColumnHeaderAppearance extends Css3ColumnHeaderAppearance {

  public interface SlicedColumnHeaderResources extends Css3ColumnHeaderResources {
    /** header background image */
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("column-header.png")
    ImageResource columnHeader();

    /** header background image when hovered */
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("column-header-over.png")
    ImageResource columnHeaderOver();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("column-header-btn-bg.png")
    ImageResource columnHeaderBtnBg();
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("column-header-btn-bg-over.png")
    ImageResource columnHeaderBtnBgOver();
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Source("column-header-btn-bg-open.png")
    ImageResource columnHeaderBtnBgOpen();

    @Override
    @Source("SlicedColumnHeader.gss")
    Styles style();

  }

  public interface Styles extends Css3ColumnHeaderAppearance.Styles {

  }

  public SlicedColumnHeaderAppearance() {
    this(GWT.<SlicedColumnHeaderResources>create(SlicedColumnHeaderResources.class));
  }

  public SlicedColumnHeaderAppearance(SlicedColumnHeaderResources resources) {
    super(resources);
  }

}
