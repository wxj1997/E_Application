package com.example.wxj.e_application.net;

import com.example.wxj.e_application.bean.News;
import com.example.wxj.e_application.bean.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;



public interface ApiService {
    @GET("getNews.php")
    Call<HttpResult<List<News>>> getNews();
    @GET("getVideo.php")
    Call<HttpResult<List<Video>>> getVideo();
}
