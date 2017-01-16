package com.ragdroid.rxify.logic;

import com.ragdroid.rxify.codelab.ChillPresenter;
import com.ragdroid.rxify.codelab.DistinctPresenter;
import com.ragdroid.rxify.codelab.FilterPresenter;
import com.ragdroid.rxify.codelab.presenter.EmptyPresenter;
import com.ragdroid.rxify.codelab.presenter.ErrorPresenter;
import com.ragdroid.rxify.codelab.presenter.FromPresenter;
import com.ragdroid.rxify.codelab.presenter.IntervalPresenter;
import com.ragdroid.rxify.codelab.presenter.IntervalRangePresenter;
import com.ragdroid.rxify.codelab.presenter.JustPresenter;
import com.ragdroid.rxify.codelab.presenter.NeverPresenter;
import com.ragdroid.rxify.codelab.presenter.RangePresenter;
import com.ragdroid.rxify.codelab.presenter.TimerPresenter;
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

    @ActivityScope
    @Provides
    public FromPresenter provideFromPresenter(BaseSchedulerProvider provider) {
        return new FromPresenter(provider);
    }

    @ActivityScope
    @Provides
    public FilterPresenter provideFilterPresenter(BaseSchedulerProvider provider) {
        return new FilterPresenter(provider);
    }

    @ActivityScope
    @Provides
    public DistinctPresenter provideDistinctPresenter(BaseSchedulerProvider provider) {
        return new DistinctPresenter(provider);
    }

}
