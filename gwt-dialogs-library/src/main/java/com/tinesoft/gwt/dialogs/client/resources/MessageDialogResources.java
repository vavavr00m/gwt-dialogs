
package com.tinesoft.gwt.dialogs.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
import com.tinesoft.gwt.dialogs.client.message.ui.MessageDialog;

/**
 * Client bundle for the {@link MessageDialog} css and image resources.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: MessageDialogResources.java 2722 2011-06-28 10:41:06Z kondotine $
 */
public interface MessageDialogResources extends ClientBundle {

    interface MessageBoxStyle extends BaseDialogStyle {

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
    MessageBoxStyle css();

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
