package com.example.wxj.e_application.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.wxj.e_application.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity {
    private JZVideoPlayerStandard mJZVideoPlayerStandard;
    private String videoName, videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        init();
    }

    private void init() {
        Intent intent = getIntent();
        videoName = intent.getStringExtra("Video_Name");
        videoUrl = intent.getStringExtra("Video_Url");
        mJZVideoPlayerStandard.setUp(videoUrl, JZVideoPlayer.SCREEN_WINDOW_NORMAL,videoName);
    }

    private void initView() {
        mJZVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.player_video);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (JZVideoPlayer.backPress()) {
            return;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
