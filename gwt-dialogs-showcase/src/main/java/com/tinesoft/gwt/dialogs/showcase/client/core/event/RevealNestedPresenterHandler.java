
package com.tinesoft.gwt.dialogs.showcase.client.core.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for {@link RevealNestedPresenterEvent}.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: RevealNestedPresenterHandler.java 2509 2011-06-14 08:33:50Z kondotine $
 */
public interface RevealNestedPresenterHandler extends EventHandler {

    /**
     * Fired when the nested presenters should be reveal.
     * 
     * @param event the {@link RevealNestedPresenterEvent} event.
     */
    void onRevealNestedPresenter(RevealNestedPresenterEvent event);

}
