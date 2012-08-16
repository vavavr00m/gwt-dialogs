
package com.tinesoft.gwt.dialogs.showcase.client.gin;

import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.ErrorPagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.HomePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.core.presenter.MainPagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.core.view.ErrorPageView;
import com.tinesoft.gwt.dialogs.showcase.client.core.view.HomePageView;
import com.tinesoft.gwt.dialogs.showcase.client.core.view.MainPageView;
import com.tinesoft.gwt.dialogs.showcase.client.place.ClientPlaceManager;
import com.tinesoft.gwt.dialogs.showcase.client.place.DefaultPlace;
import com.tinesoft.gwt.dialogs.showcase.client.place.ErrorPlace;
import com.tinesoft.gwt.dialogs.showcase.client.place.NameTokens;
import com.tinesoft.gwt.dialogs.showcase.shared.Config;
import com.tinesoft.gwt.dialogs.showcase.client.presenter.ColorDialogShowcasePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.presenter.MessageBoxShowcasePagePresenter;
import com.tinesoft.gwt.dialogs.showcase.client.view.ColorDialogShowcasePageView;
import com.tinesoft.gwt.dialogs.showcase.client.view.MessageBoxShowcasePageView;

/**
 * Client GIN-jector module.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id: ClientModule.java 3858 2012-02-08 10:45:22Z louis.jc $
 */
public class ClientModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule(ClientPlaceManager.class));

        // protect against XSRF attacks
        bindConstant().annotatedWith(SecurityCookie.class).to(Config.SECURITY_COOKIE_NAME);

        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.error);

        // ========== //
        // Presenters //
        // ========== //

        // core module
        bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class, MainPageView.class,
                      MainPagePresenter.MyProxy.class);
        bindPresenter(ErrorPagePresenter.class, ErrorPagePresenter.MyView.class,
                      ErrorPageView.class, ErrorPagePresenter.MyProxy.class);

        bindPresenter(HomePagePresenter.class, HomePagePresenter.MyView.class, HomePageView.class,
                      HomePagePresenter.MyProxy.class);


        bindPresenter(MessageBoxShowcasePagePresenter.class,
                      MessageBoxShowcasePagePresenter.MyView.class,
                      MessageBoxShowcasePageView.class,
                      MessageBoxShowcasePagePresenter.MyProxy.class);

        bindPresenter(ColorDialogShowcasePagePresenter.class,
                      ColorDialogShowcasePagePresenter.MyView.class,
                      ColorDialogShowcasePageView.class,
                      ColorDialogShowcasePagePresenter.MyProxy.class);
    }
}
