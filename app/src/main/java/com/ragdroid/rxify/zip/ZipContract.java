package com.ragdroid.rxify.zip;

import com.ragdroid.rxify.core.mvp.BasePresenter;
import com.ragdroid.rxify.core.mvp.BaseView;
import com.ragdroid.rxify.core.zip.ZipData;
import com.ragdroid.rxify.entity.FluxWeed;

/**
 * Created by garimajain on 08/11/16.
 */

public interface ZipContract {

    interface View extends BaseView {

        void showFluxWeed(ZipData fluxWeed);

        void showCrabHair(ZipData zipData);

        void showPolyJuice(ZipData zipData);
    }

    interface Presenter extends BasePresenter {

        void preparePolyjuice();
    }

}
