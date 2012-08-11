
package com.tinesoft.gwt.dialogs.showcase.client.core;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.tinesoft.gwt.dialogs.showcase.client.util.GWTLog;

/**
 * Custom AsyncCallback that will display automatically the error page on failure.
 * 
 * @param <T> callback result.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: DefaultAsyncCallback.java 2943 2011-07-11 08:28:16Z kondotine $
 */
public abstract class DefaultAsyncCallback<T> implements AsyncCallback<T> {

    private final PlaceManager placeManager;

    /**
     * Constructor.
     * 
     * @param placeManager the {@link PlaceManager}.
     */
    public DefaultAsyncCallback(final PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    @Override
    public void onFailure(final Throwable caught) {
        final String token = placeManager.getCurrentPlaceRequest().getNameToken();
        GWTLog.error("FAILURE: {}", token);
        GWTLog.error("  exception: ", caught);
        placeManager.revealErrorPlace(token);
    }
}
