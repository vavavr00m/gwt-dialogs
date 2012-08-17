
package com.tinesoft.gwt.dialogs.showcase.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * Client bundle for the application css and image resources.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: MessageBoxResources.java 2722 2011-06-28 10:41:06Z kondotine $
 */
public interface ShowcaseResources extends ClientBundle {

    interface Style extends CssResource {

        String left();

        String right();

        String title();

        String clear();

        String content();

        String container();

        String button();

        String selectedButton();

        String inline();

        String middle();
    }

    /**
     * @return css bundle.
     */
    @Source({ "Style.css" })
    Style css();

    /**
     * 
     * @return information image bundle
     */
    @Source("images/info.png")
    ImageResource infoIcon();

    /**
     * 
     * @return error image bundle
     */
    @Source("images/error.png")
    ImageResource errorIcon();

    /**
     * 
     * @return warning image bundle
     */
    @Source("images/warn.png")
    ImageResource warnIcon();

    /**
     * 
     * @return question image bundle
     */
    @Source("images/ask.png")
    ImageResource askIcon();

    /**
     * 
     * @return info-question-warning-error image bundle
     */
    @Source("images/messageboxes.png")
    ImageResource messageboxesIcon();

    /**
     * 
     * @return color dialog image bundle
     */
    @Source("images/colordialog.png")
    ImageResource colorDialogIcon();
}
