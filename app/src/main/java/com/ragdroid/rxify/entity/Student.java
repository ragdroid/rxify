package com.ragdroid.rxify.entity;

import java.util.Random;

/**
 * Created by garimajain on 05/11/16.
 */

public class Student {

    private Random random = new Random();

    public Student(String name) {
        this.name = name;
        this.hair = new Hair();
    }

    private String name;
    private Hair hair;

    public String getName() {
        return name;
    }

    public Hair getHair() {
        return hair;
    }


    private class Hair {

        Hair() {
            this.dna = random.nextInt();
        }

        int dna;
    }
}
