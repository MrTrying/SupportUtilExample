package com.mrtrying.supportutil.example.diffutil;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;
import java.util.Objects;

/**
 * Description :
 * PackageName : com.mrtrying.supportutil.example.diffutil
 * Created by tanzeyu on 2018/9/30 17:16.
 * e_mail : ztanzeyu@gmail.com
 */
public class ItemDiffCallback<T> extends DiffUtil.Callback {

    private List<T> oldDataList,newDataList;

    public ItemDiffCallback(List<T> oldDataList,List<T> newDataList){
        this.oldDataList = oldDataList;
        this.newDataList = newDataList;
    }

    @Override
    public int getOldListSize() {
        return oldDataList != null ? oldDataList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newDataList != null ? newDataList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldDataList != null && newDataList != null
                && oldDataList.get(oldItemPosition) != null
                && oldDataList.get(oldItemPosition).equals(newDataList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldDataList != null && newDataList != null
                && oldDataList.get(oldItemPosition) != null
                && oldDataList.get(oldItemPosition).equals(newDataList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return null;
    }
}
