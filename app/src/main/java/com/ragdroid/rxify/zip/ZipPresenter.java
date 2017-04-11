package com.ragdroid.rxify.zip;

import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.core.data.MagicalDataSource;
import com.ragdroid.rxify.core.data.StudentDataSource;
import com.ragdroid.rxify.core.zip.ZipData;
import com.ragdroid.rxify.entity.FluxWeed;
import com.ragdroid.rxify.entity.PolyJuice;
import com.ragdroid.rxify.entity.Student;
import com.ragdroid.rxify.logic.mvp.AbstractPresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by garimajain on 08/11/16.
 */

public class ZipPresenter extends AbstractPresenter<ZipContract.View> implements ZipContract.Presenter {

    private final MagicalDataSource magicalDataSource;
    private final StudentDataSource studentDataSource;
    private ZipData zipData = new ZipData();
    private Disposable disposable;

    @Inject
    public ZipPresenter(MagicalDataSource magicalDataSource,
                        StudentDataSource studentDataSource,
                        BaseSchedulerProvider provider) {
        super(provider);
        this.magicalDataSource = magicalDataSource;
        this.studentDataSource = studentDataSource;
    }

    @Override
    public void subscribe() {
        preparePolyjuice();
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void preparePolyjuice() {
        zipData.reset();
        unsubscribe();
        Observable<FluxWeed> fluxWeedObservable = getFluxWeedObservable();
        Observable<Student> crabHairObservable = getStudentObservable();

        disposable = Observable.zip(
                fluxWeedObservable,
                crabHairObservable,
                (fluxWeed, student) -> new PolyJuice(fluxWeed, student.getHair()).prepare())
                .delay(1, TimeUnit.SECONDS, provider.computation())
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe(new Consumer<PolyJuice>() {
                    @Override
                    public void accept(PolyJuice polyJuice) throws Exception {
                        ZipContract.View view = getView();
                        if (view != null) {
                            view.showPolyJuice(zipData);
                        }
                    }
                });

    }

    private Observable<Student> getStudentObservable() {
        return studentDataSource.getStudent("Crab")
                .observeOn(provider.ui())
                .doOnNext(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        zipData.setCrabHairTime(System.currentTimeMillis());
                        ZipContract.View view = getView();
                        if (view != null) {
                            view.showCrabHair(zipData);
                        }
                    }
                });
    }

    private Observable<FluxWeed> getFluxWeedObservable() {
        return magicalDataSource.getFluxWeed()
                .observeOn(provider.ui())
                .doOnNext(new Consumer<FluxWeed>() {
                    @Override
                    public void accept(FluxWeed fluxWeed) throws Exception {
                        zipData.setFluxWeedTime(System.currentTimeMillis());
                        ZipContract.View view = getView();
                        if (view != null) {
                            view.showFluxWeed(zipData);
                        }
                    }
                });
    }
}
