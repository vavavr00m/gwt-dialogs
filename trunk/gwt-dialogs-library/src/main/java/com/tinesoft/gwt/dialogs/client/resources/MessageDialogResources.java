
package com.tinesoft.gwt.dialogs.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
import com.tinesoft.gwt.dialogs.client.message.ui.MessageDialog;

/**
 * Client bundle for the {@link MessageDialog} css and image resources.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public interface MessageDialogResources extends ClientBundle {

    interface MessageDialogStyle extends BaseDialogStyle {

    }

    /**
     * 
     * @return question image bundle.
     */
    @Source("images/ask.png")
    ImageResource askIcon();

    /**
     * 
     * @return background image bundle for dialog box.
     */
    @Source("images/background.png")
    ImageResource backgroundImage();

    /**
     * 
     * @return close image bundle.
     */
    @Source("images/close-x.png")
    ImageResource closeIcon();

    /**
     * @return css bundle.
     */
    @Source({ "BaseStyle.css", "BaseDialogStyle.css", "MessageDialogStyle.css" })
    @NotStrict
    MessageDialogStyle css();

    /**
     * 
     * @return error image bundle.
     */
    @Source("images/error.png")
    ImageResource errorIcon();

    /**
     * 
     * @return information image bundle.
     */
    @Source("images/info.png")
    ImageResource infoIcon();

    /**
     * 
     * @return warning image bundle.
     */
    @Source("images/warn.png")
    ImageResource warnIcon();

}
