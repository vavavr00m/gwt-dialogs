
package com.tinesoft.gwt.dialogs.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.tinesoft.gwt.dialogs.client.message.ui.MessageDialog;

/**
 * Client bundle for the {@link MessageDialog} css and image resources.
 * 
 * @author Tine Kondo
 */
public interface ContextMenuDialogResources extends ClientBundle {

    interface ContextMenuDialogStyle extends BaseStyle {

        @ClassName("gwtd-menu")
        String gwtdMenu();

        @ClassName("gwtd-menu-on-top")
        String gwtdMenuOnTop();

        @ClassName("gwtd-menu-on-bottom")
        String gwtdMenuOnBottom();

        @ClassName("gwtd-menu-on-left")
        String gwtdMenuOnLeft();

        @ClassName("gwtd-menu-on-right")
        String gwtdMenuOnRight();

        @ClassName("gwtd-menu-item")
        String gwtdMenuItem();

        @ClassName("gwtd-menu-item-icon")
        String gwtdMenuItemIcon();

        @ClassName("gwtd-menu-item-text")
        String gwtdMenuItemText();

        @ClassName("gwtd-menu-separator")
        String gwtdMenuSeparator();

        @ClassName("gwtd-menu-target")
        String gwtdMenuTarget();

    }

    /**
     * @return css bundle.
     */
    @Source({ "BaseStyle.css", "ContextMenuDialogStyle.css" })
    @NotStrict
    ContextMenuDialogStyle css();

}
