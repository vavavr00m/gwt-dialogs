
package com.tinesoft.gwt.dialogs.client.message.core;

/**
 * The listener interface for receiving "interesting" events (button clicked, dialog closed,...) on
 * a message dialog widget.
 * 
 * @author Tine Kondo
 */
public interface MessageDialogEventListener {

    /**
     * Invoked when the 'Close' button of the dialog has been clicked.
     */
    void onCloseButtonClicked();

    /**
     * Invoked when the 'OK' button of the dialog has been clicked.
     */
    void onOkButtonClicked();

    /**
     * Invoked when the 'Cancel' button of the dialog has been clicked.
     */
    void onCancelButtonClicked();

    /**
     * Invoked when the 'Abort' button of the dialog has been clicked.
     */
    void onAbortButtonClicked();

    /**
     * Invoked when the 'Retry' button of the dialog has been clicked.
     */
    void onRetryButtonClicked();

    /**
     * Invoked when the 'Ignore' button of the dialog has been clicked.
     */
    void onIgnoreButtonClicked();

    /**
     * Invoked when the 'Yes' button of the dialog has been clicked.
     */
    void onYesButtonClicked();

    /**
     * Invoked when the 'No' button of the dialog has been clicked.
     */
    void onNoButtonClicked();
}
