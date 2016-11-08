package com.ragdroid.rxify.zip;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.ragdroid.rxify.BaseActivity;
import com.ragdroid.rxify.R;
import com.ragdroid.rxify.core.zip.ZipData;
import com.ragdroid.rxify.dagger.ActivityComponent;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ZipActivity extends BaseActivity<ZipContract.Presenter> implements ZipContract.View {

    @BindView(R.id.zip_refresh) SwipeRefreshLayout refreshLayout;
    @BindView(R.id.zip_one_one) View oneOne;
    @BindView(R.id.zip_one_two) View oneTwo;
    @BindView(R.id.zip_two_one) View twoOne;
    @BindView(R.id.zip_two_two) View twoTwo;
    @BindView(R.id.zip_three) View three;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_zip;
    }

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        clearView();
        refreshLayout.setRefreshing(true);
    }

    @Override
    protected void onPause() {
        refreshLayout.setRefreshing(false);
        super.onPause();
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        ButterKnife.bind(this);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                clearView();
                if (presenter != null) {
                    presenter.preparePolyjuice();
                }
            }
        });
    }

    private void clearView() {
        oneOne.setVisibility(View.GONE);
        oneTwo.setVisibility(View.GONE);
        twoOne.setVisibility(View.GONE);
        twoTwo.setVisibility(View.GONE);
        three.setVisibility(View.GONE);
    }

    @Override
    public void showFluxWeed(ZipData zipData) {
        if (zipData.isFluxWeedFirst()) {
            oneOne.setVisibility(View.VISIBLE);
            oneTwo.setVisibility(View.GONE);
        } else {
            oneTwo.setVisibility(View.VISIBLE);
            oneOne.setVisibility(View.GONE);
        }
    }


    @Override
    public void showCrabHair(ZipData zipData) {
        if (zipData.isCrabHairFirst()) {
            twoOne.setVisibility(View.VISIBLE);
            twoTwo.setVisibility(View.GONE);
        } else {
            twoTwo.setVisibility(View.VISIBLE);
            twoOne.setVisibility(View.GONE);
        }
    }

    @Override
    public void showPolyJuice(ZipData zipData) {
        refreshLayout.setRefreshing(false);
        refreshLayout.setEnabled(true);
        three.setVisibility(View.VISIBLE);
    }
}
