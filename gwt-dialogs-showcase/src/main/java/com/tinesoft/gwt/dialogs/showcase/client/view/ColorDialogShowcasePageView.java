
package com.tinesoft.gwt.dialogs.showcase.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.handler.ColorDialogShowcaseUiHandlers;
import com.tinesoft.gwt.dialogs.showcase.client.presenter.ColorDialogShowcasePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.resources.ShowcaseResources;

/**
 * Color dialog showcase page view.
 * 
 * @author Tine Kondo
 */
public class ColorDialogShowcasePageView extends ViewWithUiHandlers<ColorDialogShowcaseUiHandlers> implements ColorDialogShowcasePagePresenter.MyView {

    public interface Binder extends UiBinder<Widget, ColorDialogShowcasePageView> {
    }

    private final Widget widget;

    @UiField(provided = true)
    final ShowcaseResources res;

    @UiField
    FlowPanel pColor;

    @UiField
    Button pickColorButton;

    @Inject
    public ColorDialogShowcasePageView(final Binder binder, final ShowcaseResources resources) {

        res = resources;
        widget = binder.createAndBindUi(this);
        pColor.getElement().getStyle().setBackgroundColor("#ff0000");

    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    @UiHandler("pickColorButton")
    void onPickColorClicked(final ClickEvent event) {
        if (null != getUiHandlers()) {
            getUiHandlers().onPickColorClicked();
        }
    }

    @Override
    public String getColor() {

        return pColor.getElement().getStyle().getBackgroundColor();
    }

    @Override
    public void setColor(String color) {
        pColor.getElement().getStyle().setBackgroundColor(color);

    }

}
