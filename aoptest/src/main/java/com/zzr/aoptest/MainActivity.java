package com.zzr.aoptest;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.zzr.aoptest.aop.StatisticsTrace;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @StatisticsTrace(value = "opreat1")
    public void opreat1(View view) {
        SystemClock.sleep(1000);
        Log.e("aop--->", "opreat1  ...........");
    }

    @StatisticsTrace(value = "opreat2")
    public void opreat2(View view) {
        SystemClock.sleep(1000);
        Log.e("aop--->", "opreat2  ...........");
    }

    @StatisticsTrace(value = "opreat3")
    public void opreat3(View view) {
        SystemClock.sleep(1000);
        Log.e("aop--->", "opreat3  ...........");
    }
}
