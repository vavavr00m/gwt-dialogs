
package com.tinesoft.gwt.dialogs.showcase.client.presenter;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.tinesoft.gwt.dialogs.client.progress.core.ProgressDialogEventAdapter;
import com.tinesoft.gwt.dialogs.client.progress.ui.ProgressDialog;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.MainPagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.handler.ProgressDialogShowcaseUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.place.NameTokens;

public class ProgressDialogShowcasePagePresenter extends Presenter<ProgressDialogShowcasePagePresenter.MyView, ProgressDialogShowcasePagePresenter.MyProxy> implements ProgressDialogShowcaseUiHandlers {

    public interface MyView extends View, HasUiHandlers<ProgressDialogShowcaseUiHandlers> {
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.progressdialog)
    public interface MyProxy extends ProxyPlace<ProgressDialogShowcasePagePresenter> {
    }

    @Inject
    public ProgressDialogShowcasePagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
        super(eventBus, view, proxy);
        getView().setUiHandlers(this);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainPagePresenter.TYPE_CONTENT_SLOT, this);
    }

    @Override
    protected void onBind() {
        super.onBind();
    }

    @Override
    public void onShowDialogClicked() {
        ProgressDialog.show("", "Please wait while performing the operation....", true,
                            new ProgressDialogEventAdapter() {

                                @Override
                                public void onCancelButtonClicked() {

                                }
                            });
    }
}
