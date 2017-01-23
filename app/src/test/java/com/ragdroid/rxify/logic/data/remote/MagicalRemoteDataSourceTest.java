package com.ragdroid.rxify.logic.data.remote;

import com.ragdroid.rxify.logic.random.Randomizer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;

import static org.mockito.Mockito.*;


/**
 * Created by garimajain on 24/01/17.
 */

public class MagicalRemoteDataSourceTest {

    @Mock Randomizer randomizer;
    private MagicalRemoteDataSource magicalDataSource;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.magicalDataSource = new MagicalRemoteDataSource(randomizer);
        when(randomizer.randomInRange(anyInt(), anyInt())).thenReturn(1);
    }

    @Test
    public void testGetFluxWeed() {

        //TODO Create a TestObserver
        TestObserver<Object> testObserver = TestObserver.create();
        //TODO subscribe to getFluxWeed()
        magicalDataSource.getFluxWeed().subscribe(testObserver);
        //TODO tell observer to wait for terminal event
        testObserver.awaitTerminalEvent();
        //TODO assert there are no errors
        testObserver.assertNoErrors();
        //TODO assert we received onComplete
        testObserver.assertComplete();

    }

    @Test
    public void testGetFluxWeedFlowable() {

        //TODO Create a TestSubscriber
        TestSubscriber<Object> testSubscriber = TestSubscriber.create();
        //TODO subscribe to getFluxWeed()
        magicalDataSource.getFluxWeedFlowable().subscribe(testSubscriber);
        //TODO tell subscriber to wait for terminal event
        testSubscriber.awaitTerminalEvent();
        //TODO assert there are no errors
        testSubscriber.assertNoErrors();
        //TODO assert we received onComplete
        testSubscriber.assertComplete();
    }

}
