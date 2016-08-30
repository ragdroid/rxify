package com.ragdroid.rxify.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by garimajain on 30/08/16.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {



}
