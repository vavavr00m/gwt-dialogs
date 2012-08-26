
package com.tinesoft.gwt.dialogs.client.util;

import com.tinesoft.gwt.dialogs.client.menu.core.ContextMenuDialogTriggerMode;
import com.tinesoft.gwt.dialogs.client.menu.ui.ContextMenuDialogWidget;

/**
 * Utility class for the {@link ContextMenuDialogWidget}.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public final class ContextMenuDialogUtils {

    /**
     * Utility class. No public constructor.
     */
    private ContextMenuDialogUtils() {

    }

    /**
     * Resolves the trigger mode of the context menu dialog.
     * <p>
     * Possible values are : "onLeftClick", or "onMouseOver".
     * </p>
     * 
     * @param triggerMode the trigger mode as string.
     * @return the corresponding {@link ContextMenuDialogTriggerMode}.
     */
    public static ContextMenuDialogTriggerMode resolveTriggerMode(String triggerMode) {

        if ("onLeftClick".equals(triggerMode)) {
            return ContextMenuDialogTriggerMode.OnLeftClick;
        }
        if ("onMouseOver".equals(triggerMode)) {
            return ContextMenuDialogTriggerMode.OnMouseOver;
        }

        throw new IllegalArgumentException(
                "triggerMode '" + triggerMode
                        + "' is not supported. Possible values are 'onLeftClick', 'onMouseOver'.");

    }

}
