package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.Arrays;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillPresenter extends BaseCLPresenter<String> implements CodeLabContract.Presenter {

    Observable<String> inputValues = Observable.fromIterable(Arrays.asList("Hello World!", "How Are You?"));

    //TODO Print all the words from strings

    @Inject
    public ChillPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
