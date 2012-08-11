
package com.tinesoft.gwt.dialogs.showcase.client.core;

import com.gwtplatform.mvp.client.proxy.PlaceManager;

/**
 * Custom AsyncCallback that is used when there is no result to return.
 * 
 * @param <T> callback result.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: NoResultAsyncCallback.java 2561 2011-06-16 09:17:15Z kondotine $
 */
public class NoResultAsyncCallback<T> extends DefaultAsyncCallback<T> {

    /**
     * Constructor.
     * 
     * @param placeManager the {@link PlaceManager}.
     */
    public NoResultAsyncCallback(final PlaceManager placeManager) {
        super(placeManager);
    }

    @Override
    public void onSuccess(final T result) {
        // nothing to do since we have an empty result
    }
}
