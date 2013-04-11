
package com.tinesoft.gwt.dialogs.client.progress.core;

/**
 * The listener interface for receiving "interesting" events (button clicked, dialog closed,...) on
 * a progress dialog widget.
 * 
 * @author Tine Kondo
 */
public interface ProgressDialogEventListener {

    /**
     * Invoked when the 'Close' button of the dialog has been clicked.
     */
    void onCloseButtonClicked();

    /**
     * Invoked when the 'Cancel' button of the dialog has been clicked.
     */
    void onCancelButtonClicked();

}
