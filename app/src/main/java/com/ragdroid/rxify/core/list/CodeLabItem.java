package com.ragdroid.rxify.core.list;

import android.view.View;
import android.widget.TextView;

import com.fueled.reclaim.BaseItem;
import com.fueled.reclaim.BaseViewHolder;
import com.fueled.reclaim.ItemPresenterProvider;
import com.ragdroid.rxify.R;
import com.ragdroid.rxify.core.ItemType;
import com.ragdroid.rxify.core.codelab.CodeLabItemHandler;
import com.ragdroid.rxify.entity.CodeLabData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by garimajain on 18/03/17.
 */

public class CodeLabItem extends BaseItem<CodeLabData, CodeLabItemHandler, CodeLabItem.ViewHolder> {
    public CodeLabItem(CodeLabData data, ItemPresenterProvider<CodeLabItemHandler> itemHandlerProvider) {
        super(data, itemHandlerProvider);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_codelab;
    }

    @Override
    public CodeLabItem.ViewHolder onCreateViewHolder(View view) {
        return new CodeLabItem.ViewHolder(view);
    }

    @Override
    public void updateItemViews() {
        CodeLabItem.ViewHolder viewHolder = getViewHolder();
        CodeLabData book = getItemData();
        viewHolder.name.setText(book.getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItemHandler() != null) {
                    getItemHandler().onItemClicked(getItemData());
                }
            }
        });
    }

    @Override
    public Enum<ItemType> getType() {
        return ItemType.BOOK;
    }

    static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.codelab_name) TextView name;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
