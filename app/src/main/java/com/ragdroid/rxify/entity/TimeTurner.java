package com.ragdroid.rxify.entity;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/**
 * Created by garimajain on 09/04/17.
 */
public class TimeTurner {

    public Observable<Lecture> getLectureObservable(int id) {
        return Observable.defer(new Callable<ObservableSource<Lecture>>() {
            @Override
            public ObservableSource<Lecture> call() {
                return Observable.just(new Lecture(id)).delay(id, TimeUnit.SECONDS);
            }
        });
    }


    public class Lecture {
        public int getId() {
            return id;
        }

        private final int id;

        Lecture(int id) {
            this.id = id;
        }
    }


}
