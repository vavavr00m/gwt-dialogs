
package com.tinesoft.gwt.dialogs.client.color.core;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Custom event fired by a {@link HueChangedHandler} when its hue value has changed.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class HueChangedEvent extends GwtEvent<HueChangedHandler> {

    private static GwtEvent.Type<HueChangedHandler> TYPE;

    private final int hue;

    public HueChangedEvent(int hue) {
        this.hue = hue;
    }

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

    public int getHue() {
        return hue;
    }
}
