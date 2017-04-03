package com.ragdroid.rxify.codelab;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.ragdroid.rxify.BaseActivity;
import com.ragdroid.rxify.R;
import com.ragdroid.rxify.RxifyApplication;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;


public abstract class BaseCLActivity<T extends CodeLabContract.Presenter> extends BaseActivity<T>
        implements CodeLabContract.View {

    @BindView(R.id.cl_refresh) SwipeRefreshLayout refreshLayout;
    @BindView(R.id.cl_console) TextView consoleTv;
    @BindDimen(R.dimen.space_medium) int space;

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


    protected CodeLabContract.Presenter getCodeLabPresenter(int id) {
        BaseSchedulerProvider schedulerProvider =
                ((RxifyApplication) getApplication()).getAppComponent().getSchedulerProvider();
        switch (id) {
            case 0 :
                return activityModule.provideEmptyPresenter(schedulerProvider);
            case 1 :
                return activityModule.provideJustPresenter(schedulerProvider);
            case 2 :
                return activityModule.provideFromPresenter(schedulerProvider);
            case 3 :
                return activityModule.provideNeverPresenter(schedulerProvider);
            case 4 :
                return activityModule.provideIntervalPresenter(schedulerProvider);
            case 5 :
                return activityModule.provideErrorPresenter(schedulerProvider);
            case 6 :
                return activityModule.provideRangePresenter(schedulerProvider);
            case 7 :
                return activityModule.provideIntervalRangePresenter(schedulerProvider);
            case 8 :
                return activityModule.provideTimerPresenter(schedulerProvider);
            case 9 :
                return activityModule.provideFilterPresenter(schedulerProvider);
            case 10:
                return activityModule.provideDistinctPresenter(schedulerProvider);
            case 11:
                return activityModule.provideTakePresenter(schedulerProvider);
            case 12:
                return activityModule.provideTakeUntilPresenter(schedulerProvider);
            case 13:
                return activityModule.provideSkipPresenter(schedulerProvider);
            case 14:
                return activityModule.provideReducePresenter(schedulerProvider);
            case 15:
                return activityModule.provideMapPresenter(schedulerProvider);
            case 16:
                return activityModule.provideFlatMapPresenter(schedulerProvider);
            case 17:
                return activityModule.provideAssignmentPresenter(schedulerProvider);
            case 18:
                return activityModule.provideBattlePresenter(schedulerProvider);
            case 19:
                return activityModule.provideBattleFlowPresenter(schedulerProvider);
            case 20:
                return activityModule.provideThreadingPresenter(schedulerProvider);
            case 22:
                return activityModule.provideTimeTurnerPresenter(schedulerProvider);
            case 21:
            default:
                return activityModule.provideChillPresenter(schedulerProvider);
        }
    }

}
