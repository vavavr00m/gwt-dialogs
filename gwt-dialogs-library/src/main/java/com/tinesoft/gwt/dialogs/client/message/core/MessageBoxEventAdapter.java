
package com.tinesoft.gwt.dialogs.client.message.core;


/**
 * An abstract adapter class for handling dialog box events defined in {@link MessageBoxEventListener}.
 * 
 * The methods in this class are empty. This class is provided as a convenience for easily creating
 * listeners by extending this class and overriding only the methods of interest.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public abstract class MessageBoxEventAdapter implements MessageBoxEventListener {

    @Override
    public void onCloseButtonClicked() {

    }

    @Override
    public void onOkButtonClicked() {

    }

    @Override
    public void onCancelButtonClicked() {

    }

    @Override
    public void onAbortButtonClicked() {

    }

    @Override
    public void onRetryButtonClicked() {

    }

    @Override
    public void onIgnoreButtonClicked() {

    }

    @Override
    public void onYesButtonClicked() {

    }

    @Override
    public void onNoButtonClicked() {

    }

}
