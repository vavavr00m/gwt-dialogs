
package com.tinesoft.gwt.dialogs.client.color.core;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Custom event fired by a {@link ColorChangedHandler} when its color has changed.
 * 
 * @author Tine Kondo
 */
public class ColorChangedEvent extends GwtEvent<ColorChangedHandler> {

    private static GwtEvent.Type<ColorChangedHandler> TYPE;

    private final String color;

    /**
     * Constructs a {@link ColorChangedEvent} with the given color.
     * 
     * @param color the color
     */
    public ColorChangedEvent(String color) {
        this.color = color;
    }

    /**
     * Gets the event type associated with the {@link ColorChangedEvent} events.
     * 
     * @return the handler type
     */
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

    /**
     * Gets the color associated with this event.
     * 
     * @return the color associated with this event
     */
    public String getColor() {
        return color;
    }
}
