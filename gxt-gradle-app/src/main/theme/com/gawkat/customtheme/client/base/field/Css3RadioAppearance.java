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
import com.sencha.gxt.cell.core.client.form.RadioCell;

public class Css3RadioAppearance extends Css3CheckBoxAppearance implements RadioCell.RadioAppearance {

  public interface Css3RadioResources extends Css3CheckBoxResources {
    @Source({"Css3ValueBaseField.gss", "Css3CheckBox.gss", "Css3Radio.gss"})
    Css3RadioStyle style();

    ImageResource radioSelected();

    ImageResource radioUnselected();
  }

  public interface Css3RadioStyle extends Css3CheckBoxStyle {
  }

  public Css3RadioAppearance() {
    this(GWT.<Css3RadioResources> create(Css3RadioResources.class));
  }

  public Css3RadioAppearance(Css3CheckBoxResources resources) {
    super(resources);
    type = "radio";
  }
}
