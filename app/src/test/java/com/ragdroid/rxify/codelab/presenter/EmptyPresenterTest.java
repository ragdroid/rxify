package com.ragdroid.rxify.codelab.presenter;

import com.ragdroid.rxify.BasePresenterTest;
import com.ragdroid.rxify.codelab.CodeLabContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;


/**
 * Created by garimajain on 23/01/17.
 */

public class EmptyPresenterTest extends BasePresenterTest {

    @Mock CodeLabContract.View view;

    private EmptyPresenter presenter;

    @Before
    @Override
    public void init() {
        super.init();
        presenter = new EmptyPresenter(schedulerProvider);
        presenter.onViewCreated(view);
    }

    @Test
    public void testGetDisposable() {
        presenter.getDisposable();
        testScheduler.triggerActions();
        //TODO test getDisposable() - view.append() was called once
        verify(view, times(1)).append("Completed.");
    }

}
