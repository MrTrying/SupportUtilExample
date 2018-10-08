package com.mrtrying.supportutil.example.diffutil;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mrtrying.supportutil.example.R;
import com.mrtrying.supportutil.example.common.MeiZhiData;

import java.util.List;

/**
 * Description :
 * PackageName : com.mrtrying.supportutil.example.diffutil
 * Created by tanzeyu on 2018/10/4 09:26.
 * e_mail : ztanzeyu@gmail.com
 */
public class DiffAdapter extends RecyclerView.Adapter<DiffAdapter.DiffViewHolder> {
    private List<MeiZhiData> mMeiZhiDataList;

    @NonNull
    @Override
    public DiffViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_diff, viewGroup, false);
        return new DiffViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DiffViewHolder diffViewHolder, int i) {
        if (mMeiZhiDataList != null) {
            MeiZhiData data = mMeiZhiDataList.get(i);
            diffViewHolder.mTextView.setText(data.who);
            RequestOptions options = new RequestOptions().dontAnimate();
            Glide.with(diffViewHolder.mImageView)
                    .applyDefaultRequestOptions(options)
                    .load(data.image)
                    .into(diffViewHolder.mImageView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull DiffViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (payloads == null || payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return mMeiZhiDataList != null ? mMeiZhiDataList.size() : 0;
    }

    public void setMeiZhiDataList(List<MeiZhiData> meiZhiDataList) {
        mMeiZhiDataList = meiZhiDataList;
    }

    public List<MeiZhiData> getMeiZhiDataList() {
        return mMeiZhiDataList;
    }

    class DiffViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;

        public DiffViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image);
            mTextView = itemView.findViewById(R.id.text);
        }
    }
}
