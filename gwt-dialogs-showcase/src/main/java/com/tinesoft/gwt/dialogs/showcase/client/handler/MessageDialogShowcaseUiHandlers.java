
package com.tinesoft.gwt.dialogs.showcase.client.handler;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * MessageDialog Showcase page ui handler.
 * 
 * @author Tine Kondo
 */
public interface MessageDialogShowcaseUiHandlers extends UiHandlers {

    /**
     * Fired on 'Info MessageDialog' item click.
     */
    void onInfoMessageDialogClicked();

    /**
     * Fired on 'Question MessageDialog' item click.
     */
    void onQuestionMessageDialogClicked();

    /**
     * Fired on 'Warning MessageDialog' item click.
     */
    void onWarnMessageDialogClicked();

    /**
     * Fired on 'Error MessageDialog' item click.
     */
    void onErrorMessageDialogClicked();
}
