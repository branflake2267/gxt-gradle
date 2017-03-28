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
package com.gawkat.customtheme.client.base.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.cell.core.client.form.SpinnerFieldCell.SpinnerFieldAppearance;

/**
 *
 */
public class Css3SpinnerFieldAppearance extends Css3TwinTriggerFieldAppearance implements SpinnerFieldAppearance {
  public interface Css3SpinnerFieldResources extends Css3TwinTriggerFieldResources {
    @Override
    @Source({"Css3ValueBaseField.gss", "Css3TextField.gss", "Css3TriggerField.gss", "Css3SpinnerField.gss"})
    Css3SpinnerFieldStyle style();

    @Override
    @Source("spinnerUp.png")
    ImageResource triggerArrow();

    @Override
    @Source("spinnerUpOver.png")
    ImageResource triggerArrowOver();

    @Override
    @Source("spinnerUpClick.png")
    ImageResource triggerArrowClick();

    @Source("spinnerDown.png")
    public ImageResource twinTriggerArrow();

    @Source("spinnerDownOver.png")
    public ImageResource twinTriggerArrowOver();

    @Source("spinnerDownClick.png")
    public ImageResource twinTriggerArrowClick();
  }

  public interface Css3SpinnerFieldStyle extends Css3TwinTriggerFieldStyle {

  }


  private final Css3SpinnerFieldResources resources;

  public Css3SpinnerFieldAppearance() {
    this(GWT.<Css3SpinnerFieldResources>create(Css3SpinnerFieldResources.class));
  }

  public Css3SpinnerFieldAppearance(Css3SpinnerFieldResources resources) {
    super(resources);

    this.resources = resources;
  }

  @Override
  protected int getTriggerWrapHeight() {
    return resources.triggerArrow().getHeight() + resources.twinTriggerArrow().getHeight();
  }
}
