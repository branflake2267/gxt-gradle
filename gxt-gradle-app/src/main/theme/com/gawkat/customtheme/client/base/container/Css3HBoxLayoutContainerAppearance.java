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
package com.gawkat.customtheme.client.base.container;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.theme.base.client.container.HBoxLayoutDefaultAppearance;

public class Css3HBoxLayoutContainerAppearance extends HBoxLayoutDefaultAppearance {

  public interface Css3HBoxLayoutContainerResources extends HBoxLayoutBaseResources {
    @Override
    @Source({"com/sencha/gxt/theme/base/client/container/BoxLayout.gss", "Css3HBoxLayoutContainer.gss"})
    HBoxLayoutStyle style();

    @Override
    ImageResource moreIcon();

    ImageResource moreIconToolBar();
  }

  public interface Css3HBoxLayoutContainerStyle extends HBoxLayoutStyle {

  }

  public Css3HBoxLayoutContainerAppearance() {
    this(GWT.<Css3HBoxLayoutContainerResources>create(Css3HBoxLayoutContainerResources.class));
  }

  public Css3HBoxLayoutContainerAppearance(Css3HBoxLayoutContainerResources resources) {
    super(resources);
  }
}
