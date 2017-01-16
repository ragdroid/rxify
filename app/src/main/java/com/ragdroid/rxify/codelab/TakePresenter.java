package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class TakePresenter extends BaseCLPresenter<Integer> implements CodeLabContract.Presenter {

    //Input
    Observable<Integer> inputValues = Observable.range(0, 10);

    //TODO Print only first five

    @Inject
    public TakePresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .take(5)
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
