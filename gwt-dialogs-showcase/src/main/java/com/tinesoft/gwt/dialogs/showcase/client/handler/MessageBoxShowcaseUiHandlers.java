
package com.tinesoft.gwt.dialogs.showcase.client.handler;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * MessageDialog Showcase page ui handler.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public interface MessageBoxShowcaseUiHandlers extends UiHandlers {

    /**
     * Fired on 'Info MessageDialog' item click.
     */
    void onInfoMessageBoxClicked();

    /**
     * Fired on 'Question MessageDialog' item click.
     */
    void onQuestionMessageBoxClicked();

    /**
     * Fired on 'Warning MessageDialog' item click.
     */
    void onWarnMessageBoxClicked();

    /**
     * Fired on 'Error MessageDialog' item click.
     */
    void onErrorMessageBoxClicked();
}
