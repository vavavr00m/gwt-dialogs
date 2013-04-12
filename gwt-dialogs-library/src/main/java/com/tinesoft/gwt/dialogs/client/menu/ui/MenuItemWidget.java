
package com.tinesoft.gwt.dialogs.client.menu.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import com.tinesoft.gwt.dialogs.client.menu.core.MenuItemClickEvent;
import com.tinesoft.gwt.dialogs.client.menu.core.MenuItemClickHandler;

/**
 * A widget that represents a menu item.
 * 
 * @author Tine Kondo
 */
class MenuItemWidget extends Composite {

    private static MenuItemWidgetUiBinder uiBinder = GWT.create(MenuItemWidgetUiBinder.class);

    @UiField
    FlowPanel pMenuItem;

    @UiField
    FlowPanel pIcon;

    @UiField
    FlowPanel pText;

    interface MenuItemWidgetUiBinder extends UiBinder<Widget, MenuItemWidget> {
    }

    public MenuItemWidget() {
        initWidget(uiBinder.createAndBindUi(this));
        initialize();
    }

    private void initialize() {
        // we fire the MenuItemClickEvent when the menu item panel is clicked
        pMenuItem.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                fireEvent(new MenuItemClickEvent());

            }
        }, ClickEvent.getType());
    }

    /**
     * Sets the icon associated to this menu item.
     * 
     * @param iconURL the URL to the icon of the menu item.
     */
    public void setIcon(ImageResource iconURL) {
        pIcon.clear();
        pIcon.add(new Image(iconURL));
    }

    /**
     * Sets the text associated to this menu item.
     * 
     * @param text the text of the menu item.
     */
    public void setText(String text) {
        pText.clear();
        pText.add(new Label(text));
    }

    /**
     * Adds a {@link MenuItemClickHandler} to this menu item.
     * 
     * @param handler the handler
     * @return {@link HandlerRegistration} used to remove the handler
     */
    public HandlerRegistration addMenuItemClickedHandler(MenuItemClickHandler handler) {
        return addHandler(handler, MenuItemClickEvent.getType());
    }
}
