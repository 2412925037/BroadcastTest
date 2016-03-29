package com.example.admin.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * 这是所有活动的父类，用于管理活动管理器
 * Created by admin on 2016/3/29.
 */
public class BaseActivity extends Activity{
    private static final String TAG = "BaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG ,getClass().getSimpleName().toString());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivities(this);
    }
}
