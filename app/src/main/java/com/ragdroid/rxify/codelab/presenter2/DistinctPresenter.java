package com.ragdroid.rxify.codelab.presenter2;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.Arrays;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class DistinctPresenter extends BaseCLPresenter<Integer> implements CodeLabContract.Presenter {

    //Input
    Observable<Integer> inputValues = Observable.fromIterable(Arrays.asList(1, 1, 2, 3, 2));

    //TODO Print all distinct numbers

    @Inject
    public DistinctPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .distinct()
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
