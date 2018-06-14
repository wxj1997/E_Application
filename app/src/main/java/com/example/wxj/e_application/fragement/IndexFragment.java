package com.example.wxj.e_application.fragement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wxj.e_application.R;
import com.example.wxj.e_application.adapter.NewsAdapter;
import com.example.wxj.e_application.bean.News;
import com.example.wxj.e_application.loder.BannerImageLoder;
import com.example.wxj.e_application.net.HttpResult;
import com.example.wxj.e_application.net.RetrofitUtil;
import com.example.wxj.e_application.util.Const;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {
    private View mView;
    private Banner mBanner;
    private List<String> mBannerImageUrl;
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private List<News> mNews;

    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_index, container, false);
        initView();
        init();
        return mView;
    }

    private void init() {
        mBannerImageUrl = new ArrayList<>();
        mBannerImageUrl.add(Const.BANNER_IMAGE_URL1);
        mBannerImageUrl.add(Const.BANNER_IMAGE_URL2);
        mBannerImageUrl.add(Const.BANNER_IMAGE_URL3);
        mBanner.setImageLoader(new BannerImageLoder())
                .setImages(mBannerImageUrl)
                .start();

        mNews = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter = new NewsAdapter(R.layout.item_view_news, mNews);
        recyclerView.setAdapter(newsAdapter);

        RetrofitUtil.getNewsByRetrofit(new Callback<HttpResult<List<News>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<News>>> call, Response<HttpResult<List
                                <News>>> response) {
                newsAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<News>>> call, Throwable t) {

            }
        });

    }


    private void initView() {
        mBanner = (Banner) mView.findViewById(R.id.banner);
        recyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);
    }

}
