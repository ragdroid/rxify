package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.core.mvp.BasePresenter;
import com.ragdroid.rxify.core.mvp.BaseView;

/**
 * Created by garimajain on 08/11/16.
 */

public interface CodeLabContract {

    interface View extends BaseView {

        void append(String text);
    }

    interface Presenter extends BasePresenter {

        void prepare();
    }

}
