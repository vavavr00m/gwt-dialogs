
package com.tinesoft.gwt.dialogs.client.message.ui;

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
import com.tinesoft.gwt.dialogs.client.resources.MessageDialogResources;

public class MessageDialogWidget extends Composite implements ClickHandler {

    interface MessageBoxWidgetUiBinder extends UiBinder<Widget, MessageDialogWidget> {
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
    Image icon;

    @UiField
    HTML hMessage;

    @UiField
    FlowPanel pButtons;

    @UiField
    Button okButton;

    @UiField
    Button cancelButton;

    @UiField
    Button abortButton;

    @UiField
    Button retryButton;

    @UiField
    Button ignoreButton;

    @UiField
    Button yesButton;

    @UiField
    Button noButton;

    final MessageDialogResources resources;

    private final MessageDialog messageDialog;

    private final MessageBoxWidgetUiBinder uiBinder = GWT.create(MessageBoxWidgetUiBinder.class);

    // // helpers for adding drag & drop support on the dialog box
    // private PickupDragController dragController;
    // private DropController dropController;

    public MessageDialogWidget(final MessageDialog messageDialog, final MessageDialogResources resources) {
        // as 'resources' is annotated with @UiField(provided = true), then
        // it must be instantiated before calling 'uiBinder.createAndBindUi(this)'
        this.resources = resources;
        initWidget(uiBinder.createAndBindUi(this));
        this.messageDialog = messageDialog;

        initialize();
    }

    /**
     * @return the messageDialog
     */
    public MessageDialog getMessageBox() {
        return messageDialog;
    }

    @UiFactory
    public MessageDialogResources getResources() {
        return resources;
    }

    public void hide() {

        final Animation fade = new Animation() {

            @Override
            protected void onComplete() {
                super.onComplete();
                MessageDialogWidget.this.setVisible(false);
                MessageDialogWidget.this.removeFromParent();
            }

            @Override
            protected void onUpdate(final double progress) {
                MessageDialogWidget.this.getElement().getStyle().setOpacity(1 - progress);
            }
        };
        fade.run(DEFAULT_FADE_OUT);
        pFocusDialog.setFocus(false);
    }

    /**
     * Initializes the buttons that must be displayed on the {@link MessageDialog}, according to its
     * type.
     */
    private void initDisplayedButtons() {

        if (messageDialog != null) {

            // we first hide all the buttons
            okButton.setVisible(false);
            cancelButton.setVisible(false);
            abortButton.setVisible(false);
            retryButton.setVisible(false);
            ignoreButton.setVisible(false);
            yesButton.setVisible(false);
            noButton.setVisible(false);

            switch (messageDialog.getButtons()) {
                case OKCancel:
                    okButton.setVisible(true);
                    cancelButton.setVisible(true);

                    // we set the default selected button
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            okButton.addStyleName(resources.css().selectedButton());
                            okButton.setFocus(true);
                            break;
                        case Button2:
                            cancelButton.addStyleName(resources.css().selectedButton());
                            cancelButton.setFocus(true);
                            break;
                    }
                    break;
                case AbortRetryIgnore:
                    abortButton.setVisible(true);
                    retryButton.setVisible(true);
                    ignoreButton.setVisible(true);

                    // we set the default selected button
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            abortButton.addStyleName(resources.css().selectedButton());
                            abortButton.setFocus(true);
                            break;
                        case Button2:
                            retryButton.addStyleName(resources.css().selectedButton());
                            retryButton.setFocus(true);
                            break;
                        case Button3:
                            ignoreButton.addStyleName(resources.css().selectedButton());
                            ignoreButton.setFocus(true);
                            break;
                    }
                    break;
                case RetryCancel:
                    retryButton.setVisible(true);
                    cancelButton.setVisible(true);

                    // we set the default selected button
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            retryButton.addStyleName(resources.css().selectedButton());
                            retryButton.setFocus(true);
                            break;
                        case Button2:
                            cancelButton.addStyleName(resources.css().selectedButton());
                            cancelButton.setFocus(true);
                            break;
                    }
                    break;
                case YesNo:
                    yesButton.setVisible(true);
                    noButton.setVisible(true);

                    // we set the default selected button
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            yesButton.addStyleName(resources.css().selectedButton());
                            yesButton.setFocus(true);
                            break;
                        case Button2:
                            noButton.addStyleName(resources.css().selectedButton());
                            noButton.setFocus(true);
                            break;
                    }
                    break;
                case YesNoCancel:
                    yesButton.setVisible(true);
                    noButton.setVisible(true);
                    cancelButton.setVisible(true);

