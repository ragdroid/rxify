package com.ragdroid.rxify.core.list;

import android.view.View;
import android.widget.TextView;

import com.fueled.reclaim.BaseItem;
import com.fueled.reclaim.BaseViewHolder;
import com.fueled.reclaim.ItemPresenterProvider;
import com.ragdroid.rxify.R;
import com.ragdroid.rxify.core.ItemType;
import com.ragdroid.rxify.entity.Book;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by garimajain on 04/12/16.
 */

public class BookItem extends BaseItem<Book, Void, BookItem.ViewHolder> {

    public BookItem(Book data, ItemPresenterProvider<Void> itemHandlerProvider) {
        super(data, itemHandlerProvider);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_library;
    }

    @Override
    public ViewHolder onCreateViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void updateItemViews() {
        ViewHolder viewHolder = getViewHolder();
        Book book = getItemData();
        viewHolder.bookName.setText(book.name);
    }

    @Override
    public Enum<ItemType> getType() {
        return ItemType.CODELAB;
    }

    static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.lib_book_name) TextView bookName;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
