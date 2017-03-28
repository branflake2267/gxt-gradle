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
package com.gawkat.customtheme.client.sliced.button;

import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

/**
 *
 */
public interface SlicedToolBarButtonCellTableFrameResources {

  @Source("toolbar-button-background.png")
  @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
  ImageResource toolBarBackground();

  @Source("toolbar-button-over-background.png")
  @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
  ImageResource toolBarBackgroundOverBorder();

  @Source("toolbar-button-pressed-background.png")
  @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
  ImageResource toolBarBackgroundPressedBorder();

  @Source("toolbar-button-tl.png")
  ImageResource toolBarTopLeftBorder();

  @Source("toolbar-button-over-tl.png")
  ImageResource toolBarTopLeftOverBorder();

  @Source("toolbar-button-pressed-tl.png")
  ImageResource toolBarTopLeftPressedBorder();

  @Source("toolbar-button-tc.png")
  @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
  ImageResource toolBarTopBorder();

  @Source("toolbar-button-over-tc.png")
  @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
  ImageResource toolBarTopOverBorder();

  @Source("toolbar-button-pressed-tc.png")
  @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
  ImageResource toolBarTopPressedBorder();

  @Source("toolbar-button-tr.png")
  ImageResource toolBarTopRightBorder();

  @Source("toolbar-button-over-tr.png")
  ImageResource toolBarTopRightOverBorder();

  @Source("toolbar-button-pressed-tr.png")
  ImageResource toolBarTopRightPressedBorder();

  @Source("toolbar-button-l.png")
  @ImageOptions(repeatStyle = RepeatStyle.Vertical)
  ImageResource toolBarLeftBorder();

  @Source("toolbar-button-over-l.png")
  @ImageOptions(repeatStyle = RepeatStyle.Vertical)
  ImageResource toolBarLeftOverBorder();

  @Source("toolbar-button-pressed-l.png")
  @ImageOptions(repeatStyle = RepeatStyle.Vertical)
  ImageResource toolBarLeftPressedBorder();

  @Source("toolbar-button-r.png")
  @ImageOptions(repeatStyle = RepeatStyle.Vertical)
  ImageResource toolBarRightBorder();

  @Source("toolbar-button-over-r.png")
  @ImageOptions(repeatStyle = RepeatStyle.Vertical)
  ImageResource toolBarRightOverBorder();

  @Source("toolbar-button-pressed-r.png")
  @ImageOptions(repeatStyle = RepeatStyle.Vertical)
  ImageResource toolBarRightPressedBorder();

  @Source("toolbar-button-bl.png")
  ImageResource toolBarBottomLeftBorder();

  @Source("toolbar-button-over-bl.png")
  ImageResource toolBarBottomLeftOverBorder();

  @Source("toolbar-button-pressed-bl.png")
  ImageResource toolBarBottomLeftPressedBorder();


  @Source("toolbar-button-bc.png")
  @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
  ImageResource toolBarBottomBorder();

  @Source("toolbar-button-over-bc.png")
  @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
  ImageResource toolBarBottomOverBorder();

  @Source("toolbar-button-pressed-bc.png")
  @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
  ImageResource toolBarBottomPressedBorder();

  @Source("toolbar-button-br.png")
  ImageResource toolBarBottomRightBorder();

  @Source("toolbar-button-over-br.png")
  ImageResource toolBarBottomRightOverBorder();

  @Source("toolbar-button-pressed-br.png")
  ImageResource toolBarBottomRightPressedBorder();
}
