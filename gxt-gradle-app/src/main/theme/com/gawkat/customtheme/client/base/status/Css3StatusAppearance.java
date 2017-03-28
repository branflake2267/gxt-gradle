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
package com.gawkat.customtheme.client.base.status;

import com.google.gwt.core.shared.GWT;
import com.sencha.gxt.theme.base.client.status.StatusDefaultAppearance;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

public class Css3StatusAppearance extends StatusDefaultAppearance {
  public interface Css3StatusResources extends StatusResources {
    @Override
    @Source("Css3Status.gss")
    Css3StatusStyles style();

    ThemeDetails theme();
  }

  public interface Css3StatusStyles extends StatusStyle {

  }

  public Css3StatusAppearance() {
    this(GWT.<Css3StatusResources>create(Css3StatusResources.class));
  }

  public Css3StatusAppearance(StatusResources resources) {
    this(resources, GWT.<Template>create(Template.class));
  }

  public Css3StatusAppearance(StatusResources resources, Template template) {
    super(resources, template);
  }
}
