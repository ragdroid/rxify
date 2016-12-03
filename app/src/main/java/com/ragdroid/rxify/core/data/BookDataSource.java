package com.ragdroid.rxify.core.data;

import android.support.annotation.NonNull;

import com.ragdroid.rxify.entity.Book;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by garimajain on 04/12/16.
 */

public interface BookDataSource {

    Observable<List<Book>> getBook(@NonNull String name);

}
