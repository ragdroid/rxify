package com.ragdroid.rxify.zip;

import android.os.Bundle;

import com.ragdroid.rxify.BaseActivity;
import com.ragdroid.rxify.R;
import com.ragdroid.rxify.dagger.ActivityComponent;

import butterknife.ButterKnife;

public class ZipActivity extends BaseActivity<ZipContract.Presenter> implements ZipContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zip;
    }

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

}
