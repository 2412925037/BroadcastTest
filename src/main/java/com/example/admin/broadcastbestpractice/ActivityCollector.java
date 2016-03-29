package com.example.admin.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个活动管理器
 * Created by admin on 2016/3/29.
 */
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivities(Activity activity){
        activities.remove(activity);
    }
    public static void finishAllActivities(){
        for(Activity activity : activities){
            if (!activity.isFinishing())
            activity.finish();
        }
    }
}
