package com.ragdroid.rxify.core.data;


import com.ragdroid.rxify.entity.FluxWeed;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by garimajain on 05/11/16.
 */

public interface MagicalDataSource {

    Observable<FluxWeed> getFluxWeed();

    Flowable<FluxWeed> getFluxWeedFlowable();
}
