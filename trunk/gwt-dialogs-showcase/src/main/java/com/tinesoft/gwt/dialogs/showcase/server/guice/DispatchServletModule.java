
package com.tinesoft.gwt.dialogs.showcase.server.guice;

import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.server.guice.HttpSessionSecurityCookieFilter;
import com.gwtplatform.dispatch.shared.Action;
import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.tinesoft.gwt.dialogs.showcase.shared.Config;

/**
 * Server guice module for servlets and data access.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: DispatchServletModule.java 3093 2011-07-19 16:02:30Z kondotine $
 */
public class DispatchServletModule extends ServletModule {

    public static final String DEFAULT_SERVICE_PATH = "/";

    @Override
    public void configureServlets() {
        bindConstants();
        bindFilters();
        bindServlets();
    }

    protected void bindConstants() {
        // protect against XSRF attacksS
        bindConstant().annotatedWith(SecurityCookie.class).to(Config.SECURITY_COOKIE_NAME);
    }

    protected void bindFilters() {

        // protect against XSRF attacks
        filter("*").through(HttpSessionSecurityCookieFilter.class);
    }

    protected void bindServlets() {
        // secured service
        serve(DispatchServletModule.DEFAULT_SERVICE_PATH + Action.DEFAULT_SERVICE_NAME).with(DispatchServiceImpl.class);
    }

}
