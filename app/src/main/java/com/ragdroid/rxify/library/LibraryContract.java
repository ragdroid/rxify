package com.ragdroid.rxify.library;

import com.ragdroid.rxify.core.mvp.BasePresenter;
import com.ragdroid.rxify.core.mvp.BaseView;
import com.ragdroid.rxify.core.zip.ZipData;
import com.ragdroid.rxify.entity.Book;

import java.util.List;

/**
 * Created by garimajain on 08/11/16.
 */

public interface LibraryContract {

    interface View extends BaseView {

        void showBooks(List<Book> books);
    }

    interface Presenter extends BasePresenter {

        void onQueryTextChange(String newText);

        boolean getState();

        void onFixBugToggleClicked();
    }

}
