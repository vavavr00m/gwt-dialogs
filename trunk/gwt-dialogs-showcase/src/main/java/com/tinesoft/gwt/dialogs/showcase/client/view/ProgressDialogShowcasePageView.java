
package com.tinesoft.gwt.dialogs.showcase.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import com.tinesoft.gwt.dialogs.showcase.client.handler.ProgressDialogShowcaseUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.presenter.ProgressDialogShowcasePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.resources.ShowcaseResources;

public class ProgressDialogShowcasePageView extends ViewWithUiHandlers<ProgressDialogShowcaseUiHandlers> implements ProgressDialogShowcasePagePresenter.MyView {

    private final Widget widget;

    @UiField(provided = true)
    final ShowcaseResources res;

    @UiField
    Button showDialogButton;

    public interface Binder extends UiBinder<Widget, ProgressDialogShowcasePageView> {
    }

    @Inject
    public ProgressDialogShowcasePageView(final Binder binder, final ShowcaseResources resources) {
        res = resources;
        widget = binder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    @UiHandler("showDialogButton")
    void onShowDialogClicked(final ClickEvent event) {
        if (null != getUiHandlers()) {
            getUiHandlers().onShowDialogClicked();
        }
    }
}
