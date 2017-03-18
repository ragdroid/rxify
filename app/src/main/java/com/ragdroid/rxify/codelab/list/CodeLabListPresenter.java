package com.ragdroid.rxify.codelab.list;

import com.ragdroid.rxify.core.BaseSchedulerProvider;
import com.ragdroid.rxify.core.codelab.CodeLabItemHandler;
import com.ragdroid.rxify.entity.CodeLabData;
import com.ragdroid.rxify.logic.mvp.AbstractPresenter;

import java.util.Arrays;
import java.util.List;


/**
 * Created by garimajain on 18/03/17.
 */

public class CodeLabListPresenter extends AbstractPresenter<CodeLabListContract.View> implements
        CodeLabListContract.Presenter, CodeLabItemHandler {


    private List<CodeLabData> arrayList;

    public CodeLabListPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    public void subscribe() {
        //we do not have anything to subscribe, we will just init the list
        if (arrayList == null) {
            CodeLabData[] values = CodeLabData.values();
            arrayList = Arrays.asList(values);
            if (getView() != null) {
                getView().setDataList(arrayList);
            }
        }
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void onItemClicked(CodeLabData data) {
        if (getView() != null) {
            getView().showCodeLab(data.getId());
        }
    }

}
