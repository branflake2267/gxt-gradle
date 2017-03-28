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
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;
import com.sencha.gxt.widget.core.client.form.error.SideErrorHandler.SideErrorResources;
import com.sencha.gxt.widget.core.client.form.error.SideErrorHandler.SideErrorStyle;

public class Css3SideErrorResourcesAdapter implements SideErrorResources {

  interface Css3SideErrorResources extends SideErrorResources {

    @Override
    @Source({"com/sencha/gxt/widget/core/client/form/error/SideError.gss", "Css3SideError.gss"})
    Css3SideErrorStyle css();

    @Override
    @Source("exclamation.png")
    ImageResource errorIcon();
  }

  public interface Css3SideErrorStyle extends SideErrorStyle {
  }

  private final Css3SideErrorResources resources;

  public Css3SideErrorResourcesAdapter() {
    this.resources = GWT.create(Css3SideErrorResources.class);

    StyleInjectorHelper.ensureInjected(css(), true);
  }

  public Css3SideErrorStyle css() {
    return resources.css();
  }

  public ImageResource errorIcon() {
    return resources.errorIcon();
  }
}
