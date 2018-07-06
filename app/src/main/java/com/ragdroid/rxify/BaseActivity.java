package com.ragdroid.rxify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ragdroid.rxify.core.mvp.BasePresenter;
import com.ragdroid.rxify.core.mvp.BaseView;
import com.ragdroid.rxify.dagger.ActivityComponent;
import com.ragdroid.rxify.dagger.AppComponent;
import com.ragdroid.rxify.dagger.DaggerActivityComponent;
import com.ragdroid.rxify.logic.ActivityModule;
import com.ragdroid.rxify.logic.mvp.AbstractPresenter;

import javax.inject.Inject;

/**
 * Created by garimajain on 08/11/16.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    @Inject protected T presenter;
    protected ActivityModule activityModule;
    protected Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppComponent appComponent = ((RxifyApplication) getApplication()).getAppComponent();
        activityModule = new ActivityModule();
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(activityModule)
                .build();
        injectFrom(activityComponent);
        ((AbstractPresenter) presenter).onViewCreated(this);
        setupActivity(savedInstanceState);
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    protected void onPause() {
        presenter.unsubscribe();
        super.onPause();
    }

    protected abstract int getLayoutId();

    protected abstract void injectFrom(ActivityComponent activityComponent);

    abstract protected void setupActivity(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        ((AbstractPresenter) presenter).onViewDestroyed();
        activityModule = null;
        super.onDestroy();
    }
}
