package com.example.admin.broadcastbestpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 这是一个登陆页面
 * Created by admin on 2016/3/29.
 */
public class LoginActivity extends Activity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        accountEdit =  (EditText)findViewById(R.id.account);
        passwordEdit = (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(account.equals("admin")&&password.equals("123456")){
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this,"请重新登陆",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
