
package com.tinesoft.gwt.dialogs.client.color.core;

import com.google.gwt.event.shared.EventHandler;

/**
 * Custom event handler that fires {@link HueChangedEvent}.
 * 
 * @author Tine Kondo
 */
public interface HueChangedHandler extends EventHandler {

    /**
     * Called when a {@link HueChangedEvent} is fired.
     * 
     * @param event the {@link HueChangedEvent} that was fired
     */
    void OnHueChanged(HueChangedEvent event);
}
