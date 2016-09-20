package com.example.administrator.myapplication;

import android.app.ActivityManager;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
   private ViewPager viewPager;
   private MyFragmentPagerAdapter adapter;
   private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Fragment+ViewPager+FragmentViewPager组合的使用
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),
                this);
        viewPager.setAdapter(adapter);

        //TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
