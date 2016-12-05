package com.ragdroid.rxify.dagger;

import com.ragdroid.rxify.home.HomeActivity;
import com.ragdroid.rxify.library.LibraryActivity;
import com.ragdroid.rxify.logic.ActivityModule;
import com.ragdroid.rxify.zip.ZipActivity;

import dagger.Component;

/**
 * Created by garimajain on 05/11/16.
 */
@Component(dependencies = {AppComponent.class},
    modules = ActivityModule.class)
@ActivityScope
public interface ActivityComponent {

    void inject(ZipActivity zipActivity);

    void inject(HomeActivity homeActivity);

    void inject(LibraryActivity libraryActivity);
}
