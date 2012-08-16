
package com.tinesoft.gwt.dialogs.showcase.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.ErrorPagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.HomePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.MainPagePresenter;
import com.google.gwt.inject.client.AsyncProvider;
import com.tinesoft.gwt.dialogs.showcase.client.presenter.ColorDialogShowcasePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.presenter.MessageBoxShowcasePagePresenter;

/**
 * GIN-jector configuration.
 * <p>
 * All {@link com.gwtplatform.mvp.client.Presenter} must be registered here.
 * </p>
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: ClientGinjector.java 3427 2011-08-17 15:02:04Z kondotine $
 */
@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

    /**
     * Returns the event bus.
     * 
     * @return the {@link EventBus}.
     */
    EventBus getEventBus();

    /**
     * Returns the place manager.
     * 
     * @return the {@link PlaceManager}.
     */
    PlaceManager getPlaceManager();

    /**
     * Returns an instance of {@link MainPagePresenter}.
     * 
     * @return the page presenter provider.
     */
    Provider<MainPagePresenter> getMainPagePresenter();

    /**
     * Returns an instance of {@link ErrorPagePresenter}.
     * 
     * @return the page presenter provider.
     */
    Provider<ErrorPagePresenter> getErrorPagePresenter();

    /**
     * Returns an instance of {@link HomePagePresenter}.
     * 
     * @return the page presenter provider.
     */
    Provider<HomePagePresenter> getHomePagePresenter();

    AsyncProvider<MessageBoxShowcasePagePresenter> getMessageBoxShowcasePagePresenter();

    AsyncProvider<ColorDialogShowcasePagePresenter> getColorDialogShowcasePagePresenter();
}
