
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
import com.tinesoft.gwt.dialogs.client.message.ui.MessageDialog;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.MainPagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.handler.MessageBoxShowcaseUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.place.NameTokens;

public class MessageBoxShowcasePagePresenter extends Presenter<MessageBoxShowcasePagePresenter.MyView, MessageBoxShowcasePagePresenter.MyProxy> implements MessageBoxShowcaseUiHandlers {

    private final static String LOREM_IPSUM = "Lorem ipsum dolor sit amet, <b>consectetur adipiscing elit</b>. Curabitur lobortis laoreet tristique."
                                              + "In nec metus vitae mi pellentesque tincidunt. <i>Aenean id metus</i> at lectus lacinia viverra. Ut ullamcorper congue vehicula. Fusce "
                                              + "<u>adipiscing sagittis enim</u>, nec molestie nulla fringilla quis. Ut pharetra lacinia libero eu egestas. Cras augue diam, varius et "
                                              + "tincidunt tincidunt, placerat vel velit.";

    public interface MyView extends View, HasUiHandlers<MessageBoxShowcaseUiHandlers> {
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.messagebox)
    public interface MyProxy extends ProxyPlace<MessageBoxShowcasePagePresenter> {
    }

    @Inject
    public MessageBoxShowcasePagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
        super(eventBus, view, proxy);
        getView().setUiHandlers(this);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, MainPagePresenter.TYPE_CONTENT_SLOT, this);
    }

    @Override
    public void onInfoMessageBoxClicked() {
        MessageDialog.inform("Information", LOREM_IPSUM);
    }

    @Override
    public void onQuestionMessageBoxClicked() {
        MessageDialog.ask("Question", LOREM_IPSUM);

    }

    @Override
    public void onWarnMessageBoxClicked() {
        MessageDialog.warn("Warning", LOREM_IPSUM);

    }

    @Override
    public void onErrorMessageBoxClicked() {
        MessageDialog.error("Error", LOREM_IPSUM);

    }
}
