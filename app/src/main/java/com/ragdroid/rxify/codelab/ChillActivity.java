package com.ragdroid.rxify.codelab;

import android.os.Bundle;
import android.view.View;

import com.ragdroid.rxify.R;
import com.ragdroid.rxify.dagger.ActivityComponent;
import com.ragdroid.rxify.entity.CodeLabData;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillActivity extends BaseCLActivity<CodeLabContract.Presenter> implements CodeLabContract.View {

    public static final String CODELAB_ITEM_ID = "CODELAB_ITEM_ID";
    private int codeLabType;

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        presenter = initCodeLabTypePresenter();
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        super.setupActivity(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle(CodeLabData.getCodeLab(codeLabType).getName());
        toolbar.setNavigationIcon(R.drawable.ic_action_up);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private CodeLabContract.Presenter initCodeLabTypePresenter() {
        codeLabType = getIntent().getIntExtra(CODELAB_ITEM_ID, CodeLabData.CHILL.getId());
        return getCodeLabPresenter(codeLabType);
    }

}
