package com.ragdroid.rxify.codelab;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.ragdroid.rxify.BaseActivity;
import com.ragdroid.rxify.R;
import com.ragdroid.rxify.RxifyApplication;
import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.entity.CodeLabData;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Lazy;


public abstract class BaseCLActivity<T extends CodeLabContract.Presenter> extends BaseActivity<T>
        implements CodeLabContract.View {

    @BindView(R.id.cl_refresh) SwipeRefreshLayout refreshLayout;
    @BindView(R.id.cl_console) TextView consoleTv;
    @BindDimen(R.dimen.space_medium) int space;

    @Inject Map<CodeLabData, Provider<CodeLabContract.Presenter>> presentersMap;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_codelab;
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
        refreshLayout.setProgressViewOffset(true, space, space + 100);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                clearView();
                if (presenter != null) {
                    presenter.prepare();
                }
            }
        });
    }

    protected void clearView() {
        consoleTv.setText("");
    }

    @Override
    public void append(String text) {
        refreshLayout.setRefreshing(false);
        refreshLayout.setEnabled(true);
        consoleTv.append(text);
        consoleTv.append("\n");
    }


    protected CodeLabContract.Presenter getCodeLabPresenter(CodeLabData codeLabData) {
        return presentersMap.get(codeLabData).get();

    }
}

