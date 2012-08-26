
package com.tinesoft.gwt.dialogs.client.menu.core;

import com.google.gwt.event.shared.EventHandler;

/**
 * Custom event handler that fires {@link MenuItemClickEvent}.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public interface MenuItemClickHandler extends EventHandler {

    void onMenuItemClicked(MenuItemClickEvent event);
}
