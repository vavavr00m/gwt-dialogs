
package com.tinesoft.gwt.dialogs.showcase.client.view;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.tinesoft.gwt.dialogs.showcase.client.presenter.ContextMenuDialogShowcasePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.resources.ShowcaseResources;

public class ContextMenuDialogShowcasePageView extends ViewImpl implements ContextMenuDialogShowcasePagePresenter.MyView {

    private final Widget widget;

    @UiField(provided = true)
    final ShowcaseResources res;

    public interface Binder extends UiBinder<Widget, ContextMenuDialogShowcasePageView> {
    }

    @Inject
    public ContextMenuDialogShowcasePageView(final Binder binder, final ShowcaseResources resources) {
        res = resources;
        widget = binder.createAndBindUi(this);

    }

    @Override
    public Widget asWidget() {
        return widget;
    }
}
