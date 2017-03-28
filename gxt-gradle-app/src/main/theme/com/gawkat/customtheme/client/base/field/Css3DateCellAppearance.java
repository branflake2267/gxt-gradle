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
import com.sencha.gxt.cell.core.client.form.DateCell.DateCellAppearance;

/**
 *
 */
public class Css3DateCellAppearance extends Css3TriggerFieldAppearance implements DateCellAppearance {

  public interface Css3DateCellResources extends Css3TriggerFieldResources {
    @Override
    @Source({"Css3ValueBaseField.gss", "Css3TextField.gss", "Css3TriggerField.gss"})
    Css3DateCellStyle style();

    @Override
    @Source("dateTrigger.png")
    ImageResource triggerArrow();

    @Override
    @Source("dateTriggerOver.png")
    ImageResource triggerArrowOver();

    @Override
    @Source("dateTriggerClick.png")
    ImageResource triggerArrowClick();
  }

  public interface Css3DateCellStyle extends Css3TriggerFieldStyle {

  }

  public Css3DateCellAppearance() {
    this(GWT.<Css3DateCellResources>create(Css3DateCellResources.class));
  }

  public Css3DateCellAppearance(Css3DateCellResources resources) {
    super(resources);
  }
}
