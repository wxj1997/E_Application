package com.example.wxj.e_application.fragement;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wxj.e_application.R;
import com.example.wxj.e_application.activity.VideoActivity;
import com.example.wxj.e_application.adapter.VideoAdapter;
import com.example.wxj.e_application.bean.Video;
import com.example.wxj.e_application.net.HttpResult;
import com.example.wxj.e_application.net.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements BaseQuickAdapter.OnItemClickListener{
    private View mView;
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private List<Video> mVideos;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_video, container, false);
        initView();
        init();
        return mView;
    }

    private void init() {
        mVideos = new ArrayList<>();
        videoAdapter = new VideoAdapter(R.layout.item_view_video, mVideos);

        RetrofitUtil.getVideoByRetrofit(new Callback<HttpResult<List<Video>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<Video>>> call, Response<HttpResult<List
                    <Video>>> response) {
                videoAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<Video>>> call, Throwable t) {

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(videoAdapter);

        videoAdapter.setOnItemClickListener(this);



    }

    private void initView() {
        recyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Video video= (Video)adapter.getItem(position);
        Intent intent=new Intent(getActivity(),VideoActivity.class);
        intent.putExtra("Video_Name",video.getName());
        intent.putExtra("Video_Url",video.getUrl());
        startActivity(intent);
    }
}
