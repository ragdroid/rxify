package com.ragdroid.rxify.codelab.presenter2;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by garimajain on 15/01/17.
 */

public class AssignmentPresenter extends BaseCLPresenter<String> implements CodeLabContract.Presenter {

    //Input
    Observable<String> gryffindorObservable = Observable.defer(new Callable<ObservableSource<? extends String>>() {
        @Override
        public ObservableSource<? extends String> call() throws Exception {
            return Observable.range(1, 2)
                    .flatMap(new Function<Integer, ObservableSource<String>>() {
                        @Override
                        public ObservableSource<String> apply(Integer integer) throws Exception {
                            return Observable.just("G" + integer)
                                    .delay(integer * 500, TimeUnit.MILLISECONDS);
                        }
                    });
        }
    });
    Observable<String> slytherinObservable = Observable.defer(new Callable<ObservableSource<? extends String>>() {
        @Override
        public ObservableSource<? extends String> call() throws Exception {
            return Observable.range(1, 2)
                    .flatMap(new Function<Integer, ObservableSource<String>>() {
                        @Override
                        public ObservableSource<String> apply(Integer integer) throws Exception {
                            return Observable.just("S" + integer)
                                    .delay(integer * 700, TimeUnit.MILLISECONDS);
                        }
                    });
        }
    });

    //TODO AssignmentEvaluator
    //Input is G1(500 ms), S1(700ms), G2(1000 ms), S2(1400 ms)

    @Inject
    public AssignmentPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    //Hermione's fix
    @Override
    protected Disposable getDisposable() {
        return gryffindorObservable.
                mergeWith(slytherinObservable)
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }


    //Dracos Trick
//    @Override
//    protected Disposable getDisposable() {
//        return slytherinObservable.
//                concatWith(gryffindorObservable)
//                .compose(lazyTransformer)
//                .subscribe(next, error, complete);
//    }
}
