package com.ragdroid.rxify.logic.mvp;

import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.core.mvp.BaseView;

/**
 * Created by garimajain on 09/11/16.
 */

public abstract class AbstractPresenter<V extends BaseView> {

    protected BaseSchedulerProvider provider;

    public AbstractPresenter(BaseSchedulerProvider provider) {
        this.provider = provider;
    }

    protected V getView() {
        return view;
    }

    private V view;

    public void onViewCreated(V view) {
        this.view = view;
    }

    public void onViewDestroyed() {
        this.view = null;
    }
}
