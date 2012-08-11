
package com.tinesoft.gwt.dialogs.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
import com.tinesoft.gwt.dialogs.client.MessageBox;

/**
 * Client bundle for the {@link MessageBox} css and image resources.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: MessageBoxResources.java 2722 2011-06-28 10:41:06Z kondotine $
 */
public interface MessageBoxResources extends ClientBundle {

    interface MessageBoxStyle extends CssResource {

        String clear();

        @ClassName("gwtd-message-box")
        String gwtdMessageBox();

        @ClassName("gwtd-message-box-bg")
        String gwtdMessageBoxBg();

        @ClassName("gwtd-message-box-buttons")
        String gwtdMessageBoxButtons();

        @ClassName("gwtd-message-box-content")
        String gwtdMessageBoxContent();

        @ClassName("gwtd-message-box-icon")
        String gwtdMessageBoxIcon();

        @ClassName("gwtd-message-box-message")
        String gwtdMessageBoxMessage();

        @ClassName("gwtd-message-box-title")
        String gwtdMessageBoxTitle();

        @ClassName("gwtd-message-box-title-close")
        String gwtdMessageBoxTitleClose();

        @ClassName("gwtd-message-box-title-draggable")
        String gwtdMessageBoxTitleDraggable();

        @ClassName("gwtd-message-box-title-text")
        String gwtdMessageBoxTitleText();

        String left();

        String notSelectable();

        String right();

        String selectedButton();

        String stripe();
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
    @Source({ "MessageBoxStyle.css" })
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
