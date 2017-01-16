package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class IntervalPresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    @Inject
    public IntervalPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.interval(1000, TimeUnit.MILLISECONDS)
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
