
package com.tinesoft.gwt.dialogs.showcase.client.core.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.core.handler.HomePageUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.HomePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.resources.ShowcaseResources;

/**
 * Home page view.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public class HomePageView extends ViewWithUiHandlers<HomePageUiHandlers> implements HomePagePresenter.MyView {

    private final Widget widget;

    final ShowcaseResources res;

    @UiField
    FlowPanel messageBoxShowcase;

    @UiField
    FlowPanel colorDialogShowcase;

    @UiField
    FlowPanel menuDialogShowcase;

    @UiField
    FlowPanel progressDialogShowcase;

    public interface Binder extends UiBinder<Widget, HomePageView> {
    }

    @Inject
    public HomePageView(final Binder binder, final ShowcaseResources resources) {
        widget = binder.createAndBindUi(this);
        res = resources;
        initialize();
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    private void initialize() {
        messageBoxShowcase.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onMessageBoxShowcaseClicked();
                }
            }
        }, ClickEvent.getType());

        colorDialogShowcase.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onColorDialogShowcaseClicked();
                }
            }
        }, ClickEvent.getType());

        menuDialogShowcase.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onContextMenuDialogShowcaseClicked();
                }
            }
        }, ClickEvent.getType());

        progressDialogShowcase.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if (null != getUiHandlers()) {
                    getUiHandlers().onProgressDialogShowcaseClicked();
                }
            }
        }, ClickEvent.getType());

    }

}
