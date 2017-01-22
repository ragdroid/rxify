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

public class TakeUntilPresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    //Input
    Observable<Long> inputValues = Observable.interval(100, TimeUnit.MILLISECONDS);
    Observable<Long> cutOff = Observable.timer(250, TimeUnit.MILLISECONDS); //hint

    //TODO Print all values till 250 milliseconds

    @Inject
    public TakeUntilPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .takeUntil(cutOff)
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
