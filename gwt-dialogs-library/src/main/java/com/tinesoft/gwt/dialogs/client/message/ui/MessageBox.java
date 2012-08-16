
package com.tinesoft.gwt.dialogs.client.message.ui;

import com.google.gwt.core.client.GWT;
import com.tinesoft.gwt.dialogs.client.message.core.MessageBoxButtons;
import com.tinesoft.gwt.dialogs.client.message.core.MessageBoxDefaultButton;
import com.tinesoft.gwt.dialogs.client.message.core.MessageBoxEventAdapter;
import com.tinesoft.gwt.dialogs.client.message.core.MessageBoxEventListener;
import com.tinesoft.gwt.dialogs.client.message.core.MessageBoxIcon;
import com.tinesoft.gwt.dialogs.client.resources.MessageBoxResources;

/**
 * Displays message boxes on screen.
 * <p>
 * You must add the following code during {@code #onModuleLoad()} in order to load the styling.
 * </p>
 * 
 * <pre>
 * (MessageBoxResources) GWT.create(MessageBoxResources.class)).css().ensureInjected();
 * </pre>
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public class MessageBox {

    /**
     * Shows the question message dialog.
     * 
     * @param message the text to display.
     */
    public static void ask(final String message) {
        show("", message, MessageBoxButtons.YesNo, MessageBoxIcon.Question,
             MessageBoxDefaultButton.Button1, new MessageBoxEventAdapter() {});
    }

    /**
     * Shows the question message dialog with a title and a message.
     * 
     * @param title the title to the message dialog.
     * @param message the text to display.
     */
    public static void ask(final String title, final String message) {
        show(title, message, MessageBoxButtons.YesNo, MessageBoxIcon.Question,
             MessageBoxDefaultButton.Button1, new MessageBoxEventAdapter() {});
    }

    /**
     * Shows the question message dialog with a title, a message, and a listener.
     * 
     * @param title the title to the message dialog.
     * @param message the text to display.
     */
    public static void ask(final String title, final String message, final MessageBoxEventListener listener) {
        show(title, message, MessageBoxButtons.YesNo, MessageBoxIcon.Question,
             MessageBoxDefaultButton.None, listener);
    }

    /**
     * Shows the error message dialog.
     * 
     * @param message the text to display.
     */
    public static void error(final String message) {
        show("", message, MessageBoxButtons.OK, MessageBoxIcon.Error,
             MessageBoxDefaultButton.Button1, new MessageBoxEventAdapter() {});
    }

    /**
     * Shows the error message dialog.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     */
    public static void error(final String title, final String message) {
        show(title, message, MessageBoxButtons.OK, MessageBoxIcon.Error,
             MessageBoxDefaultButton.Button1, new MessageBoxEventAdapter() {});
    }

    /**
     * Shows the information message dialog with a title and a message.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     */
    public static void inform(final String message) {
        show("", message, MessageBoxButtons.OK, MessageBoxIcon.Information,
             MessageBoxDefaultButton.Button1, new MessageBoxEventAdapter() {});

    }

    /**
     * Shows the information message dialog.
     * 
     * @param message the text to display.
     */
    public static void inform(final String title, final String message) {
        show(title, message, MessageBoxButtons.OK, MessageBoxIcon.Information,
             MessageBoxDefaultButton.Button1, new MessageBoxEventAdapter() {});

    }

    /**
     * Shows a message dialog.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     * @param buttons the buttons to display.
     * @param icon the icon to display
     * @param defaultButton the default selected button
     * @param listener the listener to handle events on the MessageBox (button clicked, ...).
     */
    public static void show(final String title, final String message, final MessageBoxButtons buttons, final MessageBoxIcon icon, final MessageBoxDefaultButton defaultButton, final MessageBoxEventListener listener) {
        new MessageBox(title, message, buttons, icon, defaultButton, listener).show();
    }

    /**
     * Shows the warn message dialog.
     * 
     * @param message the text to display.
     */
    public static void warn(final String message) {
        show("", message, MessageBoxButtons.OK, MessageBoxIcon.Warning,
             MessageBoxDefaultButton.Button1, new MessageBoxEventAdapter() {});
    }

    /**
     * Shows the warn message dialog.
     * 
     * @param title the title of the message dialog with a title and a message.
     * @param message the text to display.
     */
    public static void warn(final String title, final String message) {
        show(title, message, MessageBoxButtons.OK, MessageBoxIcon.Warning,
             MessageBoxDefaultButton.Button1, new MessageBoxEventAdapter() {});
    }

    private final String title;
    private final String message;
    private final MessageBoxButtons buttons;
    private final MessageBoxIcon icon;
    private final MessageBoxDefaultButton defaultButton;
    private final MessageBoxWidget messageBoxWidget;
    private final MessageBoxEventListener listener;

    private static MessageBoxResources resources;

    /**
     * @return the resources
     */
    public static MessageBoxResources getResources() {
        if (resources == null) {
            // we set the resources to the default one
            resources = GWT.create(MessageBoxResources.class);
            // we make sure that the new css style is injected
            resources.css().ensureInjected();
        }
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public static void setResources(final MessageBoxResources resources) {
        MessageBox.resources = resources;
    }

    /**
     * Constructor.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     * @param buttons the buttons to display.
     * @param icon the icon to display
     * @param defaultButton the default selected button
     * @param listener the listener to handle events on the MessageBox (button clicked, ...).
     */
    private MessageBox(final String title, final String message, final MessageBoxButtons buttons, final MessageBoxIcon icon, final MessageBoxDefaultButton defaultButton, final MessageBoxEventListener listener) {
        this.title = title;
        this.message = message;
        this.buttons = buttons;
        this.icon = icon;
        this.defaultButton = defaultButton;
        this.listener = listener;

        messageBoxWidget = new MessageBoxWidget(this, getResources());

    }

    /**
     * @return the buttons
     */
    public MessageBoxButtons getButtons() {
        return buttons;
    }

    /**
     * @return the defaultButton
     */
    public MessageBoxDefaultButton getDefaultButton() {
        return defaultButton;
    }

    /**
     * @return the icon
     */
    public MessageBoxIcon getIcon() {
        return icon;
    }

    /**
     * Returns the {@link MessageBoxEventListener} associated with this {@link MessageBox}.
     * 
     * @return the {@link MessageBoxEventListener} associated with this {@link MessageBox}.
     */
    public MessageBoxEventListener getListener() {
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
        messageBoxWidget.show();
    }

}
