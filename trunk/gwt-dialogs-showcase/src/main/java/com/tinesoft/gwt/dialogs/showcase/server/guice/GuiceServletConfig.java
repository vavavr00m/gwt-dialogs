
package com.tinesoft.gwt.dialogs.showcase.server.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Facade for Guice dependency injector container.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: GuiceServletConfig.java 2900 2011-07-06 16:50:50Z kondotine $
 */
public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServerModule(), new DispatchServletModule());
    }
}
