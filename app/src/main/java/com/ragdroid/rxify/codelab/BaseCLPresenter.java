package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.logic.mvp.AbstractPresenter;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by garimajain on 08/11/16.
 */

public abstract class BaseCLPresenter<T> extends
        AbstractPresenter<CodeLabContract.View> implements CodeLabContract.Presenter {

    private Disposable disposable;

    protected Consumer<T> next = new Consumer<T>() {
        @Override
        public void accept(T t) throws Exception {
            if (getView() != null) {
                getView().append(t.toString());
            }
        }
    };

    protected Action complete =  new Action() {
        @Override
        public void run() throws Exception {
            if (getView() != null) {
                getView().append("Completed.");
            }
        }
    };

    protected Consumer<Throwable> error = new Consumer<Throwable>() {
        @Override
        public void accept(Throwable throwable) throws Exception {
            if (getView() != null) {
                getView().append("Error : " + throwable.getMessage());
            }
        }
    };

    public BaseCLPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    public void subscribe() {
        prepare();
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void prepare() {
        unsubscribe();
        disposable = getDisposable();
    }

    protected abstract Disposable getDisposable();

    ObservableTransformer<T, T> lazyTransformer = new ObservableTransformer<T, T>() {
        @Override
        public ObservableSource<T> apply(Observable<T> upstream) {
            return upstream.subscribeOn(provider.io())
                    .observeOn(provider.ui());
        }
    };

}
