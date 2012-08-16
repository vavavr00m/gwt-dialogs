
package com.tinesoft.gwt.dialogs.showcase.client.place;

/**
 * Contains the unique identifiers of all presenters.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: NameTokens.java 3427 2011-08-17 15:02:04Z kondotine $
 */
public final class NameTokens {

    /**
     * The 'error' presenter's unique identifier.
     */
    public static final String error = "!error";

    /**
     * The 'home' presenter's unique identifier.
     */
    public static final String home = "!home";

    public static final String messagebox = "!messagebox";

    public static final String colordialog = "!colordialog";

    /**
     * Hide utility class constructor.
     */
    private NameTokens() {}

    public static String getError() {
        return error;
    }

    public static String getHome() {
        return home;
    }

    public static String getMessagebox() {
        return messagebox;
    }

    public static String getColordialog() {
        return colordialog;
    }
}
