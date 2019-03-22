package com.ragdroid.rxify.codelab


import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter
import com.ragdroid.rxify.core.BaseSchedulerProvider


import javax.inject.Inject

import io.reactivex.Observable
import io.reactivex.disposables.Disposable

/**
 * Created by garimajain on 15/01/17.
 */

class ChillPresenter @Inject
constructor(provider: BaseSchedulerProvider) : BaseCLPresenter<String>(provider), CodeLabContract.Presenter {

    override fun getDisposable(): Disposable {
        return Observable.just("Hello World!")
                .compose(lazyTransformer)
                .subscribe(next, error, complete)
    }

}
