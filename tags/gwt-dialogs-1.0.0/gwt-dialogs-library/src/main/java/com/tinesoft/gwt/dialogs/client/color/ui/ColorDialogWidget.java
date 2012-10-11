
package com.tinesoft.gwt.dialogs.client.color.ui;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.tinesoft.gwt.dialogs.client.color.core.ColorChangedEvent;
import com.tinesoft.gwt.dialogs.client.color.core.HueChangedEvent;
import com.tinesoft.gwt.dialogs.client.message.ui.MessageDialog;
import com.tinesoft.gwt.dialogs.client.resources.ColorDialogResources;
import com.tinesoft.gwt.dialogs.client.util.ColorUtils;

public class ColorDialogWidget extends Composite implements ClickHandler {

    interface ColorDialogWidgetUiBinder extends UiBinder<Widget, ColorDialogWidget> {
    }

    /**
     * Custom {@link KeyPressHandler} that prevents to enter non digit in the source box widget (any
     * instance of {@link ValueBoxBase} like TextBox, IntegerBox, TextArea).
     * 
     * @author Tine Kondo<kondotine@gmail.com>
     */
    class NumbersOnlyKeyPressHandler implements KeyPressHandler {

        @Override
        public void onKeyPress(final KeyPressEvent event) {
            if (!Character.isDigit(event.getCharCode())) {
                if (event.getSource() instanceof ValueBoxBase) {
                    ((ValueBoxBase<?>) event.getSource()).cancelKey();
                }

            }

        }
    }

    private static final int DEFAULT_FADE_OUT = 500;

    private static final int DEFAULT_FADE_IN = 250;

    @UiField
    FlowPanel pMain;

    @UiField
    FocusPanel pFocusDialog;

    @UiField
    FlowPanel pBackground;

    @UiField
    FlowPanel pDialog;

    @UiField
    FlowPanel pTitleBar;

    @UiField
    HTML hTitle;

    @UiField
    Image iClose;

    @UiField
    FlowPanel pContent;

    @UiField
    FlowPanel pButtons;

    @UiField
    Button okButton;

    @UiField
    Button cancelButton;

    @UiField
    HTML hMessage;

    @UiField(provided = true)
    HuePicker huePicker;

    @UiField(provided = true)
    SaturationLightnessPicker slPicker;

    @UiField
    IntegerBox redColorIntegerBox;

    @UiField
    IntegerBox blueColorIntegerBox;

    @UiField
    IntegerBox greenColorIntegerBox;

    @UiField
    IntegerBox hueIntegerBox;

    @UiField
    TextBox pickedColorIntegerBox;

    final ColorDialogResources resources;

    private final ColorDialog colorDialog;

    private final ColorDialogWidgetUiBinder uiBinder = GWT.create(ColorDialogWidgetUiBinder.class);

    // // helpers for adding drag & drop support on the dialog box
    // private PickupDragController dragController;
    // private DropController dropController;

    public ColorDialogWidget(final ColorDialog colorDialog, final ColorDialogResources resources) {
        // as 'resources' is annotated with @UiField(provided = true), then
        // it must be instantiated before calling 'uiBinder.createAndBindUi(this)'
        this.resources = resources;
        // same for 'huePicker' and 'slPicker'
        huePicker = new HuePicker(resources);
        slPicker = new SaturationLightnessPicker(resources);

        initWidget(uiBinder.createAndBindUi(this));
        this.colorDialog = colorDialog;

        initialize();
    }

    public String getColor() {
        return slPicker.getColor();
    }

    /**
     * @return the colorDialog
     */
    public ColorDialog getColorDialog() {
        return colorDialog;
    }

    @UiFactory
    public ColorDialogResources getResources() {
        return resources;
    }

    /**
     * Hides the color dialog.
     */
    public void hide() {

        final Animation fade = new Animation() {

            @Override
            protected void onComplete() {
                super.onComplete();
                ColorDialogWidget.this.setVisible(false);
                ColorDialogWidget.this.removeFromParent();
            }

            @Override
            protected void onUpdate(final double progress) {
                ColorDialogWidget.this.getElement().getStyle().setOpacity(1 - progress);
            }
        };
        fade.run(DEFAULT_FADE_OUT);
        pFocusDialog.setFocus(false);
    }

    /**
     * Sets the title and the message that must be displayed on the {@link MessageDialog}, according
     * to its type.
     */
    private void initDisplayedContent() {
        if (colorDialog != null) {

            hTitle.setHTML(colorDialog.getTitle());
            hMessage.setHTML(colorDialog.getMessage());
        }

    }

    private void initDragAndDrop() {
        // // ensure the document BODY has dimensions in standards mode
        // RootPanel.get().setWidth("100%;");
        // RootPanel.get().setHeight("100%;");
        //
        // // create a DragController to manage drag-n-drop actions on the dialog
        // // note: This creates an implicit DropController for the boundary panel
        // dragController = new PickupDragController(RootPanel.get(), true);
        //
        // dropController = new FlowPanelDropController(pMain);
        //
        // dragController.registerDropController(dropController);
        //
        // // make the dialog draggable
        // dragController.makeDraggable(pFocusDialog);

    }

