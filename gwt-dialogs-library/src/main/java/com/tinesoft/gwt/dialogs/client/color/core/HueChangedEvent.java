
package com.tinesoft.gwt.dialogs.client.color.core;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Custom event fired by a {@link HueChangedHandler} when its hue value has changed.
 * 
 * @author Tine Kondo
 */
public class HueChangedEvent extends GwtEvent<HueChangedHandler> {

    private static GwtEvent.Type<HueChangedHandler> TYPE;

    private final int hue;

    /**
     * Constructs a new {@link HueChangedEvent} using the given hue.
     * 
     * @param hue the hue
     */
    public HueChangedEvent(int hue) {
        this.hue = hue;
    }

    /**
     * Gets the event type associated with the {@link HueChangedEvent} events.
     * 
     * @return the handler type
     */
    public static GwtEvent.Type<HueChangedHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<HueChangedHandler>();
        }
        return TYPE;
    }

    @Override
    public GwtEvent.Type<HueChangedHandler> getAssociatedType() {
        return getType();
    }

    @Override
    protected void dispatch(HueChangedHandler handler) {
        handler.OnHueChanged(this);
    }

    /**
     * Gets the hue value associated with this event.
     * 
     * @return the hue value associated with this event
     */
    public int getHue() {
        return hue;
    }
}
