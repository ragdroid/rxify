package com.ragdroid.rxify;

import android.support.annotation.NonNull;

import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.core.data.MagicalDataSource;
import com.ragdroid.rxify.core.data.StudentDataSource;
import com.ragdroid.rxify.core.mvp.BaseView;
import com.ragdroid.rxify.zip.ZipContract;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

/**
 * Created by garimajain on 22/11/16.
 */

public class BasePresenterTest {


    @Mock
    MagicalDataSource magicalDataSource;

    @Mock
    StudentDataSource studentDataSource;

    protected TestScheduler testScheduler = new TestScheduler();

    BaseSchedulerProvider schedulerProvider = new BaseSchedulerProvider() {

        @NonNull
        @Override
        public Scheduler computation() {
            return testScheduler;
        }

        @NonNull
        @Override
        public Scheduler io() {
            return testScheduler;
        }

        @NonNull
        @Override
        public Scheduler ui() {
            return testScheduler;
        }
    };

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

}
