
package com.tinesoft.gwt.dialogs.showcase.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.handler.MessageDialogShowcaseUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.presenter.MessageDialogShowcasePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.resources.ShowcaseResources;

/**
 * Message dialog showcase page view.
 * 
 * @author Tine Kondo
 */
public class MessageDialogShowcasePageView extends ViewWithUiHandlers<MessageDialogShowcaseUiHandlers> implements MessageDialogShowcasePagePresenter.MyView {

    private final Widget widget;

    @UiField(provided = true)
    final ShowcaseResources res;

    @UiField
    FlowPanel infoMessageDialog;

    @UiField
    FlowPanel askMessageDialog;

    @UiField
    FlowPanel warnMessageDialog;

    @UiField
    FlowPanel errorMessageDialog;

    public interface Binder extends UiBinder<Widget, MessageDialogShowcasePageView> {
    }

    @Inject
    public MessageDialogShowcasePageView(final Binder binder, final ShowcaseResources resources) {
        res = resources;
        widget = binder.createAndBindUi(this);
        initialize();
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    private void initialize() {
        infoMessageDialog.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onInfoMessageDialogClicked();
                }
            }
        }, ClickEvent.getType());

        askMessageDialog.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onQuestionMessageDialogClicked();
                }
            }
        }, ClickEvent.getType());

        warnMessageDialog.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onWarnMessageDialogClicked();
                }
            }
        }, ClickEvent.getType());

        errorMessageDialog.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onErrorMessageDialogClicked();
                }
            }
        }, ClickEvent.getType());
    }
}
