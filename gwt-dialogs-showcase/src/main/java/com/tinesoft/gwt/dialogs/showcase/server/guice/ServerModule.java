
package com.tinesoft.gwt.dialogs.showcase.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;

/**
 * Server guice module.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: ServerModule.java 3833 2012-01-30 17:05:05Z louis.jc $
 */
public class ServerModule extends HandlerModule {

    protected void configureDAOs() {

    }

    @Override
    protected void configureHandlers() {
        configureDAOs();

        // auth module

    }
}
