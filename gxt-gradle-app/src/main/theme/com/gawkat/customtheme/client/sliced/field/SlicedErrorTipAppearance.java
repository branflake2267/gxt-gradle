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
package com.gawkat.customtheme.client.sliced.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.field.ErrorTipDefaultAppearance;
import com.sencha.gxt.theme.base.client.frame.Frame;
import com.sencha.gxt.theme.base.client.frame.NestedDivFrame;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

/**
 *
 */
public class SlicedErrorTipAppearance extends ErrorTipDefaultAppearance {

  public interface SlicedErrorTipFrameResources extends ErrorTipFrameResources {
    @Override
    @Source("tip-background.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource background();

    @Override
    @Source("tip-bc.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource bottomBorder();

    @Override
    @Source("tip-bl.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource bottomLeftBorder();

    @Override
    @Source("tip-br.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource bottomRightBorder();

    @Override
    @Source("tip-l.png")
    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    ImageResource leftBorder();

    @Override
    @Source("tip-r.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource rightBorder();

    @Override
    @Source("tip-tc.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource topBorder();

    @Override
    @Source("tip-tl.png")
    ImageResource topLeftBorder();

    @Override
    @Source("tip-tr.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource topRightBorder();
  }


  public interface SlicedErrorTipResources extends ErrorTipResources {
    @Override
    @Source("com/gawkat/customtheme/client/base/field/exclamation.png")
    @ImageOptions(preventInlining = true)
    ImageResource errorIcon();

    @Override
    @Source({"com/sencha/gxt/theme/base/client/tips/TipDefault.gss", "SlicedErrorTip.gss"})
    SlicedErrorTipStyle style();

    ThemeDetails theme();
  }

  public interface SlicedErrorTipStyle extends ErrorTipStyle {

  }

  public SlicedErrorTipAppearance() {
    this(GWT.<SlicedErrorTipResources>create(SlicedErrorTipResources.class));
  }

  public SlicedErrorTipAppearance(SlicedErrorTipResources resources) {
    this(resources, new NestedDivFrame(GWT.<SlicedErrorTipFrameResources>create(SlicedErrorTipFrameResources.class)));
  }

  public SlicedErrorTipAppearance(SlicedErrorTipResources resources, Frame frame) {
    super(resources);
    super.frame = frame;
  }
}
