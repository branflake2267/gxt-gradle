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
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.GwtCreateResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesBuilder;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.theme.base.client.slider.SliderVerticalBaseAppearance;
import com.sencha.gxt.themebuilder.base.client.config.SliderDetails;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

/**
 *
 */
public class SlicedVerticalSliderAppearance extends SliderVerticalBaseAppearance {

  public interface SlicedVerticalSliderResources extends SliderVerticalResources, ClientBundle {
    @Override
    @Source({"com/sencha/gxt/theme/base/client/slider/Slider.gss",
        "com/sencha/gxt/theme/base/client/slider/SliderVertical.gss", "SlicedVerticalSlider.gss"})
    SlicedVerticalSliderStyle style();

    GwtCreateResource<ThemeDetails> theme();

    @Source("thumbVertical.png")
    ImageResource thumbVertical();

    @Source("thumbVerticalClick.png")
    ImageResource thumbVerticalDown();

    @Source("thumbVerticalOver.png")
    ImageResource thumbVerticalOver();

    @Source("trackVerticalTop.png")
    ImageResource trackVerticalTop();

    @Source("trackVerticalBottom.png")
    ImageResource trackVerticalBottom();

    @Source("trackVerticalMiddle.png")
    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    ImageResource trackVerticalMiddle();
  }

  public interface SlicedVerticalSliderStyle extends BaseSliderVerticalStyle, CssResource {
  }

  private final SlicedVerticalSliderResources resources;

  public SlicedVerticalSliderAppearance() {
    this(GWT.<SlicedVerticalSliderResources>create(SlicedVerticalSliderResources.class));
  }

  public SlicedVerticalSliderAppearance(SlicedVerticalSliderResources resources) {
    this(resources, GWT.<SliderVerticalTemplate>create(SliderVerticalTemplate.class));
  }

  public SlicedVerticalSliderAppearance(SlicedVerticalSliderResources resources, SliderVerticalTemplate template) {
    super(resources, template);

    this.resources = resources;
  }


  @Override
  public int getSliderLength(XElement parent) {
    SliderDetails sliderDetails = resources.theme().create().field().slider();
    return super.getSliderLength(parent) + getTrackPadding() - (sliderDetails.thumbBorder().top() + sliderDetails.thumbBorder().bottom());
  }

  @Override
  public void setThumbPosition(Element parent, int pos) {
    XElement thumbElement = XElement.as(getThumb(parent));
    pos -= getHalfThumbSize();
    pos = Math.max(-getHalfThumbSize(), pos);
    thumbElement.getStyle().setBottom(pos, Unit.PX);
  }

  protected SafeStyles createThumbStyles(double fractionalValue, int height) {
    SafeStylesBuilder thumbStylesBuilder = new SafeStylesBuilder();

    int innerHeight = height;
    int offset = (int) (innerHeight - ((fractionalValue * innerHeight) - getHalfThumbSize()));
    offset = innerHeight - offset;

    thumbStylesBuilder.appendTrustedString("bottom:" + offset + "px;");
    int thumbLeft = (resources.trackVerticalMiddle().getWidth() / 2) - (resources.thumbVertical().getWidth() / 2);

    thumbStylesBuilder.appendTrustedString("left:" + thumbLeft + "px;");

    return thumbStylesBuilder.toSafeStyles();
  }

  @Override
  protected int getHalfThumbSize() {
    return (int) Math.floor(resources.thumbVertical().getHeight() / 2);
  }

  protected int getTrackPadding() {
    return resources.trackVerticalTop().getHeight();
  }
}
