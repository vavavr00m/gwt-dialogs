
package com.tinesoft.gwt.dialogs.client.progress.ui;

import com.google.gwt.core.client.GWT;

import com.tinesoft.gwt.dialogs.client.progress.core.ProgressDialogEventListener;
import com.tinesoft.gwt.dialogs.client.resources.ProgressDialogResources;

/**
 * Displays a progress dialog on screen.
 * 
 * @author Tine Kondo
 */
public class ProgressDialog {

    /**
     * Dismisses the progress dialog.
     */
    public static void dismiss() {
        if (null != dialog && null != dialog.progressDialogWidget) {
            dialog.progressDialogWidget.hide();
        }
    }

    /**
     * Shows a progress dialog.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     * @param listener the listener to handle events on the ProgressDialog (button clicked, ...).
     */
    public static void show(final String title, final String message, final ProgressDialogEventListener listener) {
        dialog = new ProgressDialog(title, message, false, listener);
        dialog.show();
    }

    /**
     * Shows a progress dialog.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     * @param isCancelButtonVisible indicates if the cancel button on the progress dialog should be
     *            visible.
     * @param listener the listener to handle events on the ProgressDialog (button clicked, ...).
     */
    public static void show(final String title, final String message, final boolean isCancelButtonVisible, final ProgressDialogEventListener listener) {
        dialog = new ProgressDialog(title, message, isCancelButtonVisible, listener);
        dialog.show();
    }

    private final String title;
    private final String message;
    private final boolean cancelButtonVisible;
    private final ProgressDialogWidget progressDialogWidget;
    private final ProgressDialogEventListener listener;

    private static ProgressDialog dialog;
    private static ProgressDialogResources resources;

    /**
     * Gets the {@link ProgressDialogResources} defining the css, images to use for styling the
     * widget.
     * 
     * @return the resources
     */
    public static ProgressDialogResources getResources() {
        if (resources == null) {
            // we set the resources to the default one
            resources = GWT.create(ProgressDialogResources.class);
            // we make sure that the new css style is injected
            resources.css().ensureInjected();
        }
        return resources;
    }

    /**
     * Sets the {@link ProgressDialogResources} defining the css, images to use for styling the
     * widget.
     * 
     * @param resources the resources to set
     */
    public static void setResources(final ProgressDialogResources resources) {
        ProgressDialog.resources = resources;
    }

    /**
     * Constructor.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     * @param isCancelButtonVisible indicates if the cancel button on the progress dialog should be
     *            visible.
     * @param listener the listener to handle events on the ProgressDialog (button clicked, ...).
     */
    private ProgressDialog(final String title, final String message, final boolean isCancelButtonVisible, final ProgressDialogEventListener listener) {
        this.title = title;
        this.message = message;
        cancelButtonVisible = isCancelButtonVisible;
        this.listener = listener;

        progressDialogWidget = new ProgressDialogWidget(this, getResources());

    }

    /**
     * Returns the {@link ProgressDialogEventListener} associated with this {@link ProgressDialog}.
     * 
     * @return the {@link ProgressDialogEventListener} associated with this {@link ProgressDialog}.
     */
    public ProgressDialogEventListener getListener() {
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

    /**
     * @return the cancelButtonVisible
     */
    public boolean isCancelButtonVisible() {
        return cancelButtonVisible;
    }

    private void show() {
        progressDialogWidget.show();
    }

}
