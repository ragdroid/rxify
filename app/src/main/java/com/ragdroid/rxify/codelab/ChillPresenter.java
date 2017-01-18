package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillPresenter extends BaseCLPresenter<String> implements CodeLabContract.Presenter {


    public ChillPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.just("Just Chill!")
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
