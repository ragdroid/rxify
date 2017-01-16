package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.Arrays;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class FromPresenter extends BaseCLPresenter<Integer> implements CodeLabContract.Presenter {

    @Inject
    public FromPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return Observable.fromIterable(Arrays.asList(1, 2, 3, 4, 5, 6))
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
