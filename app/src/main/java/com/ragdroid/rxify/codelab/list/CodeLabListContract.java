package com.ragdroid.rxify.codelab.list;

import android.os.Bundle;

import com.ragdroid.rxify.core.mvp.BasePresenter;
import com.ragdroid.rxify.core.mvp.BaseView;
import com.ragdroid.rxify.entity.CodeLabData;

import java.util.List;

/**
 * Created by garimajain on 18/03/17.
 */
public interface CodeLabListContract {

    interface View extends BaseView {

        void setDataList(List<CodeLabData> arrayList);

        void showCodeLab(int itemId);
    }

    interface Presenter extends BasePresenter {

    }

}
