
package com.tinesoft.gwt.dialogs.client.color.core;

import com.google.gwt.event.shared.EventHandler;

/**
 * Custom event handler that fires {@link HueChangedEvent}.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public interface HueChangedHandler extends EventHandler {

    void OnHueChanged(HueChangedEvent event);
}
