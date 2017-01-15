package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.dagger.ActivityComponent;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillActivity extends BaseCLActivity<ChillPresenter> implements CodeLabContract.View {

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

}