                    // we set the default selected button
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            yesButton.addStyleName(resources.css().selectedButton());
                            yesButton.setFocus(true);
                            break;
                        case Button2:
                            noButton.addStyleName(resources.css().selectedButton());
                            noButton.setFocus(true);
                            break;
                        case Button3:
                            cancelButton.addStyleName(resources.css().selectedButton());
                            cancelButton.setFocus(true);
                            break;
                    }
                    break;
                default:
                    okButton.setVisible(true);

                    // we set the default selected button
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            okButton.addStyleName(resources.css().selectedButton());
                            okButton.setFocus(true);
                            break;
                    }
                    break;
            }
        }

    }

    /**
     * Sets the title and the message that must be displayed on the {@link MessageDialog}, according to
     * its type.
     */
    private void initDisplayedContent() {
        if (messageDialog != null) {

            hTitle.setHTML(messageDialog.getTitle());
            hMessage.setHTML(messageDialog.getMessage());
        }

    }

    /**
     * Sets the icon that must be displayed on the {@link MessageDialog}, according to its type.
     */
    private void initDisplayedIcon() {
        if (messageDialog != null) {
            switch (messageDialog.getIcon()) {
                case Information:
                    icon.setResource(resources.infoIcon());
                    break;
                case Question:
                    icon.setResource(resources.askIcon());
                    break;
                case Warning:
                    icon.setResource(resources.warnIcon());
                    break;
                case Error:
                    icon.setResource(resources.errorIcon());
                    break;
                default:
                    icon.removeFromParent();
            }
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

        initDisplayedIcon();

        initDisplayedContent();

        initDisplayedButtons();

        initDragAndDrop();

    }

    @UiHandler("abortButton")
    void onAbortButtonClicked(final ClickEvent event) {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onAbortButtonClicked();
            hide();
        }
    }

    @UiHandler("cancelButton")
    void onCancelButtonClicked(final ClickEvent event) {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onCancelButtonClicked();
            hide();
        }
    }

    @Override
    public void onClick(final ClickEvent event) {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onCloseButtonClicked();
            hide();
        }
    }

    @UiHandler("iClose")
    public void onCloseClicked(final ClickEvent event) {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onCloseButtonClicked();
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
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {

            switch (messageDialog.getButtons()) {
                case OKCancel:
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            messageDialog.getListener().onOkButtonClicked();
                            hide();
                            break;
                        case Button2:
                            messageDialog.getListener().onCancelButtonClicked();
                            hide();
                            break;
                    }
                    break;
                case AbortRetryIgnore:
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            messageDialog.getListener().onAbortButtonClicked();
                            hide();
                            break;
                        case Button2:
                            messageDialog.getListener().onRetryButtonClicked();
                            hide();
                            break;
                        case Button3:
                            messageDialog.getListener().onIgnoreButtonClicked();
                            hide();
                            break;
                    }
                    break;
                case RetryCancel:
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            messageDialog.getListener().onRetryButtonClicked();
                            hide();
                            break;
                        case Button2:
                            messageDialog.getListener().onCancelButtonClicked();
                            hide();
                            break;
                    }
                    break;
                case YesNo:
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            messageDialog.getListener().onYesButtonClicked();
                            hide();
                            break;
                        case Button2:
                            messageDialog.getListener().onNoButtonClicked();
                            hide();
                            break;
                    }
                    break;
                case YesNoCancel:
                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            messageDialog.getListener().onYesButtonClicked();
                            hide();
                            break;
                        case Button2:
                            messageDialog.getListener().onNoButtonClicked();
                            hide();
                            break;
                        case Button3:
                            messageDialog.getListener().onCancelButtonClicked();
                            hide();
                            break;
                    }
                    break;
                default:

                    switch (messageDialog.getDefaultButton()) {
                        case Button1:
                            messageDialog.getListener().onOkButtonClicked();
                            hide();
                            break;
                    }
                    break;
            }
        }
    }

    protected void onEscapeKeyDown() {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onCloseButtonClicked();
            hide();
        }
    }

    @UiHandler("ignoreButton")
    void onIgnoreButtonClicked(final ClickEvent event) {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onIgnoreButtonClicked();
            hide();
        }
    }

    @UiHandler("noButton")
    void onNoButtonClicked(final ClickEvent event) {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onNoButtonClicked();
            hide();
        }
    }

    @UiHandler("okButton")
    void onOkButtonClicked(final ClickEvent event) {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onOkButtonClicked();
            hide();
        }
    }

    @UiHandler("retryButton")
    void onRetryButtonClicked(final ClickEvent event) {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onRetryButtonClicked();
            hide();
        }
    }

    @UiHandler("yesButton")
    void onYesButtonClicked(final ClickEvent event) {
        if ((messageDialog != null) && (messageDialog.getListener() != null)) {
            messageDialog.getListener().onYesButtonClicked();
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
                MessageDialogWidget.this.getElement().getStyle().setOpacity(progress);
            }
        };
        fade.run(DEFAULT_FADE_IN);
        pFocusDialog.setFocus(true);
    }
}
