
package com.tinesoft.gwt.dialogs.showcase.client.core.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for {@link RevealNestedPresenterEvent}.
 * 
 * @author Tine Kondo
 */
public interface RevealNestedPresenterHandler extends EventHandler {

    /**
     * Fired when the nested presenters should be reveal.
     * 
     * @param event the {@link RevealNestedPresenterEvent} event.
     */
    void onRevealNestedPresenter(RevealNestedPresenterEvent event);

}
