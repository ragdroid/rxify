package com.ragdroid.rxify.logic;

import com.ragdroid.rxify.codelab.CodeLabContract;
import com.ragdroid.rxify.codelab.list.CodeLabListPresenter;
import com.ragdroid.rxify.codelab.misc.TimeTurnerPresenter;
import com.ragdroid.rxify.codelab.presenter2.ThreadingPresenter;
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
import com.ragdroid.rxify.dagger.CLEnumKey;
import com.ragdroid.rxify.entity.CodeLabData;
import com.ragdroid.rxify.home.HomeContract;
import com.ragdroid.rxify.home.HomePresenter;
import com.ragdroid.rxify.library.LibraryContract;
import com.ragdroid.rxify.library.LibraryPresenter;
import com.ragdroid.rxify.zip.ZipContract;
import com.ragdroid.rxify.zip.ZipPresenter;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

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
    @IntoMap
    @CLEnumKey(CodeLabData.CHILL)
    public static CodeLabContract.Presenter provideChillPresenter(ChillPresenter chillPresenter) {
        return chillPresenter;
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.JUST)
    public static CodeLabContract.Presenter provideJustPresenter(BaseSchedulerProvider provider) {
        return new JustPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.EMPTY)
    public static CodeLabContract.Presenter provideEmptyPresenter(BaseSchedulerProvider provider) {
        return new EmptyPresenter(provider);
    }


    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.NEVER)
    public static CodeLabContract.Presenter provideNeverPresenter(BaseSchedulerProvider provider) {
        return new NeverPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.ERROR)
    public static CodeLabContract.Presenter provideErrorPresenter(BaseSchedulerProvider provider) {
        return new ErrorPresenter(provider);
    }


    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.RANGE)
    public static CodeLabContract.Presenter provideRangePresenter(BaseSchedulerProvider provider) {
        return new RangePresenter(provider);
    }


    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.INTERVAL)
    public static CodeLabContract.Presenter provideIntervalPresenter(BaseSchedulerProvider provider) {
        return new IntervalPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.INTERVAL_RANGE)
    public static CodeLabContract.Presenter provideIntervalRangePresenter(BaseSchedulerProvider provider) {
        return new IntervalRangePresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.TIMER)
    public static CodeLabContract.Presenter provideTimerPresenter(BaseSchedulerProvider provider) {
        return new TimerPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.FROM)
    public static CodeLabContract.Presenter provideFromPresenter(BaseSchedulerProvider provider) {
        return new FromPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.FILTER)
    public static CodeLabContract.Presenter provideFilterPresenter(BaseSchedulerProvider provider) {
        return new FilterPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.DISTINCT)
    public static CodeLabContract.Presenter provideDistinctPresenter(BaseSchedulerProvider provider) {
        return new DistinctPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.TAKE)
    public static CodeLabContract.Presenter provideTakePresenter(BaseSchedulerProvider provider) {
        return new TakePresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.SKIP)
    public static CodeLabContract.Presenter provideSkipPresenter(BaseSchedulerProvider provider) {
        return new SkipPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.TAKE_UNTIL)
    public static CodeLabContract.Presenter provideTakeUntilPresenter(BaseSchedulerProvider provider) {
        return new TakeUntilPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.REDUCE)
    public static CodeLabContract.Presenter provideReducePresenter(BaseSchedulerProvider provider) {
        return new ReducePresenter(provider);
    }


    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.MAP)
    public static CodeLabContract.Presenter provideMapPresenter(BaseSchedulerProvider provider) {
        return new MapPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.FLATMAP)
    public static CodeLabContract.Presenter provideFlatMapPresenter(BaseSchedulerProvider provider) {
        return new FlatMapPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.ASSIGNMENT)
    public static CodeLabContract.Presenter provideAssignmentPresenter(BaseSchedulerProvider provider) {
        return new AssignmentPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.BATTLE)
    public static CodeLabContract.Presenter provideBattlePresenter(BaseSchedulerProvider provider) {
        return new BattlePresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.BATTLE_FLOW)
    public static CodeLabContract.Presenter provideBattleFlowPresenter(BaseSchedulerProvider provider) {
        return new BattleFlowPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.THREAD)
    public static CodeLabContract.Presenter provideThreadingPresenter(BaseSchedulerProvider provider) {
        return new ThreadingPresenter(provider);
    }

    @ActivityScope
    @Provides
    @IntoMap
    @CLEnumKey(CodeLabData.TIME_TURNER)
    public static CodeLabContract.Presenter provideTimeTurnerPresenter(BaseSchedulerProvider provider) {
        return new TimeTurnerPresenter(provider);
    }

    @ActivityScope
    @Provides
    public CodeLabContract.Presenter provideDefaultPresenter(BaseSchedulerProvider provider) {
        return new ChillPresenter(provider);
    }

    @ActivityScope
    @Provides
    public CodeLabListPresenter provideCLListPresenter(BaseSchedulerProvider provider) {
        return new CodeLabListPresenter(provider);
    }

}
