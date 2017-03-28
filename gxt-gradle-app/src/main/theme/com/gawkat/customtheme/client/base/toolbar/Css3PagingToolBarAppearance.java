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
package com.gawkat.customtheme.client.base.toolbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar.PagingToolBarAppearance;

/**
 *
 */
public class Css3PagingToolBarAppearance implements PagingToolBarAppearance {


  public interface Css3PagingToolBarResources extends PagingToolBarAppearance, ClientBundle {
    ImageResource first();

    ImageResource prev();

    ImageResource next();

    ImageResource last();

    ImageResource refresh();

    ImageResource loading();
  }

  private final Css3PagingToolBarResources resources;

  public Css3PagingToolBarAppearance() {
    this(GWT.<Css3PagingToolBarResources>create(Css3PagingToolBarResources.class));
  }

  public Css3PagingToolBarAppearance(Css3PagingToolBarResources resources) {
    this.resources = resources;
  }

  @Override
  public ImageResource first() {
    return resources.first();
  }

  @Override
  public ImageResource last() {
    return resources.last();
  }

  @Override
  public ImageResource next() {
    return resources.next();
  }

  @Override
  public ImageResource prev() {
    return resources.prev();
  }

  @Override
  public ImageResource refresh() {
    return resources.refresh();
  }

  @Override
  public ImageResource loading() {
    return resources.loading();
  }
}
