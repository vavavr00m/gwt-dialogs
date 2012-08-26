
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
public interface ColorDialogResources extends ClientBundle {

    interface ColorDialogStyle extends BaseDialogStyle {

        @ClassName("gwtd-color-huePicker")
        String gwtdColorHuePicker();

        @ClassName("gwtd-color-slPicker")
        String gwtdColorSlPicker();

    }

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
     * 
     * @return css bundle.
     */
    @Source({ "BaseStyle.css", "BaseDialogStyle.css", "ColorDialogStyle.css" })
    @NotStrict
    ColorDialogStyle css();

}
