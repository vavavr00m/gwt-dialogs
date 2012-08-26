
package com.tinesoft.gwt.dialogs.showcase.client.presenter;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.MainPagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.place.NameTokens;

/**
 * Context menu dialog page presenter.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class ContextMenuDialogShowcasePagePresenter extends Presenter<ContextMenuDialogShowcasePagePresenter.MyView, ContextMenuDialogShowcasePagePresenter.MyProxy> {

    public interface MyView extends View {
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.menudialog)
    public interface MyProxy extends ProxyPlace<ContextMenuDialogShowcasePagePresenter> {
    }

    @Inject
    public ContextMenuDialogShowcasePagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainPagePresenter.TYPE_CONTENT_SLOT, this);
    }
}
