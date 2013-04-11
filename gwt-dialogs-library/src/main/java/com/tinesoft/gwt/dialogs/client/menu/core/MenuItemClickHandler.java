
package com.tinesoft.gwt.dialogs.client.menu.core;

import com.google.gwt.event.shared.EventHandler;

/**
 * Custom event handler that fires {@link MenuItemClickEvent}.
 * 
 * @author Tine Kondo
 */
public interface MenuItemClickHandler extends EventHandler {

    /**
     * Called when a {@link MenuItemClickEvent} is fired.
     * 
     * @param event the {@link MenuItemClickEvent} that was fired
     */
    void onMenuItemClicked(MenuItemClickEvent event);
}
