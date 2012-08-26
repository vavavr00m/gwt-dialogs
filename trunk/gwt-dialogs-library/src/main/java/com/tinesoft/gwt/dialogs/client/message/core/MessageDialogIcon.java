
package com.tinesoft.gwt.dialogs.client.message.core;

import com.tinesoft.gwt.dialogs.client.message.ui.MessageDialog;

/**
 * All types of icons that can appear in a {@link MessageDialog}.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public enum MessageDialogIcon {

    /**
     * The message box contain no symbols.
     */
    None,
    /**
     * The message box contains a symbol consisting of a lowercase letter i in a circle.
     */
    Information,
    /**
     * The message box contains a symbol consisting of a question mark in a circle.
     */
    Question,
    /**
     * The message box contains a symbol consisting of an exclamation point in a triangle with a
     * yellow background.
     */
    Warning,
    /**
     * The message box contains a symbol consisting of white X in a circle with a red background.
     */
    Error

}
