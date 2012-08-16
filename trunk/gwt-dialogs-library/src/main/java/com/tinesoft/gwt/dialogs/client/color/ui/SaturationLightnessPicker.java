
package com.tinesoft.gwt.dialogs.client.color.ui;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.CanvasPixelArray;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.ImageData;
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
import com.tinesoft.gwt.dialogs.client.color.core.ColorChangedEvent;
import com.tinesoft.gwt.dialogs.client.color.core.ColorChangedHandler;
import com.tinesoft.gwt.dialogs.client.resources.ColorDialogResources;
import com.tinesoft.gwt.dialogs.client.util.ColorUtils;

public class SaturationLightnessPicker extends Composite {

    interface SaturationLightnessPickerUiBinder extends UiBinder<Widget, SaturationLightnessPicker> {
    }

    @UiField
    FlowPanel pCanvas;

    @UiField(provided = true)
    Canvas canvas;

    private int hue = 180;
    private int handleX = 90;
    private int handleY = 90;

    private boolean mouseDown;

    final ColorDialogResources resources;

    private final static SaturationLightnessPickerUiBinder uiBinder = GWT.create(SaturationLightnessPickerUiBinder.class);

    public SaturationLightnessPicker(final ColorDialogResources resources) {
        // as 'resources' is annotated with @UiField(provided = true), then
        // it must be instantiated before calling 'uiBinder.createAndBindUi(this)'
        this.resources = resources;

        this.canvas = Canvas.createIfSupported();
        this.canvas.setPixelSize(180, 180);
        this.canvas.setCoordinateSpaceWidth(180);
        this.canvas.setCoordinateSpaceHeight(180);

        initWidget(uiBinder.createAndBindUi(this));

    }

    public HandlerRegistration addColorChangedHandler(final ColorChangedHandler handler) {
        return addHandler(handler, ColorChangedEvent.getType());
    }

    private void drawGradient(final boolean drawHandle) {
        final Context2d ctx = canvas.getContext2d();

        // draw gradient
        for (int x = 0; x <= 179; x++) {
            final CanvasGradient grad = ctx.createLinearGradient(x, 0, x, 179);
            final int s = Math.round((x * 100) / 179);
            String hex = ColorUtils.hsl2hex(hue, s, 0);
            grad.addColorStop(0, "#" + hex); //$NON-NLS-1$
            hex = ColorUtils.hsl2hex(hue, s, 100);
            grad.addColorStop(1, "#" + hex); //$NON-NLS-1$
            ctx.setFillStyle(grad);
            ctx.fillRect(x, 0, 1, 180);
        }

        // draw handle
        if (drawHandle) {
            ctx.beginPath();
            ctx.arc(handleX, handleY, 3, 0, Math.PI * 2, false);
            ctx.closePath();
            ctx.setFillStyle("#ffffff"); //$NON-NLS-1$
            ctx.fill();

            ctx.beginPath();
            ctx.arc(handleX, handleY, 2, 0, Math.PI * 2, false);
            ctx.closePath();
            ctx.setFillStyle("#000000"); //$NON-NLS-1$
            ctx.fill();
        }
    }

    private void fireColorChanged(final String color) {
        if (color != null) {
            // color is formatted in hexadecimal representation;
            final String c = (color.contains("#")) ? color : "#" + color;
            fireEvent(new ColorChangedEvent(c));
        }

    }

    public String getColor() {
        drawGradient(false);
        final String color = getColorAtPixel(handleX, handleY);
        drawGradient(true);
        return color;
    }

    private String getColorAtPixel(int x, int y) {
        x = Math.max(Math.min(x, 179), 0);
        y = Math.max(Math.min(y, 179), 0);
        final Context2d ctx = canvas.getContext2d();
        final ImageData imageData = ctx.getImageData(x, y, 1, 1);
        final CanvasPixelArray data = imageData.getData();
        return ColorUtils.rgb2hex(data.get(0), data.get(1), data.get(2));
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        drawGradient(true);
    }

    @UiHandler("canvas")
    void onMouseDown(final MouseDownEvent event) {
        handleX = event.getRelativeX(canvas.getElement());
        handleY = event.getRelativeY(canvas.getElement());
        drawGradient(false);
        final String color = getColorAtPixel(handleX, handleY);
        drawGradient(true);
        fireColorChanged(color);

        mouseDown = true;
    }

    @UiHandler("canvas")
    void onMouseMove(final MouseMoveEvent event) {
        if (mouseDown) {
            handleX = event.getRelativeX(canvas.getElement());
            handleY = event.getRelativeY(canvas.getElement());
            drawGradient(false);
            final String color = getColorAtPixel(handleX, handleY);
            drawGradient(true);
            fireColorChanged(color);
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
     * Sets the color displayed by the picker. The color string can be represented in 3 different
     * modes:
     * <ul>
     * <li>in hexadecimal mode. Eg: #ff0000</li>
     * <li>in RBG mode. Eg: rgb(255,0,0)</li>
     * <li>in RBGA mode. Eg: rgba(255,0,0,a)</li>
     * </ul>
     * 
     * The method fires a {@link ColorChangedEvent} with the new color (in hexadecimal) as argument.
     * 
     * @param color the new color to set (in hexadecimal representation with or without the '#').
     */
    public void setColor(final String color) {
        final int[] rgb = ColorUtils.getRGB(color);
        final int[] hsl = ColorUtils.rgb2hsl(rgb);
        hue = hsl[0];
        handleX = (int) Math.min(Math.max(Math.round((hsl[1] * 180d) / 100d), 0), 179);
        handleY = (int) Math.min(Math.max(Math.round((hsl[2] * 180d) / 100d), 0), 179);
        drawGradient(true);
        fireColorChanged(ColorUtils.rgb2hex(rgb));
    }

    /**
     * Sets the hue value of the picker.
     * 
     * @param hue the new hue value to set .
     */
    public void setHue(final int hue) {
        this.hue = hue;
        drawGradient(false);
        final String color = getColorAtPixel(handleX, handleY);
        drawGradient(true);
        fireColorChanged(color);
    }
}
