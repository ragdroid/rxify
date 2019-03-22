package com.ragdroid.rxify.codelab.presenter2


import com.jakewharton.rxrelay2.PublishRelay
import com.ragdroid.rxify.codelab.CodeLabContract
import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter
import com.ragdroid.rxify.core.BaseSchedulerProvider


import javax.inject.Inject

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import java.util.concurrent.*

/**
 * Created by garimajain on 15/01/17.
 */

class RelayPresenter @Inject
constructor(provider: BaseSchedulerProvider) : BaseCLPresenter<Int>(provider), CodeLabContract.Presenter {

    private val relay: PublishRelay<Int> = PublishRelay.create()


    override fun getDisposable(): Disposable {

        val observable = Observable.fromArray(1, 2, 3, 4)

        observable.subscribe(relay)

        val disposable = relay
                .compose(lazyTransformer)
                .subscribe(next, error, complete)
        Observable.timer(1000, TimeUnit.MILLISECONDS, provider.computation())
                .subscribe {
                    relay.accept(2)
                }
        return disposable
    }

}
