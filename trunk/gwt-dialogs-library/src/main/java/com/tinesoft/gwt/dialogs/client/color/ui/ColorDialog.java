
package com.tinesoft.gwt.dialogs.client.color.ui;

import com.google.gwt.core.client.GWT;

import com.tinesoft.gwt.dialogs.client.color.core.ColorChangedEvent;
import com.tinesoft.gwt.dialogs.client.color.core.ColorDialogEventAdapter;
import com.tinesoft.gwt.dialogs.client.color.core.ColorDialogEventListener;
import com.tinesoft.gwt.dialogs.client.resources.ColorDialogResources;

/**
 * Displays a color dialog on screen.
 * 
 * @author Tine Kondo
 */
public class ColorDialog {

    private static String color;

    /**
     * Gets the {@link ColorDialogResources} defining the css, images to use for styling the widget.
     * 
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
     * Sets the {@link ColorDialogResources} defining the css, images to use for styling the widget.
     * 
     * @param resources the resources to set
     */
    public static void setResources(final ColorDialogResources resources) {
        ColorDialog.resources = resources;
        // we make sure that the new css style is injected
        ColorDialog.resources.css().ensureInjected();
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

    /**
     * Shows the color dialog box.
     * 
     * @param title the title of the color dialog box.
     * @param message the message of the color dialog box.
     * @param defaultColor the default selected color.
     */
    public static void show(final String title, final String message, final String defaultColor) {
        new ColorDialog(title, message, defaultColor, new ColorDialogEventAdapter() {}).show();
    }

    /**
     * Shows the color dialog box.
     * 
     * @param message the message of the color dialog box.
     * @param defaultColor the default selected color.
     */
    public static void show(final String message, final String defaultColor) {
        new ColorDialog("", message, defaultColor, new ColorDialogEventAdapter() {}).show();
    }

    private final String title;

    private final String message;

    private final ColorDialogWidget colorDialogWidget;

    private final ColorDialogEventListener listener;

    private static ColorDialogResources resources;

    /**
     * Gets the current value of the color displayed in the widget.
     * 
     * @return the color (in hexadecimal format with the '#')
     */
    public static String getColor() {
        return color;
    }

    /**
     * Sets the color displayed by the picker. The color string can be represented in 3 different
     * modes:
     * <ul>
     * <li>in hexadecimal mode. Eg: #ff0000</li>
     * <li>in RBG mode. Eg: rgb(255,0,0)</li>
     * <li>in RBGA mode. Eg: rgba(255,0,0,a)</li>
     * </ul>
     * 
     * The method fires a {@link ColorChangedEvent} with the new color (in hexadecimal) as argument.
     * 
     * @param color the new color to set (in hexadecimal representation with or without the '#').
     */
    public static void setColor(final String color) {
        ColorDialog.color = color;
    }

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
     * Returns the {@link ColorDialogEventListener} associated with this {@link ColorDialog}.
     * 
     * @return the {@link ColorDialogEventListener} associated with this {@link ColorDialog}.
     */
    public ColorDialogEventListener getListener() {
        return listener;
    }

    /**
     * Gets the displayed message.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the displayed title.
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    private void show() {
        colorDialogWidget.show();
    }

}
