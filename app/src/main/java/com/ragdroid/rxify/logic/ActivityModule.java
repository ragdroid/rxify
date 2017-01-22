package com.ragdroid.rxify.logic;

import com.ragdroid.rxify.codelab.presenter2.AssignmentPresenter;
import com.ragdroid.rxify.codelab.presenter2.BattleFlowPresenter;
import com.ragdroid.rxify.codelab.presenter2.BattlePresenter;
import com.ragdroid.rxify.codelab.ChillPresenter;
import com.ragdroid.rxify.codelab.presenter2.DistinctPresenter;
import com.ragdroid.rxify.codelab.presenter2.FilterPresenter;
import com.ragdroid.rxify.codelab.presenter2.FlatMapPresenter;
import com.ragdroid.rxify.codelab.presenter2.MapPresenter;
import com.ragdroid.rxify.codelab.presenter2.ReducePresenter;
import com.ragdroid.rxify.codelab.presenter2.SkipPresenter;
import com.ragdroid.rxify.codelab.presenter2.TakePresenter;
import com.ragdroid.rxify.codelab.presenter2.TakeUntilPresenter;
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

    @ActivityScope
    @Provides
    public TakePresenter provideTakePresenter(BaseSchedulerProvider provider) {
        return new TakePresenter(provider);
    }

    @ActivityScope
    @Provides
    public SkipPresenter provideSkipPresenter(BaseSchedulerProvider provider) {
        return new SkipPresenter(provider);
    }

    @ActivityScope
    @Provides
    public TakeUntilPresenter provideTakeUntilPresenter(BaseSchedulerProvider provider) {
        return new TakeUntilPresenter(provider);
    }

    @ActivityScope
    @Provides
    public ReducePresenter provideReducePresenter(BaseSchedulerProvider provider) {
        return new ReducePresenter(provider);
    }


    @ActivityScope
    @Provides
    public MapPresenter provideMapPresenter(BaseSchedulerProvider provider) {
        return new MapPresenter(provider);
    }

    @ActivityScope
    @Provides
    public FlatMapPresenter provideFlatMapPresenter(BaseSchedulerProvider provider) {
        return new FlatMapPresenter(provider);
    }

    @ActivityScope
    @Provides
    public AssignmentPresenter provideAssignmentPresenter(BaseSchedulerProvider provider) {
        return new AssignmentPresenter(provider);
    }

    @ActivityScope
    @Provides
    public BattlePresenter provideBattlePresenter(BaseSchedulerProvider provider) {
        return new BattlePresenter(provider);
    }

    @ActivityScope
    @Provides
    public BattleFlowPresenter provideBattleFlowPresenter(BaseSchedulerProvider provider) {
        return new BattleFlowPresenter(provider);
    }


}
