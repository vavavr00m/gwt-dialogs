
package com.tinesoft.gwt.dialogs.client.resources;

import com.google.gwt.resources.client.CssResource.NotStrict;

import com.tinesoft.gwt.dialogs.client.message.ui.MessageDialog;

/**
 * Client bundle for the {@link MessageDialog} css and image resources.
 * 
 * @author Tine Kondo
 */
public interface ColorDialogResources extends BaseDialogResources {

    interface ColorDialogStyle extends BaseDialogStyle {

        @ClassName("gwtd-color-huePicker")
        String gwtdColorHuePicker();

        @ClassName("gwtd-color-slPicker")
        String gwtdColorSlPicker();

    }

    /**
     * 
     * @return css bundle.
     */
    @Source({ BaseStyle.DEFAULT_CSS, BaseDialogStyle.DEFAULT_CSS, DEFAULT_CSS })
    @NotStrict
    ColorDialogStyle css();

    /**
     * The path to the default CSS styles used by this resource.
     */
    String DEFAULT_CSS = "com/tinesoft/gwt/dialogs/client/resources/ColorDialogStyle.css";

}
