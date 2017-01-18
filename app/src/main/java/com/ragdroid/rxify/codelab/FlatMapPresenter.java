package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.Arrays;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by garimajain on 15/01/17.
 */

public class FlatMapPresenter extends BaseCLPresenter<String> implements CodeLabContract.Presenter {

    Observable<String> inputValues = Observable.fromIterable(Arrays.asList("Hello World!", "How Are You?"));

    //TODO Print all the words from strings

    @Inject
    public FlatMapPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(String inputString) throws Exception {
                        return Observable.fromArray(inputString.split(" "));
                    }
                })
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
