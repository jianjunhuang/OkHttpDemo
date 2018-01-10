package com.demo.jianjunhuang.okhttpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.library.jianjunhuang.okhttputils.okhttputils.OkHttpUtils;
import com.library.jianjunhuang.okhttputils.okhttputils.callback.JSONCallback;
import com.library.jianjunhuang.okhttputils.okhttputils.callback.ResultCallback;
import com.library.jianjunhuang.okhttputils.okhttputils.https.HttpCode;

import java.io.IOException;

import okhttp3.Call;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/1/29.
 */

public class SampleActivity extends AppCompatActivity implements View.OnClickListener {

    private Button asyget_btn;
    private Button asypost_btn;

    private final String GET_TEST_URL = "http://120.79.40.25:81/index.jsp";
    //            "http://508cst.gcu.edu.cn:8080/tentcooTools/api/v1/auth/check_network";
    private final String POST_TEST_URL = "http://192.168.1.122:8080/Addressbook/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);
        initView();
        initEvent();
    }

    private void initEvent() {
        asyget_btn.setOnClickListener(this);
        asypost_btn.setOnClickListener(this);
    }

    private void initView() {
        asyget_btn = (Button) findViewById(R.id.asyget_btn);
        asypost_btn = (Button) findViewById(R.id.asypost_btn);
    }

    private void getAsy(String url) {
        OkHttpUtils.getInstance().getAsy().baseURL(url).build().execute(new ResultCallback() {
            @Override
            public void onError(Call call, int code, Exception e) {
                Toast.makeText(SampleActivity.this, e.getMessage() + " " + HttpCode.getCodeExp(code), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response, int code) throws IOException, JSONException {
                Toast.makeText(SampleActivity.this, response + " code = " + code + " " + HttpCode.getCodeExp(code), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static final String TAG = "SampleActivity";

    private void postAsy(String url) {
        OkHttpUtils.getInstance()
                .postJsonAsy()
                .baseURL(url)
                .params("userName", "TestAcoount")
                .params("userPassword", "123456")
                .build()
                .execute(new ResultCallback() {
                    @Override
                    public void onError(Call call, int code, Exception e) {
                        Log.i(TAG, "onError: " + e.getMessage() + " " + code);
                    }

                    @Override
                    public void onResponse(String response, int code) throws IOException, JSONException {
                        Log.i(TAG, "onResponse: " + response);
                    }
                });
//                .execute(new JSONCallback() {
//                    @Override
//                    public void onError(Call call, int code, Exception e) {
//                        Log.e("tag", e.getMessage());
//                        Toast.makeText(SampleActivity.this, e.getMessage() + " err code = " + code + " " + HttpCode.getCodeExp(code), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onJSON(JSONObject jsonObject, int code) {
//                        Log.w("tag", jsonObject.toString());
//                        Toast.makeText(SampleActivity.this, jsonObject.toString() + " code = " + code + " " + HttpCode.getCodeExp(code), Toast.LENGTH_SHORT).show();
//                    }
//                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.asyget_btn:
                getAsy(GET_TEST_URL);
                break;
            case R.id.asypost_btn:
                postAsy(POST_TEST_URL);
                break;
        }
    }
}
