
package com.tinesoft.gwt.dialogs.showcase.client.core.handler;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Showcase page handler.
 * 
 * @author Tine Kondo
 */
public interface HomePageUiHandlers extends UiHandlers {

    /**
     * Fired on 'MessageDialog' showcase click.
     */
    void onMessageBoxShowcaseClicked();

    /**
     * Fired on 'ColorDialog' showcase click.
     */
    void onColorDialogShowcaseClicked();

    /**
     * Fired on 'ContextMenuDialog' showcase click.
     */
    void onContextMenuDialogShowcaseClicked();

    /**
     * Fired on 'ProgressDialog' showcase click.
     */
    void onProgressDialogShowcaseClicked();

}
