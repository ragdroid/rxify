package com.ragdroid.rxify.dagger;

import com.ragdroid.rxify.entity.CodeLabData;

import dagger.MapKey;

/**
 * Created by garimajain on 17/05/17.
 */

@MapKey
public @interface CLEnumKey {

    CodeLabData value();

}
