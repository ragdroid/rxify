package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.core.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class EmptyPresenter extends BaseCLPresenter<Object> implements CodeLabContract.Presenter {

    @Inject
    public EmptyPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.empty()
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
