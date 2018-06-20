package com.example.wxj.e_application.net;


import com.example.wxj.e_application.bean.News;
import com.example.wxj.e_application.bean.Video;
import com.example.wxj.e_application.util.Const;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    public static void getNewsByRetrofit(Callback<HttpResult<List<News>>> callback) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Const.BASE_URL).addConverterFactory
                (GsonConverterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<HttpResult<List<News>>> call = apiService.getNews();
        call.enqueue(callback);
    }

    public static void getVideoByRetrofit(Callback<HttpResult<List<Video>>> callback) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Const.BASE_URL).addConverterFactory
                (GsonConverterFactory.create()).build();
        ApiService apiService=retrofit.create(ApiService.class);
        Call<HttpResult<List<Video>>> call=apiService.getVideo();
        call.enqueue(callback);

    }
}
