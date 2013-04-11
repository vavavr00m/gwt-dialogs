
package com.tinesoft.gwt.dialogs.client.color.core;

/**
 * The listener interface for receiving "interesting" events (button clicked, dialog closed,...) on
 * a color dialog widget.
 * 
 * @author Tine Kondo
 */
public interface ColorDialogEventListener {

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

}
