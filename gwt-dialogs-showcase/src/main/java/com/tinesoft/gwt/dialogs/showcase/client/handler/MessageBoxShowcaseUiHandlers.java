
package com.tinesoft.gwt.dialogs.showcase.client.handler;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * MessageBox Showcase page ui handler.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public interface MessageBoxShowcaseUiHandlers extends UiHandlers {

    /**
     * Fired on 'Info MessageBox' item click.
     */
    void onInfoMessageBoxClicked();

    /**
     * Fired on 'Question MessageBox' item click.
     */
    void onQuestionMessageBoxClicked();

    /**
     * Fired on 'Warning MessageBox' item click.
     */
    void onWarnMessageBoxClicked();

    /**
     * Fired on 'Error MessageBox' item click.
     */
    void onErrorMessageBoxClicked();
}
