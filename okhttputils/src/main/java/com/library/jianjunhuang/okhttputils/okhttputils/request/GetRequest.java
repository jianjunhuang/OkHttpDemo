package com.library.jianjunhuang.okhttputils.okhttputils.request;

import java.util.Map;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/7.
 */

public class GetRequest extends OkHttpRequest<GetRequest> {

    public GetRequest(String url, Map<String, String> params,Map<String,String> headers) {
        super(url, params,headers);
    }

    @Override
    protected RequestBody buildRequestBody() {
        return null;
    }

    @Override
    protected Request buildRequest(RequestBody requestBody,Request.Builder builder) {
        return builder.get().build();
    }
}
