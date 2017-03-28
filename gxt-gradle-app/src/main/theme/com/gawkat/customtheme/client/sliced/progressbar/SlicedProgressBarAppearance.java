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
package com.gawkat.customtheme.client.sliced.progressbar;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.gawkat.customtheme.client.base.progressbar.Css3ProgressBarAppearance;

public class SlicedProgressBarAppearance extends Css3ProgressBarAppearance {
  public interface SlicedProgressBarResources extends Css3ProgressBarResources {
    @Source("progressbar-bar.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource bar();

    @Source("progressbar-bg.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource innerBar();

    @Override
    @Source("SlicedProgressBar.gss")
    SlicedProgressBarStyle styles();

  }

  public interface SlicedProgressBarStyle extends Css3ProgressBarStyles {

  }

  public SlicedProgressBarAppearance() {
    this(GWT.<SlicedProgressBarResources>create(SlicedProgressBarResources.class));
  }

  public SlicedProgressBarAppearance(SlicedProgressBarResources resources) {
    super(resources);
  }
}
