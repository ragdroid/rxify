package com.ragdroid.rxify.codelab.presenter;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class TimerPresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    @Inject
    public TimerPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.timer(1, TimeUnit.SECONDS)
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
