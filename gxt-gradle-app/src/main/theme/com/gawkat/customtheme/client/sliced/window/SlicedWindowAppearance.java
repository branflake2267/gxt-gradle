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
package com.gawkat.customtheme.client.sliced.window;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.gawkat.customtheme.client.sliced.panel.SlicedFramedPanelAppearance;
import com.sencha.gxt.widget.core.client.Header.HeaderAppearance;
import com.sencha.gxt.widget.core.client.Window.WindowAppearance;

public class SlicedWindowAppearance extends SlicedFramedPanelAppearance implements WindowAppearance {

  public interface SlicedWindowResources extends SlicedFramePanelResources {
    @Override
    @Source("SlicedWindow.gss")
    SlicedWindowStyle style();
  }

  public interface SlicedWindowStyle extends FramedPanelStyle {
    String ghost();
  }

  public interface SlicedWindowDivFrameResources extends SlicedFramedPanelDivFrameResources {
    @Source({"com/gawkat/customtheme/client/sliced/panel/SlicedFramedPanelDivFrame.gss"})
    @Override
    SlicedWindowNestedDivFrameStyle style();

    @Override
    @Source("window-background.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource background();

    @Source("window-tl.png")
    @Override
    ImageResource topLeftBorder();

    @Source("window-tc.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Override
    ImageResource topBorder();

    @Source("window-tr.png")
    @Override
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource topRightBorder();

    @Source("window-l.png")
    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    @Override
    ImageResource leftBorder();

    @Source("window-r.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    @Override
    ImageResource rightBorder();

    @Source("window-bl.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    @Override
    ImageResource bottomLeftBorder();

    @Source("window-bc.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Override
    ImageResource bottomBorder();

    @Source("window-br.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    @Override
    ImageResource bottomRightBorder();
  }

  public interface SlicedWindowNestedDivFrameStyle extends SlicedFramePanelNestedDivFrameStyle {

  }

  private final SlicedWindowResources res;

  public SlicedWindowAppearance() {
    this(GWT.<SlicedWindowResources>create(SlicedWindowResources.class));

  }

  public SlicedWindowAppearance(SlicedWindowResources slicedWindowResources) {
    this(slicedWindowResources, GWT.<SlicedWindowDivFrameResources>create(SlicedWindowDivFrameResources.class));
  }

  public SlicedWindowAppearance(SlicedWindowResources slicedWindowResources, SlicedWindowDivFrameResources frameResources) {
    super(slicedWindowResources, frameResources);
    this.res = slicedWindowResources;
  }

  @Override
  public HeaderAppearance getHeaderAppearance() {
    return new SlicedWindowHeaderAppearance();
  }

  @Override
  public String ghostClass() {
    return res.style().ghost();
  }
}
