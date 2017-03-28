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
package com.gawkat.customtheme.client.base.menu;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.sencha.gxt.theme.base.client.menu.SeparatorMenuItemBaseAppearance;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

public class Css3SeparatorMenuItemAppearance extends SeparatorMenuItemBaseAppearance {

  public interface Css3SeparatorMenuItemResources extends SeparatorMenuItemResources, ClientBundle {
    @Override
    @Source("Css3SeparatorMenuItem.gss")
    Css3SeparatorMenuItemStyle style();

    ThemeDetails theme();
  }

  public interface Css3SeparatorMenuItemStyle extends SeparatorMenuItemStyle {

  }

  public Css3SeparatorMenuItemAppearance() {
    this(GWT.<Css3SeparatorMenuItemResources>create(Css3SeparatorMenuItemResources.class));
  }

  public Css3SeparatorMenuItemAppearance(Css3SeparatorMenuItemResources resources) {
    this(resources, GWT.<SeparatorMenuItemTemplate>create(SeparatorMenuItemTemplate.class));
  }

  public Css3SeparatorMenuItemAppearance(Css3SeparatorMenuItemResources resources, SeparatorMenuItemTemplate template) {
    super(resources, template);
  }
}
