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
package com.gawkat.customtheme.client.sliced.tips;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.frame.NestedDivFrame;
import com.sencha.gxt.theme.base.client.tips.TipDefaultAppearance;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

/**
 *
 */
public class SlicedTipAppearance extends TipDefaultAppearance {

  public interface SlicedTipDivFrameResources extends TipDivFrameResources {


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

  public interface SlicedTipResources extends TipResources {

    @Override
    @Source("com/gawkat/customtheme/client/base/tips/anchorBottom.png")
    ImageResource anchorBottom();

    @Override
    @Source("com/gawkat/customtheme/client/base/tips/anchorLeft.png")
    ImageResource anchorLeft();

    @Override
    @Source("com/gawkat/customtheme/client/base/tips/anchorRight.png")
    ImageResource anchorRight();

    @Override
    @Source("com/gawkat/customtheme/client/base/tips/anchorTop.png")
    ImageResource anchorTop();

    @Override
    @Source({"com/sencha/gxt/theme/base/client/tips/TipDefault.gss", "SlicedTip.gss"})
    SlicedTipStyle style();

    ThemeDetails theme();
  }

  public interface SlicedTipStyle extends TipStyle {

  }

  public SlicedTipAppearance() {
    this(GWT.<SlicedTipResources>create(SlicedTipResources.class));
  }

  public SlicedTipAppearance(SlicedTipResources resources) {
    this(resources, GWT.<TipDefaultTemplate>create(TipDefaultTemplate.class));
  }

  public SlicedTipAppearance(SlicedTipResources resources, TipDefaultTemplate template) {
    super(resources, template);

    frame = new NestedDivFrame(GWT.<SlicedTipDivFrameResources>create(SlicedTipDivFrameResources.class));
  }
}
