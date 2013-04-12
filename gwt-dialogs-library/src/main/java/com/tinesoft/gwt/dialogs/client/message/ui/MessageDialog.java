
package com.tinesoft.gwt.dialogs.client.message.ui;

import com.google.gwt.core.client.GWT;

import com.tinesoft.gwt.dialogs.client.message.core.MessageDialogButtons;
import com.tinesoft.gwt.dialogs.client.message.core.MessageDialogDefaultButton;
import com.tinesoft.gwt.dialogs.client.message.core.MessageDialogEventAdapter;
import com.tinesoft.gwt.dialogs.client.message.core.MessageDialogEventListener;
import com.tinesoft.gwt.dialogs.client.message.core.MessageDialogIcon;
import com.tinesoft.gwt.dialogs.client.resources.MessageDialogResources;

/**
 * Displays message boxes on screen.
 * 
 * @author Tine Kondo
 */
public class MessageDialog {

    /**
     * Shows the question message dialog.
     * 
     * @param message the text to display.
     */
    public static void ask(final String message) {
        show("", message, MessageDialogButtons.YesNo, MessageDialogIcon.Question,
             MessageDialogDefaultButton.Button1, new MessageDialogEventAdapter() {});
    }

    /**
     * Shows the question message dialog with a title and a message.
     * 
     * @param title the title to the message dialog.
     * @param message the text to display.
     */
    public static void ask(final String title, final String message) {
        show(title, message, MessageDialogButtons.YesNo, MessageDialogIcon.Question,
             MessageDialogDefaultButton.Button1, new MessageDialogEventAdapter() {});
    }

    /**
     * Shows the question message dialog with a title, a message, and a listener.
     * 
     * @param title the title to the message dialog.
     * @param message the text to display.
     */
    public static void ask(final String title, final String message, final MessageDialogEventListener listener) {
        show(title, message, MessageDialogButtons.YesNo, MessageDialogIcon.Question,
             MessageDialogDefaultButton.None, listener);
    }

    /**
     * Shows the error message dialog.
     * 
     * @param message the text to display.
     */
    public static void error(final String message) {
        show("", message, MessageDialogButtons.OK, MessageDialogIcon.Error,
             MessageDialogDefaultButton.Button1, new MessageDialogEventAdapter() {});
    }

    /**
     * Shows the error message dialog.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     */
    public static void error(final String title, final String message) {
        show(title, message, MessageDialogButtons.OK, MessageDialogIcon.Error,
             MessageDialogDefaultButton.Button1, new MessageDialogEventAdapter() {});
    }

    /**
     * Shows the information message dialog with a title and a message.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     */
    public static void inform(final String message) {
        show("", message, MessageDialogButtons.OK, MessageDialogIcon.Information,
             MessageDialogDefaultButton.Button1, new MessageDialogEventAdapter() {});

    }

    /**
     * Shows the information message dialog.
     * 
     * @param message the text to display.
     */
    public static void inform(final String title, final String message) {
        show(title, message, MessageDialogButtons.OK, MessageDialogIcon.Information,
             MessageDialogDefaultButton.Button1, new MessageDialogEventAdapter() {});

    }

    /**
     * Shows a message dialog.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     * @param buttons the buttons to display.
     * @param icon the icon to display
     * @param defaultButton the default selected button
     * @param listener the listener to handle events on the MessageDialog (button clicked, ...).
     */
    public static void show(final String title, final String message, final MessageDialogButtons buttons, final MessageDialogIcon icon, final MessageDialogDefaultButton defaultButton, final MessageDialogEventListener listener) {
        new MessageDialog(title, message, buttons, icon, defaultButton, listener).show();
    }

    /**
     * Shows the warn message dialog.
     * 
     * @param message the text to display.
     */
    public static void warn(final String message) {
        show("", message, MessageDialogButtons.OK, MessageDialogIcon.Warning,
             MessageDialogDefaultButton.Button1, new MessageDialogEventAdapter() {});
    }

    /**
     * Shows the warn message dialog.
     * 
     * @param title the title of the message dialog with a title and a message.
     * @param message the text to display.
     */
    public static void warn(final String title, final String message) {
        show(title, message, MessageDialogButtons.OK, MessageDialogIcon.Warning,
             MessageDialogDefaultButton.Button1, new MessageDialogEventAdapter() {});
    }

    private final String title;
    private final String message;
    private final MessageDialogButtons buttons;
    private final MessageDialogIcon icon;
    private final MessageDialogDefaultButton defaultButton;
    private final MessageDialogWidget messageDialogWidget;
    private final MessageDialogEventListener listener;

    private static MessageDialogResources resources;

    /**
     * Gets the {@link MessageDialogResources} defining the css, images to use for styling the
     * widget.
     * 
     * @return the resources
     */
    public static MessageDialogResources getResources() {
        if (resources == null) {
            // we set the resources to the default one
            resources = GWT.create(MessageDialogResources.class);
            // we make sure that the new css style is injected
            resources.css().ensureInjected();
        }
        return resources;
    }

    /**
     * Sets the {@link MessageDialogResources} defining the css, images to use for styling the
     * widget.
     * 
     * @param resources the resources to set
     */
    public static void setResources(final MessageDialogResources resources) {
        MessageDialog.resources = resources;
    }

    /**
     * Constructor.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     * @param buttons the buttons to display.
     * @param icon the icon to display
     * @param defaultButton the default selected button
     * @param listener the listener to handle events on the MessageDialog (button clicked, ...).
     */
    private MessageDialog(final String title, final String message, final MessageDialogButtons buttons, final MessageDialogIcon icon, final MessageDialogDefaultButton defaultButton, final MessageDialogEventListener listener) {
        this.title = title;
        this.message = message;
        this.buttons = buttons;
        this.icon = icon;
        this.defaultButton = defaultButton;
        this.listener = listener;

        messageDialogWidget = new MessageDialogWidget(this, getResources());

    }

    /**
     * @return the buttons
     */
    public MessageDialogButtons getButtons() {
        return buttons;
    }

    /**
     * @return the defaultButton
     */
    public MessageDialogDefaultButton getDefaultButton() {
        return defaultButton;
    }

    /**
     * @return the icon
     */
    public MessageDialogIcon getIcon() {
        return icon;
    }

    /**
     * Returns the {@link MessageDialogEventListener} associated with this {@link MessageDialog}.
     * 
     * @return the {@link MessageDialogEventListener} associated with this {@link MessageDialog}.
     */
    public MessageDialogEventListener getListener() {
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
        messageDialogWidget.show();
    }

}
