package com.ragdroid.rxify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ragdroid.rxify.core.mvp.BasePresenter;
import com.ragdroid.rxify.dagger.ActivityComponent;
import com.ragdroid.rxify.dagger.AppComponent;
import com.ragdroid.rxify.dagger.DaggerActivityComponent;
import com.ragdroid.rxify.logic.ActivityModule;

import javax.inject.Inject;

/**
 * Created by garimajain on 08/11/16.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    @Inject T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppComponent appComponent = ((RxifyApplication) getApplication()).getAppComponent();
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule())
                .build();
        injectFrom(activityComponent);
        setupActivity(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void injectFrom(ActivityComponent activityComponent);

    abstract protected void setupActivity(Bundle savedInstanceState);
}
