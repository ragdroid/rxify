package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillPresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    public Flowable<Long> inputValues = Flowable.interval(1, 1, TimeUnit.MICROSECONDS);

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

    /** TODO Go inside FlowableInterval class to see where the Exception is thrown
     *
     * Flowable.interval() method is tagged as @BackpressureSupport(BackpressureKind.ERROR)
     * ERROR :
     * The operator will emit a MissingBackpressureException if the downstream didn't request
     * enough or in time.
     *
     * Consumers should consider applying one of the {@code onBackpressureXXX} operators as well.
     */

    //TODO apply onBackpressureBuffer() strategy

    //TODO apply onBackpressureDrop() strategy



}
