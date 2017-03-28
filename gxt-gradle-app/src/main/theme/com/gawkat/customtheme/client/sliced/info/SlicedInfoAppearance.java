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
package com.gawkat.customtheme.client.sliced.info;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.info.InfoDefaultAppearance;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

public class SlicedInfoAppearance extends InfoDefaultAppearance {
  interface SlicedInfoResources extends InfoResources {
    @Source({"com/sencha/gxt/theme/base/client/frame/DivFrame.gss", "Info.gss"})
    @Override
    SlicedInfoStyle style();

    @Source("background.png")
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource background();

    @Source("corner-bc.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource bottomBorder();

    @Source("corner-bl.png")
    ImageResource bottomLeftBorder();

    @Source("corner-br.png")
    ImageResource bottomRightBorder();

    @Source("side-l.png")
    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    ImageResource leftBorder();

    @Source("side-r.png")
    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    ImageResource rightBorder();

    @Source("corner-tc.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource topBorder();

    @Source("corner-tl.png")
    ImageResource topLeftBorder();

    @Source("corner-tr.png")
    ImageResource topRightBorder();

    ThemeDetails theme();
  }

  interface SlicedInfoStyle extends InfoStyle {

  }

  public SlicedInfoAppearance() {
    this(GWT.<SlicedInfoResources>create(SlicedInfoResources.class));
  }

  public SlicedInfoAppearance(SlicedInfoResources resources) {
    this(resources, GWT.<Template>create(Template.class));
  }

  public SlicedInfoAppearance(SlicedInfoResources resources, Template template) {
    super(template, resources);
  }
}
