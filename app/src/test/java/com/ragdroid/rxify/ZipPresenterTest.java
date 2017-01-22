package com.ragdroid.rxify;

import com.ragdroid.rxify.core.zip.ZipData;
import com.ragdroid.rxify.entity.FluxWeed;
import com.ragdroid.rxify.entity.Student;
import com.ragdroid.rxify.zip.ZipContract;
import com.ragdroid.rxify.zip.ZipPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

import static org.mockito.Mockito.*;

/**
 * Created by garimajain on 21/11/16.
 */

public class ZipPresenterTest extends BasePresenterTest {


    @Mock
    ZipContract.View view;

    private ZipPresenter presenter;

    @Before
    @Override
    public void init() {
        super.init();
        presenter = new ZipPresenter(magicalDataSource, studentDataSource, schedulerProvider);
        presenter.onViewCreated(view);
    }


    @Test
    public void testPreparePolyJuice() {
        initTestData();
        presenter.preparePolyjuice();
        verify(view, times(0)).showPolyJuice(any(ZipData.class));
        testScheduler.triggerActions();
        testScheduler.advanceTimeTo(2, TimeUnit.SECONDS);
        verify(view, times(1)).showFluxWeed(any(ZipData.class));
        verify(view, times(1)).showCrabHair(any(ZipData.class));
        verify(view, times(1)).showPolyJuice(any(ZipData.class));
    }

    private void initTestData() {
        FluxWeed fluxWeed = new FluxWeed();
        when(magicalDataSource.getFluxWeed()).thenReturn(Observable.just(fluxWeed));
        Student student = new Student("Crab");
        when(studentDataSource.getStudent(anyString())).thenReturn(Observable.just(student));
    }

}
