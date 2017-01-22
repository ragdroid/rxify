package com.ragdroid.rxify.codelab.presenter;

import com.ragdroid.rxify.BasePresenterTest;
import com.ragdroid.rxify.codelab.CodeLabContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by garimajain on 23/01/17.
 */

public class NeverPresenterTest extends BasePresenterTest {

    @Mock CodeLabContract.View view;

    private NeverPresenter presenter;

    @Before
    @Override
    public void init() {
        super.init();
        presenter = new NeverPresenter(schedulerProvider);
        presenter.onViewCreated(view);
    }

    @Test
    public void testGetDisposable() {
        presenter.getDisposable();
        testScheduler.triggerActions();
        //TODO test getDisposable() - view.append() was called 0 times
    }

}
