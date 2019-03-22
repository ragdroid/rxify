package com.ragdroid.rxify.codelab.presenter2


import com.ragdroid.rxify.codelab.CodeLabContract
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter
import com.ragdroid.rxify.core.BaseSchedulerProvider


import javax.inject.Inject

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.*

/**
 * Created by garimajain on 15/01/17.
 */

class SubjectPresenter @Inject
constructor(provider: BaseSchedulerProvider) : BaseCLPresenter<Int>(provider), CodeLabContract.Presenter {

    private val subject: PublishSubject<Int> = PublishSubject.create()


    override fun getDisposable(): Disposable {

        val observable = Observable.fromArray(1, 2, 3, 4)

        observable
                .subscribe(subject)


        val disposable = subject
                .compose(lazyTransformer)
                .subscribe(next, error, complete)
        Observable.timer(1000, TimeUnit.MILLISECONDS, provider.computation())
                .subscribe {
                    subject.onNext(5)
                }
        return disposable
    }

}
