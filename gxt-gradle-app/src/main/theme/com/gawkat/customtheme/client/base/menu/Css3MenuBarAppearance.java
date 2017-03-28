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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.resources.CommonStyles;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.menu.MenuBar.MenuBarAppearance;

public class Css3MenuBarAppearance implements MenuBarAppearance {
  public interface Css3MenuBarResources extends ClientBundle {
    @Source("Css3MenuBar.gss")
    Css3MenuBarStyle style();

    ThemeDetails theme();
  }

  public interface Css3MenuBarStyle extends CssResource {
    String menuBar();
  }

  public interface MenuBarTemplate extends XTemplates {
    @XTemplate("<div class='{cssClasses}'></div>")
    SafeHtml render(String cssClasses);
  }

  private final Css3MenuBarStyle style;
  private final MenuBarTemplate template;

  public Css3MenuBarAppearance() {
    this(GWT.<Css3MenuBarResources>create(Css3MenuBarResources.class));
  }

  public Css3MenuBarAppearance(Css3MenuBarResources resources) {
    this(resources, GWT.<MenuBarTemplate>create(MenuBarTemplate.class));
  }

  public Css3MenuBarAppearance(Css3MenuBarResources resources, MenuBarTemplate template) {
    this.template = template;
    this.style = resources.style();
    StyleInjectorHelper.ensureInjected(this.style, true);
  }

  @Override
  public void render(SafeHtmlBuilder builder) {
    builder.append(template.render(style.menuBar() + " " + CommonStyles.get().noFocusOutline()));
  }
}
