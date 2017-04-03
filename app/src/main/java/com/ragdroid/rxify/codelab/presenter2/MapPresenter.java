package com.ragdroid.rxify.codelab.presenter2;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class MapPresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    Observable<Long> inputValues = Observable.intervalRange(1, 10, 100, 500, TimeUnit.MILLISECONDS);

    //TODO Print multiples of 5

    @Inject
    public MapPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .map(aLong -> aLong * 5)
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }

}
