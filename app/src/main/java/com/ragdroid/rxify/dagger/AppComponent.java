package com.ragdroid.rxify.dagger;

import com.ragdroid.rxify.core.StudentDataSource;
import com.ragdroid.rxify.logic.remote.ApiModule;
import com.ragdroid.rxify.logic.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by garimajain on 30/08/16.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {


}
