
package com.tinesoft.gwt.dialogs.client.resources;

/**
 * Base CSSResource style for dialog boxes.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public interface BaseDialogStyle extends BaseStyle {

    @ClassName("gwtd-dialog-box")
    String gwtdDialogBox();

    @ClassName("gwtd-dialog-box-bg")
    String gwtdDialogBoxBg();

    @ClassName("gwtd-dialog-box-buttons")
    String gwtdDialogBoxButtons();

    @ClassName("gwtd-dialog-box-content")
    String gwtdDialogBoxContent();

    @ClassName("gwtd-dialog-box-icon")
    String gwtdDialogBoxIcon();

    @ClassName("gwtd-dialog-box-message")
    String gwtdDialogBoxMessage();

    @ClassName("gwtd-dialog-box-title")
    String gwtdDialogBoxTitle();

    @ClassName("gwtd-dialog-box-title-close")
    String gwtdDialogBoxTitleClose();

    @ClassName("gwtd-dialog-box-title-draggable")
    String gwtdDialogBoxTitleDraggable();

    @ClassName("gwtd-dialog-box-title-text")
    String gwtdDialogBoxTitleText();

}
