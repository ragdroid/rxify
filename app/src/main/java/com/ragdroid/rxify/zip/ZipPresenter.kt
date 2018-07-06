package com.ragdroid.rxify.zip

import android.util.Log
import com.jakewharton.rxrelay2.PublishRelay
import com.ragdroid.rxify.core.BaseSchedulerProvider
import com.ragdroid.rxify.core.data.MagicalDataSource
import com.ragdroid.rxify.core.data.StudentDataSource
import com.ragdroid.rxify.core.zip.ZipData
import com.ragdroid.rxify.entity.FluxWeed
import com.ragdroid.rxify.entity.PolyJuice
import com.ragdroid.rxify.entity.Student
import com.ragdroid.rxify.logic.mvp.AbstractPresenter

import java.util.concurrent.TimeUnit

import javax.inject.Inject

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject

/**
 * Created by garimajain on 08/11/16.
 */

class ZipPresenter @Inject
constructor(private val magicalDataSource: MagicalDataSource,
            private val studentDataSource: StudentDataSource,
            provider: BaseSchedulerProvider) : AbstractPresenter<ZipContract.View>(provider), ZipContract.Presenter {

    private val zipData = ZipData()
    private var disposable: Disposable? = null


    private val studentObservable: Observable<Student>
        get() = studentDataSource.getStudent("Crab")
                .observeOn(provider.ui())
                .doOnNext {
                    zipData.setCrabHairTime(System.currentTimeMillis())
                    val view = view
                    view?.showCrabHair(zipData)
                }

    private val fluxWeedObservable: Observable<FluxWeed>
        get() = magicalDataSource.fluxWeed
                .observeOn(provider.ui())
                .doOnNext {
                    zipData.setFluxWeedTime(System.currentTimeMillis())
                    val view = view
                    view?.showFluxWeed(zipData)
                }

    override fun subscribe() {
        preparePolyjuice()
    }

    override fun unsubscribe() {
        if (disposable != null && !disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }

    override fun preparePolyjuice() {
        zipData.reset()
        unsubscribe()
        val fluxWeedObservable = fluxWeedObservable
        val crabHairObservable = studentObservable

        disposable = Observable.zip<FluxWeed, Student, PolyJuice>(
                fluxWeedObservable,
                crabHairObservable,
                BiFunction{ fluxWeed, student -> PolyJuice(fluxWeed, student.hair).prepare() })
                .delay(1, TimeUnit.SECONDS, provider.computation())
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe {
                    val view = view
                    view?.showPolyJuice(zipData)
                }

    }
}
