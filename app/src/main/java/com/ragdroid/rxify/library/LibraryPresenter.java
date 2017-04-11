package com.ragdroid.rxify.library;

import android.util.Log;

import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.core.data.BookDataSource;
import com.ragdroid.rxify.entity.Book;
import com.ragdroid.rxify.logic.mvp.AbstractPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by garimajain on 08/11/16.
 */

public class LibraryPresenter extends AbstractPresenter<LibraryContract.View> implements LibraryContract.Presenter {

    private static final String TAG = LibraryPresenter.class.getSimpleName();
    private final BookDataSource dataSource;

    PublishSubject<String> subject = PublishSubject.create();

    private Disposable disposable;
    private boolean isFixed = false;

    @Inject
    public LibraryPresenter(BookDataSource dataSource,
                            BaseSchedulerProvider provider) {
        super(provider);
        this.dataSource = dataSource;
    }

    @Override
    public void subscribe() {
        if (disposable == null) {
            initDisposable();
        }
    }

    private void initDisposable() {
        if (isFixed) {
            disposable = subject
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .switchMap(new Function<String, ObservableSource<List<Book>>>() {
                        @Override
                        public ObservableSource<List<Book>> apply(String s) throws Exception {
                            Log.d(TAG, "getting books for " + s);
                            return dataSource.getBooksJinxed(s);
                        }
                    })
                    .subscribeOn(provider.io())
                    .observeOn(provider.ui())
                    .subscribe(new Consumer<List<Book>>() {
                        @Override
                        public void accept(List<Book> books) throws Exception {
                            onBooksFetched(books);
                        }
                    });
        } else {
            disposable = subject
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .observeOn(provider.io())
                    .flatMap(new Function<String, ObservableSource<List<Book>>>() {
                        @Override
                        public ObservableSource<List<Book>> apply(String s) throws Exception {
                            return dataSource.getBooksJinxed(s);
                        }
                    })
                    .subscribeOn(provider.io())
                    .observeOn(provider.ui())
                    .subscribe(new Consumer<List<Book>>() {
                        @Override
                        public void accept(List<Book> books) throws Exception {
                            onBooksFetched(books);
                        }
                    });
        }
    }

    private void onBooksFetched(List<Book> books) {
        if (getView() != null) {
            getView().showBooks(books);
        }
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }
    }

    @Override
    public void onQueryTextChange(final String newText) {
        if (newText == null || newText.length() == 0) {
            onBooksFetched(new ArrayList<Book>());
        } else {
            subject.onNext(newText);
        }

    }

    @Override
    public boolean getState() {
        return isFixed;
    }

    @Override
    public void onFixBugToggleClicked() {
        this.isFixed = !isFixed;
        unsubscribe();
        initDisposable();
    }
}
