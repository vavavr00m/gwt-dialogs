
package com.tinesoft.gwt.dialogs.client.message.core;

/**
 * All types of return values of a dialog box.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public enum MessageBoxResult {

    /**
     * Nothing is returned from the dialog box. This means that the modal dialog continues running.
     */
    None,

    /**
     * The dialog box return value is OK (usually sent from a button labeled OK).
     */
    OK,
    /**
     * The dialog box return value is Cancel (usually sent from a button labeled Cancel).
     */
    Cancel,
    /**
     * The dialog box return value is Abort (usually sent from a button labeled Abort).
     */
    Abort,
    /**
     * The dialog box return value is Retry (usually sent from a button labeled Retry).
     */
    Retry,
    /**
     * The dialog box return value is Ignore (usually sent from a button labeled Ignore).
     */
    Ignore,
    /**
     * The dialog box return value is Yes (usually sent from a button labeled Yes).
     */
    Yes,
    /**
     * The dialog box return value is No (usually sent from a button labeled No).
     */
    No

}
