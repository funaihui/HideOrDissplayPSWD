package com.wizardev.hideordissplaypswd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;
import static android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;

public class MainActivity extends AppCompatActivity {
    private ImageView img_eye;
    private boolean paswdVisible = false;
    private EditText mPassWd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        //点击眼睛的事件
        clickImgEye();
    }

    private void clickImgEye() {
        img_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paswdVisible = !paswdVisible;
                whetherShowPas(paswdVisible);
            }
        });
    }

    //根据图标判断是否显示密码
    private void whetherShowPas(boolean paswdVisible) {
        if (paswdVisible) {
            //设置密码为显示的状态
            mPassWd.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            img_eye.setImageResource(R.mipmap.dis);
        } else {
            //设置密码为隐藏的状态
            mPassWd.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PASSWORD);
            img_eye.setImageResource(R.mipmap.hid);

        }
        mPassWd.setSelection(mPassWd.getText().length());//将光标定位到最后
    }

    private void initView() {
        img_eye = (ImageView) findViewById(R.id.img_eye);
        mPassWd = (EditText) findViewById(R.id.paswd_register);
        whetherShowPas(paswdVisible);
    }
}
