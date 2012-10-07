
package com.tinesoft.gwt.dialogs.client.progress.ui;

import com.google.gwt.core.client.GWT;
import com.tinesoft.gwt.dialogs.client.progress.core.ProgressDialogEventListener;
import com.tinesoft.gwt.dialogs.client.resources.ProgressDialogResources;

/**
 * Displays a progress dialog on screen.
 * <p>
 * You must add the following code during {@code #onModuleLoad()} in order to load the styling.
 * </p>
 * 
 * <pre>
 * (ProgressDialogResources) GWT.create(ProgressDialogResources.class)).css().ensureInjected();
 * </pre>
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class ProgressDialog {

    /**
     * Shows a progress dialog.
     * 
     * @param title the title of the message dialog.
     * @param message the text to display.
     * @param listener the listener to handle events on the ProgressDialog (button clicked, ...).
     */
    public static void show(final String title, final String message, final ProgressDialogEventListener listener) {
        new ProgressDialog(title, message, false, listener).show();
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
        new ProgressDialog(title, message, isCancelButtonVisible, listener).show();
    }

    private final String title;
    private final String message;
    private final boolean cancelButtonVisible;
    private final ProgressDialogWidget progressDialogWidget;
    private final ProgressDialogEventListener listener;

    private static ProgressDialogResources resources;

    /**
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
