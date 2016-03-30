package com.example.admin.broadcastbestpractice;

/**
 * Created by admin on 2016/3/30.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HttpActivity extends Activity {
    private final String TAG = "MainActivity";
    private TextView textView;
    private Button button;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });
        new Thread(mRunnable).start();
    }

    //刷新网页显示
    private void refresh() {
        String httpUrl = "http://127.0.0.1:8080/test/currentDate.jsp";
        String result = "";
        URL url = null;
        try {
            //构造一个URL对象
            url = new URL(httpUrl);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException");
            e.printStackTrace();
        }
        if (url != null) {
            try {
                //使用httpURLConnection打开连接
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                //得到读取的内容
                InputStreamReader inReader = new InputStreamReader(urlConnection.getInputStream());
                //为输出创建BufferedReader
                BufferedReader bufferedReader = new BufferedReader(inReader);
                String line = null;
                //使用循环来读取获得的数据
                while ((line = bufferedReader.readLine()) != null) {
                    result += line + "\n";
                }
                //关闭InputStreamReader
                inReader.close();
                //关闭Http连接
                urlConnection.disconnect();
                if (result.equals("")) {
                    textView.setText("读取的内容为null");
                } else {
                    textView.setText(result);
                }
            } catch (IOException e) {
                // TODO: handle exception
                Log.e(TAG, "IOException");
                e.printStackTrace();
            }
        } else {
            Log.e(TAG, "url null");
        }
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5 * 1000);
                    //发送消息
                    handler.sendMessage(handler.obtainMessage());
                } catch (InterruptedException e) {
                    // TODO: handle exception
                    Log.e(TAG, "InterruptedException");
                    e.printStackTrace();
                }
            }
        }
    };

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            refresh();
        }
    };
}