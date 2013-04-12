
package com.tinesoft.gwt.dialogs.client.color.ui;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import com.tinesoft.gwt.dialogs.client.color.core.HueChangedEvent;
import com.tinesoft.gwt.dialogs.client.color.core.HueChangedHandler;
import com.tinesoft.gwt.dialogs.client.resources.ColorDialogResources;
import com.tinesoft.gwt.dialogs.client.util.ColorUtils;

/**
 * Widget that represents a vertical hue picker.
 * 
 * <p>
 * Note: The widget uses {@link Canvas} to
 * 
 * @author Tine Kondo
 * @version $Id$
 */
class HuePicker extends Composite {

    interface HuePickerUiBinder extends UiBinder<Widget, HuePicker> {
    }

    @UiField
    FlowPanel pCanvas;

    @UiField(provided = true)
    Canvas canvas;
    private int handleY = 90;

    private boolean mouseDown;

    final ColorDialogResources resources;

    private static final HuePickerUiBinder uiBinder = GWT.create(HuePickerUiBinder.class);

    /**
     * Constructs a new {@link HuePicker} using the given {@link ColorDialogResources}.
     * 
     * @param resources the {@link ColorDialogResources} to use for styling the widget
     */
    public HuePicker(final ColorDialogResources resources) {
        // as 'resources' is annotated with @UiField(provided = true), then
        // it must be instantiated before calling 'uiBinder.createAndBindUi(this)'
        this.resources = resources;

        canvas = Canvas.createIfSupported();
        if (canvas == null)
            throw new IllegalArgumentException(
                    "HuePicker requires HTML5's canvas. It seems you browser does not support them.");

        canvas.setPixelSize(26, 180);
        canvas.setCoordinateSpaceWidth(26);
        canvas.setCoordinateSpaceHeight(180);
        initWidget(uiBinder.createAndBindUi(this));
    }

    /**
     * Adds a {@link HueChangedHandler} to the widget.
     * 
     * @param handler the handler
     * @return {@link HandlerRegistration} used to remove the handler
     */
    public HandlerRegistration addHueChangedHandler(final HueChangedHandler handler) {
        return addHandler(handler, HueChangedEvent.getType());
    }

    private void drawGradient() {
        final Context2d ctx = canvas.getContext2d();

        // draw gradient
        ctx.setFillStyle("#ffffff"); //$NON-NLS-1$
        ctx.fillRect(0, 0, 26, 180);
        for (int y = 0; y <= 179; y++) {
            final String hex = ColorUtils.hsl2hex(y * 2, 100, 100);
            ctx.setFillStyle("#" + hex); //$NON-NLS-1$
            ctx.fillRect(3, y, 20, 1);
        }

        // draw handle
        if (handleY >= 0) {
            ctx.setFillStyle("#000000"); //$NON-NLS-1$

            ctx.beginPath();
            ctx.moveTo(3, handleY);
            ctx.lineTo(0, handleY - 3);
            ctx.lineTo(0, handleY + 3);
            ctx.closePath();
            ctx.fill();

            ctx.moveTo(23, handleY);
            ctx.lineTo(26, handleY - 3);
            ctx.lineTo(26, handleY + 3);
            ctx.closePath();
            ctx.fill();
        }
    }

    private void fireHueChanged(final int hue) {
        fireEvent(new HueChangedEvent(hue));
    }

    /**
     * Gets the current value of the hue displayed in the widget.
     * 
     * @return the current value of the hue
     */
    public int getHue() {
        return handleY * 2;
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        drawGradient();
    }

    @UiHandler("canvas")
    void onMouseDown(final MouseDownEvent event) {
        handleY = event.getRelativeY(canvas.getElement());
        drawGradient();
        fireHueChanged(getHue());

        mouseDown = true;
    }

    @UiHandler("canvas")
    void onMouseMove(final MouseMoveEvent event) {
        if (mouseDown) {
            handleY = event.getRelativeY(canvas.getElement());
            drawGradient();
            fireHueChanged(getHue());
        }
    }

    @UiHandler("canvas")
    void onMouseOut(final MouseOutEvent event) {
        mouseDown = false;
    }

    @UiHandler("canvas")
    void onMouseUp(final MouseUpEvent event) {
        mouseDown = false;
    }

    /**
     * Sets the current value of the hue displayed in the widget.
     * 
     * @param hue the new value of the hue
     */
    public void setHue(final int hue) {
        handleY = (int) Math.min(Math.max(Math.round(hue / 2d), 0d), 179d);
        drawGradient();
        fireHueChanged(hue);
    }
}
