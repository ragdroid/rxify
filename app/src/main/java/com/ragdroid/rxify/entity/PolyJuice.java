package com.ragdroid.rxify.entity;

/**
 * Created by garimajain on 09/11/16.
 */
public class PolyJuice {
    FluxWeed weed;
    Student.Hair hair;

    public PolyJuice(FluxWeed weed, Student.Hair hair) {
        this.weed = weed;
        this.hair = hair;
    }

    public PolyJuice prepare() {
        //do some complex brewing
        return this;
    }

}
