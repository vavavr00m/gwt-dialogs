
package com.tinesoft.gwt.dialogs.client.menu.ui;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;
import com.tinesoft.gwt.dialogs.client.menu.core.ContextMenuDialogTriggerMode;
import com.tinesoft.gwt.dialogs.client.menu.core.MenuItemClickEvent;
import com.tinesoft.gwt.dialogs.client.menu.core.MenuItemClickHandler;
import com.tinesoft.gwt.dialogs.client.resources.ContextMenuDialogResources;
import com.tinesoft.gwt.dialogs.client.util.ContextMenuDialogUtils;

public class ContextMenuDialogWidget extends Composite implements MenuItemClickHandler {

    interface ContextMenuDialogWidgetUiBinder extends UiBinder<Widget, ContextMenuDialogWidget> {
    }

    private static ContextMenuDialogWidgetUiBinder uiBinder = GWT.create(ContextMenuDialogWidgetUiBinder.class);

    private static final int DEFAULT_FADE_OUT = 500;

    private static final int DEFAULT_FADE_IN = 500;

    @UiField
    ContextMenuDialogResources resources;

    @UiField
    FocusPanel pFocusMenuContainer;

    @UiField
    FlowPanel pMenuContainer;

    @UiField
    FlowPanel pTarget;

    @UiField
    FlowPanel pArrow;

    @UiField
    FlowPanel pArrowBg;

    @UiField
    FlowPanel pMenu;

    public ContextMenuDialogWidget(/* final ContextMenuDialogResources resources */) {
        // // as 'resources' is annotated with @UiField(provided = true), then
        // // it must be instantiated before calling 'uiBinder.createAndBindUi(this)'
        // this.resources = resources;
        initWidget(uiBinder.createAndBindUi(this));

        initialize();
    }

    /**
     * Adds a new menu item to this context menu dialog.
     * 
     * @param item the {@link MenuItemWidget} to add.
     */
    @UiChild
    public void addMenuItem(final MenuItemWidget item) {
        // when the menu dialog to the menu item click event
        item.addMenuItemClickedHandler(this);
        pMenu.add(item);
    }

    /**
     * Adds a new separator item to this context menu dialog.
     * 
     */
    @UiChild(limit = 0)
    public void addSeparator(final Widget w) {
        final FlowPanel separator = new FlowPanel();
        separator.setStyleName(resources.css().gwtdMenuSeparator());
        pMenu.add(separator);
    }

    /**
     * Adds the target widget of this context menu dialog.
     * <p>
     * Only one target is allowed at any time.
     * </p>
     * 
     * @param target the target widget.
     */
    @UiChild(limit = 1)
    public void addTarget(final Widget target) {
        pTarget.clear();
        pTarget.add(target);
    }

    public void hide() {

        final Element menuElement = pFocusMenuContainer.getElement();

        final int left = pTarget.getAbsoluteLeft();

        menuElement.getStyle().setLeft(left, Unit.PX);

        final Animation fade = new Animation() {

            @Override
            protected void onComplete() {
                super.onComplete();
                pMenuContainer.setVisible(false);
                menuElement.getStyle().setLeft(left - 40, Unit.PX);
            }

            @Override
            protected void onUpdate(final double progress) {
                menuElement.getStyle().setOpacity(1 - progress);
                menuElement.getStyle().setLeft(left - 40 * progress, Unit.PX);
            }
        };
        fade.run(DEFAULT_FADE_OUT);
        pFocusMenuContainer.setFocus(false);

    }

    private void initialize() {
        initMenuDialogStyle();
        // we initially hide the context menu dialog
        hide();
    }

    private void initMenuDialogStyle() {

        final int targetRight = pTarget.getElement().getAbsoluteRight();
        final int targetBottom = pTarget.getElement().getAbsoluteBottom();
        final int targetLeft = pTarget.getElement().getAbsoluteLeft();

        final int menuWidth = pMenu.getElement().getClientWidth();
        final int menuHeight = pMenu.getElement().getClientHeight();

        // we remove previous style
        pMenu.removeStyleName(resources.css().gwtdMenuOnTop());
        pMenu.removeStyleName(resources.css().gwtdMenuOnRight());
        pMenu.removeStyleName(resources.css().gwtdMenuOnBottom());
        pMenu.removeStyleName(resources.css().gwtdMenuOnLeft());

        // we add the menu dialog at the appropriate position to the target
        if ((targetRight + menuWidth) <= Window.getClientWidth()) {
            pMenu.addStyleName(resources.css().gwtdMenuOnRight());
        } else if ((targetLeft - menuWidth) >= 0) {
            pMenu.addStyleName(resources.css().gwtdMenuOnLeft());
        } else if ((targetBottom + menuHeight) <= Window.getClientHeight()) {
            pMenu.addStyleName(resources.css().gwtdMenuOnBottom());
        } else {
            pMenu.addStyleName(resources.css().gwtdMenuOnTop());
        }
    }

    @UiHandler("pFocusMenuContainer")
    void onMenuBlurred(final BlurEvent event) {
        // we hide the context menu dialog if it looses focus
        hide();
    }

    /**
     * Sets which event on the target, triggers the display of the context menu dialog
     * <p>
     * Possible values are : "onRightClick", "onLeftClick", or "onMouseOver".
     * </p>
     * 
     * @param triggerMode the trigger mode as string.
     */
    public void setTriggerMode(final String triggerMode) {

        final ContextMenuDialogTriggerMode mode = ContextMenuDialogUtils.resolveTriggerMode(triggerMode);

        switch (mode) {
            case OnLeftClick:
                pTarget.addDomHandler(new MouseDownHandler() {

                    @Override
                    public void onMouseDown(final MouseDownEvent event) {
                        if (event.getNativeButton() == NativeEvent.BUTTON_LEFT) {
                            show();
                        }
                    }
                }, MouseDownEvent.getType());

                break;
            case OnMouseOver:
                pTarget.addDomHandler(new MouseOverHandler() {

                    @Override
                    public void onMouseOver(final MouseOverEvent event) {
                        show();
                    }
                }, MouseOverEvent.getType());

                break;
        }
    }

    public void show() {

        final Element menuElement = pFocusMenuContainer.getElement();

        final int left = pTarget.getAbsoluteLeft();

        menuElement.getStyle().setLeft(left - 40, Unit.PX);

        pMenuContainer.setVisible(true);
        final Animation fade = new Animation() {

            @Override
            protected void onUpdate(final double progress) {
                menuElement.getStyle().setOpacity(progress);
                menuElement.getStyle().setLeft(left - 40 * (1 - progress), Unit.PX);
            }
        };
        fade.run(DEFAULT_FADE_IN);
        pFocusMenuContainer.setFocus(true);
    }

    @Override
    public void onMenuItemClicked(MenuItemClickEvent event) {
        // we hide the menu when one item has been clicked
        hide();

    }
}
