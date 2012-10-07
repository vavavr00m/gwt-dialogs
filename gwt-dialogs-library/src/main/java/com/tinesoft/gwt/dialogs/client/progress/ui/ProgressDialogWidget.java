
package com.tinesoft.gwt.dialogs.client.progress.ui;

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
import com.tinesoft.gwt.dialogs.client.resources.ProgressDialogResources;

public class ProgressDialogWidget extends Composite implements ClickHandler {

    interface MessageBoxWidgetUiBinder extends UiBinder<Widget, ProgressDialogWidget> {
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
    Image iProgressBar;

    @UiField
    HTML hMessage;

    @UiField
    FlowPanel pButtons;

    @UiField
    Button cancelButton;

    final ProgressDialogResources resources;

    private final ProgressDialog progressDialog;

    private final MessageBoxWidgetUiBinder uiBinder = GWT.create(MessageBoxWidgetUiBinder.class);

    // // helpers for adding drag & drop support on the dialog box
    // private PickupDragController dragController;
    // private DropController dropController;

    public ProgressDialogWidget(final ProgressDialog progressDialog, final ProgressDialogResources resources) {
        // as 'resources' is annotated with @UiField(provided = true), then
        // it must be instantiated before calling 'uiBinder.createAndBindUi(this)'
        this.resources = resources;
        initWidget(uiBinder.createAndBindUi(this));
        this.progressDialog = progressDialog;

        initialize();
    }

    /**
     * @return the progressDialog
     */
    public ProgressDialog getMessageBox() {
        return progressDialog;
    }

    @UiFactory
    public ProgressDialogResources getResources() {
        return resources;
    }

    public void hide() {

        final Animation fade = new Animation() {

            @Override
            protected void onComplete() {
                super.onComplete();
                ProgressDialogWidget.this.setVisible(false);
                ProgressDialogWidget.this.removeFromParent();
            }

            @Override
            protected void onUpdate(final double progress) {
                ProgressDialogWidget.this.getElement().getStyle().setOpacity(1 - progress);
            }
        };
        fade.run(DEFAULT_FADE_OUT);
        pFocusDialog.setFocus(false);
    }

    /**
     * Initializes the buttons that must be displayed on the {@link ProgressDialog}, according to
     * its type.
     */
    private void initDisplayedButtons() {

        if (progressDialog != null) {

            cancelButton.addStyleName(resources.css().selectedButton());
            cancelButton.setVisible(progressDialog.isCancelButtonVisible());
        }

    }

    /**
     * Sets the title and the message that must be displayed on the {@link ProgressDialog},
     * according to its type.
     */
    private void initDisplayedContent() {
        if (progressDialog != null) {

            hTitle.setHTML(progressDialog.getTitle());
            hMessage.setHTML(progressDialog.getMessage());
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
     * Initializes the message box title, message, icon, and event handlers.
     */
    private void initialize() {

        initDisplayedContent();

        initDisplayedButtons();

        initDragAndDrop();

    }

    @UiHandler("cancelButton")
    void onCancelButtonClicked(final ClickEvent event) {
        if ((progressDialog != null) && (progressDialog.getListener() != null)) {
            progressDialog.getListener().onCancelButtonClicked();
            hide();
        }
    }

    @Override
    public void onClick(final ClickEvent event) {
        if ((progressDialog != null) && (progressDialog.getListener() != null)) {
            progressDialog.getListener().onCloseButtonClicked();
            hide();
        }
    }

    @UiHandler("iClose")
    public void onCloseClicked(final ClickEvent event) {
        if ((progressDialog != null) && (progressDialog.getListener() != null)) {
            progressDialog.getListener().onCloseButtonClicked();
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
        if ((progressDialog != null) && (progressDialog.getListener() != null)) {

            if (progressDialog.isCancelButtonVisible()) {

                progressDialog.getListener().onCancelButtonClicked();
                hide();
            }
        }
    }

    protected void onEscapeKeyDown() {
        if ((progressDialog != null) && (progressDialog.getListener() != null)) {
            progressDialog.getListener().onCloseButtonClicked();
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
                ProgressDialogWidget.this.getElement().getStyle().setOpacity(progress);
            }
        };
        fade.run(DEFAULT_FADE_IN);
        pFocusDialog.setFocus(true);
    }
}
