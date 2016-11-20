package com.ragdroid.rxify.core;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by garimajain on 21/11/16.
 */
public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
