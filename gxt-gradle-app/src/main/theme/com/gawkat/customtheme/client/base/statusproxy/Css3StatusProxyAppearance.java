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
package com.gawkat.customtheme.client.base.statusproxy;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.theme.base.client.statusproxy.StatusProxyBaseAppearance;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;

public class Css3StatusProxyAppearance extends StatusProxyBaseAppearance {
  public interface Css3StatusProxyResources extends StatusProxyResources, ClientBundle {
    @Override
    @Source({"com/sencha/gxt/theme/base/client/statusproxy/StatusProxy.gss", "Css3StatusProxy.gss"})
    Css3StatusProxyStyle style();

    @Override
    ImageResource dropAllowed();

    @Override
    ImageResource dropNotAllowed();

    ThemeDetails theme();
  }

  public interface Css3StatusProxyStyle extends StatusProxyStyle {

  }

  public Css3StatusProxyAppearance() {
    this(GWT.<Css3StatusProxyResources>create(Css3StatusProxyResources.class));
  }

  public Css3StatusProxyAppearance(Css3StatusProxyResources resources) {
    this(resources, GWT.<StatusProxyTemplates>create(StatusProxyTemplates.class));
  }

  public Css3StatusProxyAppearance(Css3StatusProxyResources resources, StatusProxyTemplates template) {
    super(resources, template);
  }
}
