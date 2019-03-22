package com.ragdroid.rxify.codelab.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fueled.reclaim.ItemPresenterProvider;
import com.fueled.reclaim.ItemsViewAdapter;
import com.ragdroid.rxify.BaseActivity;
import com.ragdroid.rxify.R;
import com.ragdroid.rxify.codelab.ChillActivity;
import com.ragdroid.rxify.core.codelab.CodeLabItemHandler;
import com.ragdroid.rxify.core.list.CodeLabItem;
import com.ragdroid.rxify.dagger.ActivityComponent;
import com.ragdroid.rxify.entity.CodeLabData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by garimajain on 18/03/17.
 */

public class CodeLabListActivity extends BaseActivity<CodeLabListPresenter> implements CodeLabListContract.View,
        ItemPresenterProvider<CodeLabItemHandler> {


    @BindView(R.id.codelab_list) RecyclerView codeLabList;
    private ItemsViewAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_codelab_list;
    }



    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        codeLabList.setLayoutManager(layoutManager);
        adapter = new ItemsViewAdapter(this);
        DividerItemDecoration decor = new DividerItemDecoration(this, layoutManager.getOrientation());
        codeLabList.addItemDecoration(decor);
        codeLabList.setAdapter(adapter);
    }


    @Override
    public void setDataList(List<CodeLabData> arrayList) {
        ArrayList<CodeLabItem> codeLabItems = new ArrayList<>();
        for (CodeLabData data : arrayList) {
            CodeLabItem codeLabItem = new CodeLabItem(data, this);
            codeLabItems.add(codeLabItem);
        }
        adapter.addItemsList(codeLabItems);
    }

    @Override
    public void showCodeLab(int itemId) {
        Intent intent = new Intent(this, ChillActivity.class);
        intent.putExtra(ChillActivity.CODELAB_ITEM_ID, itemId);
        startActivity(intent);
    }

    @Override
    public CodeLabItemHandler getItemPresenter() {
        return presenter;
    }
}
