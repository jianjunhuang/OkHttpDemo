package com.demo.jianjunhuang.okhttpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.library.jianjunhuang.okhttputils.okhttputils.OkHttpUtils;
import com.library.jianjunhuang.okhttputils.okhttputils.callback.ResultCallback;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/1/29.
 */

public class SampleActivity extends AppCompatActivity implements View.OnClickListener {

    private Button asyget_btn;
    private Button asypost_btn;

    private final String GET_TEST_URL = "http://www.baidu.com";
    private final String POST_TEST_URL = "http://api.1-blog.com/biz/bizserver/article/list.do";
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

    private void initView(){
        asyget_btn = (Button)findViewById(R.id.asyget_btn);
        asypost_btn = (Button)findViewById(R.id.asypost_btn);
    }



    private void getAsy(String url) {
        OkHttpUtils.getInstance().getAsy()
                .baseURL(url)
                .build()
                .execute(new ResultCallback() {
                    @Override
                    public void onError(Call call, IOException e) {
                        Toast.makeText(SampleActivity.this, "err", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Response response) {
                        Toast.makeText(SampleActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void postAsy(String url) {
        OkHttpUtils.getInstance().postAsy()
                .baseURL(url)
                .params("size", "10")
                .build()
                .execute(new ResultCallback() {
                    @Override
                    public void onError(Call call, IOException e) {
                        Toast.makeText(SampleActivity.this, "err", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Response response) {
                        Toast.makeText(SampleActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.asyget_btn:
                getAsy(GET_TEST_URL);
                break;
            case R.id.asypost_btn:
                postAsy(POST_TEST_URL);
                break;
        }
    }
}
