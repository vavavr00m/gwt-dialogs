
package com.tinesoft.gwt.dialogs.client.resources;

import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;

import com.tinesoft.gwt.dialogs.client.progress.ui.ProgressDialog;

/**
 * Client bundle for the {@link ProgressDialog} css and image resources.
 * 
 * @author Tine Kondo
 */
public interface ProgressDialogResources extends BaseDialogResources {

    interface ProgressDialogStyle extends BaseDialogStyle {

        @ClassName("gwtd-progress-bar")
        String gwtdProgressBar();
    }

    /**
     * 
     * @return the progress animated image.
     */
    @Source("images/progress.gif")
    ImageResource progressIcon();

    /**
     * @return css bundle.
     */
    @Source({ "BaseStyle.css", "BaseDialogStyle.css", "ProgressDialogStyle.css" })
    @NotStrict
    ProgressDialogStyle css();

    /**
     * The path to the default CSS styles used by this resource.
     */
    String DEFAULT_CSS = "com/tinesoft/gwt/dialogs/client/resources/ProgressDialogStyle.css";
}
