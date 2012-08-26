
package com.tinesoft.gwt.dialogs.showcase.client.core.presenter;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.tinesoft.gwt.dialogs.showcase.client.core.handler.HomePageUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.place.NameTokens;

/**
 * Home page presenter.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> implements HomePageUiHandlers {

    private final PlaceManager placeManager;

    public interface MyView extends View, HasUiHandlers<HomePageUiHandlers> {
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    public interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    @Inject
    public HomePagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy, final PlaceManager placeManager) {
        super(eventBus, view, proxy);
        getView().setUiHandlers(this);
        this.placeManager = placeManager;
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainPagePresenter.TYPE_CONTENT_SLOT, this);
    }

    @Override
    public void onMessageBoxShowcaseClicked() {
        placeManager.revealPlace(new PlaceRequest(NameTokens.messagebox));

    }

    @Override
    public void onColorDialogShowcaseClicked() {
        placeManager.revealPlace(new PlaceRequest(NameTokens.colordialog));

    }

    @Override
    public void onContextMenuDialogShowcaseClicked() {
        placeManager.revealPlace(new PlaceRequest(NameTokens.menudialog));

    }
}
