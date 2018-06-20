package com.example.wxj.e_application.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wxj.e_application.R;
import com.example.wxj.e_application.bean.Video;

import java.util.List;

/**
 * Created by wxj on 2018/6/20.
 */

public class VideoAdapter extends BaseQuickAdapter<Video, BaseViewHolder> {

    public VideoAdapter(@LayoutRes int layoutResId, @Nullable List<Video> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Video item) {
        Glide.with(mContext).load(item.getVideoThumbUrl()).into((ImageView) helper.getView(R.id
                .video_thumb));
        helper.setText(R.id.tv_video_name,item.getName());
    }
}



