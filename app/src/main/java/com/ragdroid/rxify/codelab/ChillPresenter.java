package com.ragdroid.rxify.codelab;

import android.util.Log;

import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillPresenter extends BaseCLPresenter<Integer> implements CodeLabContract.Presenter {

    public Observable<Integer> inputValues = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
        @Override
        public ObservableSource<? extends Integer> call() throws Exception {
            Log.d("Threading", "Creating observable on " + Thread.currentThread().getName());
            return Observable.range(1, 10);
        }
    });

    public ChillPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }


    @Override
    protected Disposable getDisposable() {
        return inputValues
//                .subscribeOn(provider.computation())
//                .observeOn(provider.io())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("Threading", "Emitting " + integer
                                + " on " + Thread.currentThread().getName());
                    }
                })
//                .observeOn(provider.computation())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        Log.d("Threading", "Mapping " + integer
                                + " on " + Thread.currentThread().getName());
                        return integer * 1000;
                    }
                })
//                .observeOn(provider.ui())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("Threading", "Received " + integer
                                + " on " + Thread.currentThread().getName());
                    }
                });
    }


}
