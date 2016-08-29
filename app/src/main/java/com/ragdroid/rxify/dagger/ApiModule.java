package com.ragdroid.rxify.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by garimajain on 30/08/16.
 */
@Module
public class ApiModule {

    String baseUrl;

    public ApiModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

}
