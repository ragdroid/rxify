package com.ragdroid.rxify.logic.data.remote;

import com.ragdroid.rxify.core.data.MagicalDataSource;
import com.ragdroid.rxify.entity.FluxWeed;
import com.ragdroid.rxify.logic.random.Randomizer;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by garimajain on 05/11/16.
 */

public class MagicalRemoteDataSource implements MagicalDataSource {

    private final Randomizer randomizer;

    @Inject
    public MagicalRemoteDataSource(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    @Override
    public Observable<FluxWeed> getFluxWeed() {
        return Observable.just(new FluxWeed())
                .delay(randomizer.randomInRange(2, 5), TimeUnit.SECONDS);
    }
}
