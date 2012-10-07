
package com.tinesoft.gwt.dialogs.showcase.client.place;

/**
 * Contains the unique identifiers of all presenters.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
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

    public static final String messagedialog = "!messagedialog";

    public static final String colordialog = "!colordialog";

    public static final String menudialog = "!menudialog";

    public static final String progressdialog = "progressdialog";

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
        return messagedialog;
    }

    public static String getColordialog() {
        return colordialog;
    }

    public static String getMenudialog() {
        return menudialog;
    }

    public static String getProgressdialog() {
        return progressdialog;
    }
}
