
package com.tinesoft.gwt.dialogs.showcase.client.core.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.core.handler.ErrorPageUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.ErrorPagePresenter;

/**
 * Error view.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: ErrorPageView.java 2943 2011-07-11 08:28:16Z kondotine $
 */
public class ErrorPageView extends ViewWithUiHandlers<ErrorPageUiHandlers> implements ErrorPagePresenter.MyView {

    /**
     * {@link UiBinder} for {@link ErrorPageView}.
     */
    public interface MyUiBinder extends UiBinder<Widget, ErrorPageView> {
    }

    private final Widget widget;

    @UiField
    Button retry;

    /**
     * Constructor.
     * 
     * @param ui the {@link UiBinder}.
     */
    @Inject
    public ErrorPageView(final MyUiBinder ui) {
        widget = ui.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    @UiHandler("retry")
    void onReTryClick(final ClickEvent event) {
        if (null != getUiHandlers()) {
            getUiHandlers().onReTryClicked();
        }
    }
}
