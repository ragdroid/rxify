package com.ragdroid.rxify.home;

import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.logic.mvp.AbstractPresenter;

import javax.inject.Inject;

/**
 * Created by garimajain on 05/11/16.
 */

public class HomePresenter extends AbstractPresenter<HomeContract.View> implements HomeContract.Presenter {

    @Inject
    public HomePresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
