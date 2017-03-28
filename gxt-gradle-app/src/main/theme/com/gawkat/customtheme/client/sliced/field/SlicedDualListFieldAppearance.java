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
import com.google.gwt.resources.client.CssResource.Import;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.theme.base.client.button.IconButtonDefaultAppearance.IconButtonStyle;
import com.gawkat.customtheme.client.base.field.Css3DualListFieldAppearance;

/**
 *
 */
public class SlicedDualListFieldAppearance extends Css3DualListFieldAppearance {
  public interface SlicedDualListFieldResources extends Css3DualListFieldResources {
    @Override
    @Source("SlicedDualListField.gss")
    @Import(IconButtonStyle.class)
    SlicedDualListFieldStyle style();

    @Source("dualListField-button-background.png")
    ImageResource background();
  }

  public interface SlicedDualListFieldStyle extends Css3DualListFieldStyle {

  }


  public SlicedDualListFieldAppearance() {
    this(GWT.<SlicedDualListFieldResources>create(SlicedDualListFieldResources.class));
  }

  public SlicedDualListFieldAppearance(SlicedDualListFieldResources resources) {
    super(resources);
  }
}
