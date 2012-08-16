
package com.tinesoft.gwt.dialogs.client.color.ui;

import com.google.gwt.core.client.GWT;
import com.tinesoft.gwt.dialogs.client.color.core.ColorDialogEventListener;
import com.tinesoft.gwt.dialogs.client.resources.ColorDialogResources;

/**
 * Displays a color dialog on screen.
 * <p>
 * You must add the following code during {@code #onModuleLoad()} in order to load the styling.
 * </p>
 * 
 * <pre>
 * (ColorDialogResources) GWT.create(ColorDialogResources.class)).css().ensureInjected();
 * </pre>
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public class ColorDialog {

    /**
     * @return the resources
     */
    public static ColorDialogResources getResources() {
        if (resources == null) {
            // we set the resources to the default one
            resources = GWT.create(ColorDialogResources.class);
            // we make sure that the new css style is injected
            resources.css().ensureInjected();
        }
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public static void setResources(final ColorDialogResources resources) {
        ColorDialog.resources = resources;
    }

    /**
     * Shows the color dialog box.
     * 
     * @param title the title of the color dialog box.
     * @param message the message of the color dialog box.
     * @param defaultColor the default selected color.
     * @param listener the listener to handle events on the ColorDialog (button clicked, ...).
     */
    public static void show(final String title, final String message, final String defaultColor, final ColorDialogEventListener listener) {
        new ColorDialog(title, message, defaultColor, listener).show();
    }

    private static String color;

    private final String title;

    private final String message;

    private final ColorDialogWidget colorDialogWidget;

    private final ColorDialogEventListener listener;

    private static ColorDialogResources resources;

    /**
     * Constructor.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     * @param defaultColor the default selected color.
     * @param listener the listener to handle events on the ColorDialog (color picked, ...).
     */
    private ColorDialog(final String title, final String message, final String defaultColor, final ColorDialogEventListener listener) {
        this.title = title;
        this.message = message;
        this.listener = listener;
        colorDialogWidget = new ColorDialogWidget(this, getResources());
        colorDialogWidget.setColor(defaultColor);
    }

    /**
     * @return the color
     */
    public static String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public static void setColor(String color) {
        ColorDialog.color = color;
    }

    /**
     * Returns the {@link ColorDialogEventListener} associated with this {@link ColorDialog}.
     * 
     * @return the {@link ColorDialogEventListener} associated with this {@link ColorDialog}.
     */
    public ColorDialogEventListener getListener() {
        return listener;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    private void show() {
        colorDialogWidget.show();
    }

}
