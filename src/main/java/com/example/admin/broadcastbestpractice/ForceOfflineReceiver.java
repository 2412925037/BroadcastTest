package com.example.admin.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by admin on 2016/3/29.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Wra");
        builder.setCancelable(false);
        builder.setMessage("you are forced to offline ,please try again");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAllActivities();
                Intent intent = new Intent(context, LoginActivity.class);
                //设置intent，表示启动一个新的栈，否则无法从广播到活动
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        AlertDialog dialog = builder.create();
        //设置dialog的类型，否则无法再广播接收器中弹出
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
    }
}
