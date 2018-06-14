package com.example.wxj.e_application;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.wxj.e_application.fragement.IndexFragment;
import com.example.wxj.e_application.fragement.MeFragment;
import com.example.wxj.e_application.fragement.MessageFragment;
import com.example.wxj.e_application.fragement.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar
        .OnTabSelectedListener, ViewPager.OnPageChangeListener {
    private BottomNavigationBar mBottomNavigationBar;
    private ViewPager mViewPager;
    private List<Fragment> mFragements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }


    private void initData() {
        mFragements = new ArrayList<>();
        mFragements.add(new IndexFragment());
        mFragements.add(new VideoFragment());
        mFragements.add(new MessageFragment());
        mFragements.add(new MeFragment());

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_index_select, "主页"))
                .addItem(new BottomNavigationItem(R.drawable.nav_video_select, "视频"))
                .addItem(new BottomNavigationItem(R.drawable.nav_message_select, "消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_select, "我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();

        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mBottomNavigationBar.setTabSelectedListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        mViewPager.setCurrentItem(position);

    }

    @Override
    public void onTabUnselected(int position) {


    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mBottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void initView() {
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.btm_nav_bar);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
    }


    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragements.get(position);
        }

        @Override
        public int getCount() {
            return mFragements.size();
        }
    }
}
