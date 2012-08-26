
package com.tinesoft.gwt.dialogs.client.color.core;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Custom event fired by a {@link ColorChangedHandler} when its color has changed.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public class ColorChangedEvent extends GwtEvent<ColorChangedHandler> {

    private static GwtEvent.Type<ColorChangedHandler> TYPE;

    private final String color;

    public ColorChangedEvent(String color) {
        this.color = color;
    }

    public static GwtEvent.Type<ColorChangedHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<ColorChangedHandler>();
        }
        return TYPE;
    }

    @Override
    public GwtEvent.Type<ColorChangedHandler> getAssociatedType() {
        return getType();
    }

    @Override
    protected void dispatch(ColorChangedHandler handler) {
        handler.onColorChanged(this);
    }

    public String getColor() {
        return color;
    }
}
