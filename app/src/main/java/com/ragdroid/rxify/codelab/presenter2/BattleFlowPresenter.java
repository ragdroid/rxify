package com.ragdroid.rxify.codelab.presenter2;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class BattleFlowPresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    public Flowable<Long> inputValues = Flowable.interval(1, 1, TimeUnit.MICROSECONDS);

    public BattleFlowPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    //TODO Run the code.

//    @Override
//    protected Disposable getDisposable() {
//        return inputValues
//                .subscribeOn(provider.io())
//                .observeOn(provider.ui())
//                .subscribe(next, error, complete);
//    }

    //TODO Limit the number of inputs to 129

//    @Override
//    protected Disposable getDisposable() {
//        return inputValues
//                .take(129)
//                .subscribeOn(provider.io())
//                .observeOn(provider.ui())
//                .subscribe(next, error, complete);
//    }

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

//    @Override
//    protected Disposable getDisposable() {
//        return inputValues
//                .take(129)
//                .onBackpressureBuffer()
//                .subscribeOn(provider.io())
//                .observeOn(provider.ui())
//                .subscribe(next, error, complete);
//    }

    //TODO apply onBackpressureDrop() strategy

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .take(129)
                .onBackpressureDrop()
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe(next, error, complete);
    }


}
