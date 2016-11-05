package com.ragdroid.rxify.logic;

import android.app.Application;

import com.ragdroid.rxify.core.StudentDataSource;
import com.ragdroid.rxify.logic.remote.StudentRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by garimajain on 30/08/16.
 */
@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    StudentDataSource provideStudentDataSource(StudentRemoteDataSource remoteDataSource) {
        return remoteDataSource;
    }

}
