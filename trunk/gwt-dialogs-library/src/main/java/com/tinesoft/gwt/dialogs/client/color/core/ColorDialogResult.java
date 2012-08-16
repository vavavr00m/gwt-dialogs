
package com.tinesoft.gwt.dialogs.client.color.core;

/**
 * All types of return values of a color dialog box
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public enum ColorDialogResult {

    /**
     * Nothing is returned from the color dialog box. This means that the modal dialog continues
     * running.
     */
    None,

    /**
     * The color dialog box return value is OK (usually sent from a button labeled OK).
     */
    OK,
    /**
     * The color dialog box return value is Cancel (usually sent from a button labeled Cancel).
     */
    Cancel
}
