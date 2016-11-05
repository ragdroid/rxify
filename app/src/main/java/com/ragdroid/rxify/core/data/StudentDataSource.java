package com.ragdroid.rxify.core.data;

import android.support.annotation.NonNull;

import com.ragdroid.rxify.entity.Student;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 *  Simulates network call by adding latency
 * Created by garimajain on 05/11/16.
 */

public interface StudentDataSource {

    Observable<Student> getStudent(@NonNull String name);

    Single<List<Student>> getStudents();

    void saveStudent(@NonNull Student student);

}
