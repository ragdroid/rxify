package com.ragdroid.rxify.logic.remote;

import com.ragdroid.rxify.core.MagicalDataSource;
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
    public Observable<FluxWeed> getFluxweed() {
        return Observable.just(new FluxWeed())
                .delay(randomizer.randomInRange(1, 3), TimeUnit.SECONDS);
    }
}
