
package com.tinesoft.gwt.dialogs.showcase.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.handler.MessageBoxShowcaseUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.presenter.MessageBoxShowcasePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.resources.ShowcaseResources;

public class MessageBoxShowcasePageView extends ViewWithUiHandlers<MessageBoxShowcaseUiHandlers> implements MessageBoxShowcasePagePresenter.MyView {

    private final Widget widget;

    final ShowcaseResources res;

    @UiField
    FlowPanel infoMessageBox;

    @UiField
    FlowPanel askMessageBox;

    @UiField
    FlowPanel warnMessageBox;

    @UiField
    FlowPanel errorMessageBox;

    public interface Binder extends UiBinder<Widget, MessageBoxShowcasePageView> {
    }

    @Inject
    public MessageBoxShowcasePageView(final Binder binder, final ShowcaseResources resources) {
        widget = binder.createAndBindUi(this);
        res = resources;
        initialize();
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    private void initialize() {
        infoMessageBox.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onInfoMessageBoxClicked();
                }
            }
        }, ClickEvent.getType());

        askMessageBox.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onQuestionMessageBoxClicked();
                }
            }
        }, ClickEvent.getType());

        warnMessageBox.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onWarnMessageBoxClicked();
                }
            }
        }, ClickEvent.getType());

        errorMessageBox.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onErrorMessageBoxClicked();
                }
            }
        }, ClickEvent.getType());
    }
}
