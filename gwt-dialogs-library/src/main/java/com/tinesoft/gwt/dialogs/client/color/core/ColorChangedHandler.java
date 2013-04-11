
package com.tinesoft.gwt.dialogs.client.color.core;

import com.google.gwt.event.shared.EventHandler;

/**
 * Custom event handler that fires {@link ColorChangedEvent}.
 * 
 * @author Tine Kondo
 */
public interface ColorChangedHandler extends EventHandler {

    /**
     * Called when a {@link ColorChangedEvent} is fired.
     * 
     * @param event the {@link ColorChangedEvent} that was fired
     */
    void onColorChanged(ColorChangedEvent event);
}
