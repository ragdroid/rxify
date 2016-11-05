package com.ragdroid.rxify.logic.random;

import javax.inject.Inject;

/**
 * Created by garimajain on 05/11/16.
 */

public class Randomizer {

    private static final int MAX_RANDOM = 10;
    private static final int MIN_RANDOM = 1;

    @Inject
    public Randomizer() {

    }

    public int anyRandomInt() {
        return randomInRange(MIN_RANDOM, MAX_RANDOM);
    }

    public int randomStartFrom(int min) {
        return randomInRange(min, min + MAX_RANDOM);
    }

    public int randomInRange(int min, int max) {
        return min + (int)(Math.random() * max);
    }
}
