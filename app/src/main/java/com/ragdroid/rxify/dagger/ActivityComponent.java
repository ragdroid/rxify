package com.ragdroid.rxify.dagger;

import com.ragdroid.rxify.codelab.ChillActivity;
import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.list.CodeLabListActivity;
import com.ragdroid.rxify.entity.CodeLabData;
import com.ragdroid.rxify.home.HomeActivity;
import com.ragdroid.rxify.library.LibraryActivity;
import com.ragdroid.rxify.logic.ActivityModule;
import com.ragdroid.rxify.zip.ZipActivity;

import java.util.Map;

import javax.inject.Provider;

import dagger.Component;
import dagger.Lazy;

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

    void inject(ChillActivity chillActivity);

    void inject(CodeLabListActivity codeLabListActivity);

    Map<CodeLabData, Provider<CodeLabContract.Presenter>> providePresentersMap();
}
