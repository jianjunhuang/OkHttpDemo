package com.demo.jianjunhuang.okhttpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/1/29.
 */

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView show_tv;
    private Button get_btn;
    private Button post_btn;

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final String GET_TEST_URL = "http://www.baidu.com";
    private final String POST_TEST_URL = "http://api.1-blog.com/biz/bizserver/article/list.do";
    //create a OkHttpClient object
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        initView();
        initEvent();
    }

    /**
     * GET
     *
     * @param url
     */
    private void get(String url) {

        //create a request
        final Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("tag", "--headers-->" + response.headers().toString());
                Log.i("tag", "--body-->" + response.body().string());
                final String result = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result != null) {
                            show_tv.setText(result);
                        }
                    }
                });
            }
        });

    }

    /**
     * POST
     *
     * @param url
     */
    private void post(String url) {
        RequestBody formBody = new FormBody.Builder()
                .add("size", "10")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        show_tv.setText(result);
                    }
                });
            }
        });

    }

    private void initView() {
        show_tv = (TextView) findViewById(R.id.show_tv);
        get_btn = (Button) findViewById(R.id.get_btn);
        post_btn = (Button) findViewById(R.id.post_btn);
    }

    private void initEvent() {
        get_btn.setOnClickListener(this);
        post_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_btn:
                get(GET_TEST_URL);
                break;
            case R.id.post_btn:
                post(POST_TEST_URL);
                break;
            default:

                break;
        }
    }
}
