package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.core.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class RangePresenter extends BaseCLPresenter<Integer> implements CodeLabContract.Presenter {

    @Inject
    public RangePresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.range(1, 10)
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
