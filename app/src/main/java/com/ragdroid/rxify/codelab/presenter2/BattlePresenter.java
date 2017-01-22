package com.ragdroid.rxify.codelab.presenter2;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 15/01/17.
 */

public class BattlePresenter extends BaseCLPresenter<Long> implements CodeLabContract.Presenter {

    public Observable<Long> inputValues = Observable.interval(1, 1, TimeUnit.MICROSECONDS);

    public BattlePresenter(BaseSchedulerProvider provider) {
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

    //TODO Buffer 10 items and concatenate them to a String

//    @Override
//    protected Disposable getDisposable() {
//        return inputValues
//                .take(129)
//                .buffer(10)
//                .flatMap(new Function<List<Long>, ObservableSource<String>>() {
//                    @Override
//                    public ObservableSource<String> apply(List<Long> longs) throws Exception {
//                        return Observable.fromIterable(longs)
//                                .reduce("", new BiFunction<String, Long, String>() {
//                                    @Override
//                                    public String apply(String oldString, Long aLong) throws Exception {
//                                        return oldString + "\n" + aLong;
//                                    }
//                                }).toObservable();
//                    }
//                })
//                .subscribeOn(provider.io())
//                .observeOn(provider.ui())
//                .subscribe(next, error, complete);
//    }

//    SIRIUSLY

    //TODO Use Debounce 1 Microsecond to drop some values


    @Override
    protected Disposable getDisposable() {
        return inputValues
                .take(129)
                .debounce(1, TimeUnit.MICROSECONDS)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe(next, error, complete);
    }
}
