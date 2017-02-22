package com.library.jianjunhuang.okhttputils.okhttputils.request;

import java.util.Map;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/8.
 */

public class PostRequest extends OkHttpRequest<PostRequest>{


    public PostRequest(String url, Map<String, String> params,Map<String,String> headers) {
        super(url, params,headers);
    }

    @Override
    protected RequestBody buildRequestBody() {
        RequestBody requestBody ;
        FormBody.Builder builder = new FormBody.Builder();
        for(Map.Entry<String,String> entry : params.entrySet()){
            builder.add(entry.getKey(),entry.getValue());
        }
        requestBody = builder.build();
        return requestBody;
    }

    @Override
    protected Request buildRequest(RequestBody requestBody,Request.Builder builder) {
        return builder.post(requestBody).build();
    }
}
