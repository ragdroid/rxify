package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillPresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    public Observable<Long> inputValues = Observable.interval(1, 1, TimeUnit.MICROSECONDS);

    public ChillPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    //TODO Run the code.

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe(next, error, complete);
    }

    //TODO Limit the number of inputs to 129

    //TODO Buffer 10 items and concatenate them to a String

    //TODO Use Debounce 1 Microsecond to drop some values


}
