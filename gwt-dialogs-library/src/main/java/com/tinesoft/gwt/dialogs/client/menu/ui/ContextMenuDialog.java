
package com.tinesoft.gwt.dialogs.client.menu.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Widget;
import com.tinesoft.gwt.dialogs.client.menu.core.ContextMenuDialogEventListener;
import com.tinesoft.gwt.dialogs.client.menu.core.ContextMenuDialogTriggerMode;
import com.tinesoft.gwt.dialogs.client.resources.ContextMenuDialogResources;

/**
 * Displays a context menu dialog on screen, and related to a widget (the target of the context
 * menu).
 * <p>
 * You must add the following code during {@code #onModuleLoad()} in order to load the styling.
 * </p>
 * 
 * <pre>
 * (ContextMenuDialogResources) GWT.create(ContextMenuDialogResources.class)).css().ensureInjected();
 * </pre>
 * 
 * @author Tine Kondo
 */
public class ContextMenuDialog {

    /**
     * @return the resources
     */
    public static ContextMenuDialogResources getResources() {
        if (resources == null) {
            // we set the resources to the default one
            resources = GWT.create(ContextMenuDialogResources.class);
            // we make sure that the new css style is injected
            resources.css().ensureInjected();
        }
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public static void setResources(final ContextMenuDialogResources resources) {
        ContextMenuDialog.resources = resources;
    }

    private final ContextMenuDialogWidget menuDialogWidget;

    private static ContextMenuDialogResources resources;

    private final Widget target;

    private final ContextMenuDialogTriggerMode triggerMode;

    /**
     * Constructor.
     * 
     * @param target the target widget to which the context menu dialog is related.
     * @param triggerMode the trigger mode, which defines what triggers the display of the context
     *            menu.
     */
    public ContextMenuDialog(final Widget target, final ContextMenuDialogTriggerMode triggerMode) {

        this.target = target;
        this.triggerMode = triggerMode;
        menuDialogWidget = new ContextMenuDialogWidget();
    }

    /**
     * Adds a new menu item to the context menu dialog.
     * 
     * @param icon the icon of the new menu item.
     * @param text the text of the new menu item.
     * @param listener the listener to handle events on the item.
     */
    public void addItem(final ImageResource icon, final String text, final ContextMenuDialogEventListener listener) {

    }

    /**
     * Adds a separator in the context menu dialog.
     */
    public void addSeparator() {

    }

    /**
     * @return the target
     */
    public Widget getTarget() {
        return target;
    }

    /**
     * @return the triggerMode
     */
    public ContextMenuDialogTriggerMode getTriggerMode() {
        return triggerMode;
    }

}
