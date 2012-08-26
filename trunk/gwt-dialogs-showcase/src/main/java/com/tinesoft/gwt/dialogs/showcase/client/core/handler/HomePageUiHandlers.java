
package com.tinesoft.gwt.dialogs.showcase.client.core.handler;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Showcase page handler.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: HomePageUiHandlers.java 2509 2011-06-14 08:33:50Z kondotine $
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

}
