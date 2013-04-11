
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
import com.tinesoft.gwt.dialogs.client.color.core.ColorDialogEventAdapter;
import com.tinesoft.gwt.dialogs.client.color.ui.ColorDialog;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.MainPagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.handler.ColorDialogShowcaseUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.place.NameTokens;

/**
 * Color dialog page presenter.
 * 
 * @author Tine Kondo
 */
public class ColorDialogShowcasePagePresenter extends Presenter<ColorDialogShowcasePagePresenter.MyView, ColorDialogShowcasePagePresenter.MyProxy> implements ColorDialogShowcaseUiHandlers {

    public interface MyView extends View, HasUiHandlers<ColorDialogShowcaseUiHandlers> {

        String getColor();

        void setColor(String color);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.colordialog)
    public interface MyProxy extends ProxyPlace<ColorDialogShowcasePagePresenter> {
    }

    @Inject
    public ColorDialogShowcasePagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
        super(eventBus, view, proxy);
        getView().setUiHandlers(this);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainPagePresenter.TYPE_CONTENT_SLOT, this);
    }

    @Override
    public void onPickColorClicked() {
        ColorDialog.show("", "Pick a color.", getView().getColor(), new ColorDialogEventAdapter() {

            @Override
            public void onOkButtonClicked() {
                ColorDialogShowcasePagePresenter.this.getView().setColor(ColorDialog.getColor());
            }
        });

    }
}
