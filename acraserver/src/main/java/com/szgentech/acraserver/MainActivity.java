package com.szgentech.acraserver;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 使用ACRA框架，自定义发送器进行发送，发送至后台服务器
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 产生一个bug
     */
    private Button mSendBug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSendBug =  findViewById(R.id.send_bug);
        mSendBug.setOnClickListener(this);
    }

    private String text = null;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.send_bug:
                text.toString();
                break;
        }
    }

}
