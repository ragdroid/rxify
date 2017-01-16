package com.ragdroid.rxify.logic;

import com.ragdroid.rxify.codelab.ChillPresenter;
import com.ragdroid.rxify.codelab.EmptyPresenter;
import com.ragdroid.rxify.codelab.ErrorPresenter;
import com.ragdroid.rxify.codelab.IntervalPresenter;
import com.ragdroid.rxify.codelab.IntervalRangePresenter;
import com.ragdroid.rxify.codelab.JustPresenter;
import com.ragdroid.rxify.codelab.NeverPresenter;
import com.ragdroid.rxify.codelab.RangePresenter;
import com.ragdroid.rxify.codelab.TimerPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.dagger.ActivityScope;
import com.ragdroid.rxify.home.HomeContract;
import com.ragdroid.rxify.home.HomePresenter;
import com.ragdroid.rxify.library.LibraryContract;
import com.ragdroid.rxify.library.LibraryPresenter;
import com.ragdroid.rxify.zip.ZipContract;
import com.ragdroid.rxify.zip.ZipPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by garimajain on 05/11/16.
 */
@Module
@ActivityScope
public class ActivityModule {

    @ActivityScope
    @Provides
    public HomeContract.Presenter provideHomePresenter(HomePresenter presenter) {
        return presenter;
    }

    @ActivityScope
    @Provides
    public ZipContract.Presenter provideZipPresenter(ZipPresenter presenter) {
        return presenter;
    }

    @ActivityScope
    @Provides
    public LibraryContract.Presenter provideLibraryPresenter(LibraryPresenter presenter) {
        return presenter;
    }

    @ActivityScope
    @Provides
    public ChillPresenter provideChillPresenter(BaseSchedulerProvider provider) {
        return new ChillPresenter(provider);
    }

    @ActivityScope
    @Provides
    public JustPresenter provideJustPresenter(BaseSchedulerProvider provider) {
        return new JustPresenter(provider);
    }

    @ActivityScope
    @Provides
    public EmptyPresenter provideEmptyPresenter(BaseSchedulerProvider provider) {
        return new EmptyPresenter(provider);
    }


    @ActivityScope
    @Provides
    public NeverPresenter provideNeverPresenter(BaseSchedulerProvider provider) {
        return new NeverPresenter(provider);
    }

    @ActivityScope
    @Provides
    public ErrorPresenter provideErrorPresenter(BaseSchedulerProvider provider) {
        return new ErrorPresenter(provider);
    }


    @ActivityScope
    @Provides
    public RangePresenter provideRangePresenter(BaseSchedulerProvider provider) {
        return new RangePresenter(provider);
    }


    @ActivityScope
    @Provides
    public IntervalPresenter provideIntervalPresenter(BaseSchedulerProvider provider) {
        return new IntervalPresenter(provider);
    }

    @ActivityScope
    @Provides
    public IntervalRangePresenter provideIntervalRangePresenter(BaseSchedulerProvider provider) {
        return new IntervalRangePresenter(provider);
    }

    @ActivityScope
    @Provides
    public TimerPresenter provideTimerPresenter(BaseSchedulerProvider provider) {
        return new TimerPresenter(provider);
    }


}
