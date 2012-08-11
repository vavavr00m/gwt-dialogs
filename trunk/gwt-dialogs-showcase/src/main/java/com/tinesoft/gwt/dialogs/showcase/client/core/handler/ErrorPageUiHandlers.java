
package com.tinesoft.gwt.dialogs.showcase.client.core.handler;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Error page handler.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: ErrorPageUiHandlers.java 2509 2011-06-14 08:33:50Z kondotine $
 */
public interface ErrorPageUiHandlers extends UiHandlers {

    /**
     * Fired on 'Try Again' button click.
     */
    void onReTryClicked();
}
