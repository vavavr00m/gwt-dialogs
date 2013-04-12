
package com.tinesoft.gwt.dialogs.client.resources;

import com.google.gwt.resources.client.CssResource;

/**
 * Base CssResource style.
 * 
 * @author Tine Kondo
 * @version $Id$
 */
public interface BaseStyle extends CssResource {

    String clear();

    String left();

    String notSelectable();

    String right();

    String selectedButton();

    String stripe();

    /**
     * The path to the default CSS styles used by this resource.
     */
    String DEFAULT_CSS = "com/tinesoft/gwt/dialogs/client/resources/BaseStyle.css";
}
