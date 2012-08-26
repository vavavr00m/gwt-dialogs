
package com.tinesoft.gwt.dialogs.client.color.core;

import com.google.gwt.event.shared.EventHandler;

/**
 * Custom event handler that fires {@link ColorChangedEvent}.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public interface ColorChangedHandler extends EventHandler {

    void onColorChanged(ColorChangedEvent event);
}
