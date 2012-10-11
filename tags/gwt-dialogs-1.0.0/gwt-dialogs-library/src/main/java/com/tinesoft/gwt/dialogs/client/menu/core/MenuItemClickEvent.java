
package com.tinesoft.gwt.dialogs.client.menu.core;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Custom event fired by a {@link MenuItemClickHandler} when the item has been clicked.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class MenuItemClickEvent extends GwtEvent<MenuItemClickHandler> {

    private static GwtEvent.Type<MenuItemClickHandler> TYPE;

    public static GwtEvent.Type<MenuItemClickHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<MenuItemClickHandler>();
        }
        return TYPE;
    }

    @Override
    public GwtEvent.Type<MenuItemClickHandler> getAssociatedType() {
        return getType();
    }

    @Override
    protected void dispatch(MenuItemClickHandler handler) {
        handler.onMenuItemClicked(this);

    }

}