    /**
     * Initializes the color dialog.
     */
    private void initialize() {

        initDisplayedContent();

        initDragAndDrop();

        initEventHandlers();

    }

    /**
     * Initializes event handlers on color integer box (for red, green, blue, and hue value).
     */
    private void initEventHandlers() {
        final KeyPressHandler numbersOnlyHandler = new NumbersOnlyKeyPressHandler();

        final ValueChangeHandler<Integer> colorChangedHandler = new ValueChangeHandler<Integer>() {

            @Override
            public void onValueChange(ValueChangeEvent<Integer> event) {

                if (!(event.getValue() >= 0 && event.getValue() < 256)) {
                    // default valid value
                    ((IntegerBox) event.getSource()).setValue(255);
                }

                final int r = redColorIntegerBox.getValue();
                final int g = greenColorIntegerBox.getValue();
                final int b = blueColorIntegerBox.getValue();

                slPicker.setColor(ColorUtils.rgb2hex(r, g, b));
            }
        };

        // adds value changed handler on each color text box
        redColorIntegerBox.addValueChangeHandler(colorChangedHandler);
        blueColorIntegerBox.addValueChangeHandler(colorChangedHandler);
        greenColorIntegerBox.addValueChangeHandler(colorChangedHandler);

        // prevents entering of non digits values in color text boxes
        redColorIntegerBox.addKeyPressHandler(numbersOnlyHandler);
        greenColorIntegerBox.addKeyPressHandler(numbersOnlyHandler);
        blueColorIntegerBox.addKeyPressHandler(numbersOnlyHandler);
        hueIntegerBox.addKeyPressHandler(numbersOnlyHandler);

    }

    @UiHandler("cancelButton")
    void onCancelButtonClicked(final ClickEvent event) {
        if ((colorDialog != null) && (colorDialog.getListener() != null)) {
            colorDialog.getListener().onCancelButtonClicked();
            hide();
        }
    }

    @Override
    public void onClick(final ClickEvent event) {
        if ((colorDialog != null) && (colorDialog.getListener() != null)) {
            colorDialog.getListener().onCloseButtonClicked();
            hide();
        }
    }

    @UiHandler("iClose")
    public void onCloseClicked(final ClickEvent event) {
        if ((colorDialog != null) && (colorDialog.getListener() != null)) {
            colorDialog.getListener().onCloseButtonClicked();
            hide();
        }
    }

    @UiHandler("slPicker")
    void onColorChanged(final ColorChangedEvent event) {
        ColorDialog.setColor(event.getColor());

        // we also set the R, G, B text boxes values
        final int[] rgb = ColorUtils.getRGB(event.getColor());
        redColorIntegerBox.setValue(rgb[0]);
        blueColorIntegerBox.setValue(rgb[1]);
        greenColorIntegerBox.setValue(rgb[2]);

        pickedColorIntegerBox.setText(event.getColor());
    }

    @UiHandler("pFocusDialog")
    void onDialogKeyDown(final KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            onEnterKeyDown();
        } else if (event.getNativeKeyCode() == KeyCodes.KEY_ESCAPE) {
            onEscapeKeyDown();
        }
    }

    protected void onEnterKeyDown() {
        if ((colorDialog != null) && (colorDialog.getListener() != null)) {
            colorDialog.getListener().onOkButtonClicked();
            hide();

        }
    }

    protected void onEscapeKeyDown() {
        if ((colorDialog != null) && (colorDialog.getListener() != null)) {
            colorDialog.getListener().onCloseButtonClicked();
            hide();
        }
    }

    // bind saturation/lightness picker and hue picker together
    @UiHandler("huePicker")
    void onHueChanged(final HueChangedEvent event) {
        slPicker.setHue(event.getHue());
        hueIntegerBox.setValue(event.getHue());
    }

    @UiHandler("hueIntegerBox")
    void onHueIntegerBoxValueChanged(final ValueChangeEvent<Integer> event) {
        if ((event.getValue() >= 0) && (event.getValue() <= 360)) {
            slPicker.setHue(event.getValue());
            huePicker.setHue(event.getValue());
        } else {
            hueIntegerBox.setValue(360);
        }
    }

    @UiHandler("okButton")
    void onOkButtonClicked(final ClickEvent event) {
        if ((colorDialog != null) && (colorDialog.getListener() != null)) {
            colorDialog.getListener().onOkButtonClicked();
            hide();
        }
    }

    public void setColor(final String color) {
        final int[] rgb = ColorUtils.getRGB(color);
        final int[] hsl = ColorUtils.rgb2hsl(rgb);
        huePicker.setHue(hsl[0]);
        slPicker.setColor(color);
        ColorDialog.setColor(color);

    }

    /**
     * Shows the color dialog.
     */
    public void show() {

        RootPanel.get().add(this);

        this.getElement().getStyle().setOpacity(0);
        this.setVisible(true);
        final Animation fade = new Animation() {

            @Override
            protected void onUpdate(final double progress) {
                ColorDialogWidget.this.getElement().getStyle().setOpacity(progress);
            }
        };
        fade.run(DEFAULT_FADE_IN);
        pFocusDialog.setFocus(true);
    }
}
