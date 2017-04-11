package com.ragdroid.rxify.codelab.misc;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.entity.TimeTurner;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by garimajain on 09/04/17.
 */

public class TimeTurnerPresenter extends BaseCLPresenter<String> implements CodeLabContract.Presenter {
    @Inject
    public TimeTurnerPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {

        TimeTurner timeTurner = new TimeTurner();
        Observable<TimeTurner.Lecture> lectureOneObservable = timeTurner.getLectureObservable(1)
                .subscribeOn(provider.ui())
                .observeOn(provider.ui())
                .doOnNext(lecture -> {
                    if (getView() != null) {
                        getView().append("Attended Lecture " + lecture.getId());
                    }
                });
        Observable<TimeTurner.Lecture> lectureTwoObservable = timeTurner.getLectureObservable(2)
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .doOnNext(lecture -> {
                    if (getView() != null) {
                        getView().append("Attended Lecture " + lecture.getId());
                    }
                });

        return Observable.zip(lectureOneObservable, lectureTwoObservable,
                (lecture, lecture2) -> String.format("Attended Lectures %s and %s", lecture.getId(), lecture2.getId()))
                .subscribe(message -> {
                    if (getView() != null) {
                        getView().append(message);
                    }
                });
    }


}
