
package com.tinesoft.gwt.dialogs.client.color.ui;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.google.gwt.animation.client.Animation;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.tinesoft.gwt.dialogs.client.color.core.ColorChangedEvent;
import com.tinesoft.gwt.dialogs.client.color.core.HueChangedEvent;
import com.tinesoft.gwt.dialogs.client.message.ui.MessageBox;
import com.tinesoft.gwt.dialogs.client.resources.ColorDialogResources;
import com.tinesoft.gwt.dialogs.client.util.ColorUtils;

public class ColorDialogWidget extends Composite implements ClickHandler {

    interface ColorDialogWidgetUiBinder extends UiBinder<Widget, ColorDialogWidget> {
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

    final ColorDialogResources resources;

    private final ColorDialog colorDialog;

    private final ColorDialogWidgetUiBinder uiBinder = GWT.create(ColorDialogWidgetUiBinder.class);

    // helpers for adding drag & drop support on the dialog box
    private PickupDragController dragController;
    private DropController dropController;

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
     * Sets the title and the message that must be displayed on the {@link MessageBox}, according to
     * its type.
     */
    private void initDisplayedContent() {
        if (colorDialog != null) {

            hTitle.setHTML(colorDialog.getTitle());
            hMessage.setHTML(colorDialog.getMessage());
        }

    }

    // bind saturation/lightness picker and hue picker together
    @UiHandler("huePicker")
    void onHueChanged(HueChangedEvent event) {
        slPicker.setHue(event.getHue());
    }

    @UiHandler("slPicker")
    void onColorChanged(ColorChangedEvent event) {
        ColorDialog.setColor(event.getColor());
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
     * Initializes the message box title, message, icon, and event handlers.
     */
    private void initialize() {

        initDisplayedContent();

        initDragAndDrop();

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

    @UiHandler("okButton")
    void onOkButtonClicked(final ClickEvent event) {
        if ((colorDialog != null) && (colorDialog.getListener() != null)) {
            colorDialog.getListener().onOkButtonClicked();
            hide();
        }
    }

    public void show() {

        RootPanel.get().add(this);

        getElement().getStyle().setOpacity(0);
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

    public void setColor(String color) {
        int[] rgb = ColorUtils.getRGB(color);
        int[] hsl = ColorUtils.rgb2hsl(rgb);
        huePicker.setHue(hsl[0]);
        slPicker.setColor(color);
        ColorDialog.setColor(color);

    }

    public String getColor() {
        return slPicker.getColor();
    }

}
