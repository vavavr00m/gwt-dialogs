
package com.tinesoft.gwt.dialogs.client.message.core;

import com.tinesoft.gwt.dialogs.client.message.ui.MessageDialog;

/**
 * All types of buttons that can appear in a {@link MessageDialog}.
 * 
 * @author Tine Kondo
 */
public enum MessageDialogButtons {

    /**
     * The message box contains an OK button.
     */
    OK,
    /**
     * The message box contains OK and Cancel buttons.
     */
    OKCancel,
    /**
     * The message box contains Yes and No buttons.
     */
    YesNo,
    /**
     * The message box contains Yes, No, and Cancel buttons.
     */
    YesNoCancel,
    /**
     * The message box contains Retry and Cancel buttons.
     */
    RetryCancel,
    /**
     * The message box contains Abort, Retry, and Ignore buttons.
     */
    AbortRetryIgnore

}
