package com.ragdroid.rxify.entity;

/**
 * Created by garimajain on 04/12/16.
 */

public class Book {

    public String name;
    public String authorName;

    public Book(String bookName) {
        this.name = bookName;
        this.authorName = "Some Wizard";
    }
}
