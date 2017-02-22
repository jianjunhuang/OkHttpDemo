package com.library.jianjunhuang.okhttputils.okhttputils.builder;

import com.jianjunhuang.demo.okhttputils.okhttputils.request.PostRequest;
import com.jianjunhuang.demo.okhttputils.okhttputils.request.RequestCall;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/8.
 */

public class PostBuilder extends OkHttpRequestBuilder<PostBuilder> {

    @Override
    public PostBuilder params(String key, String value) {
        if(params == null){
            params = new LinkedHashMap<>();
        }
        params.put(key,value);
        return this;
    }

    @Override
    public PostBuilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    @Override
    public RequestCall build() {

        return new PostRequest(baseURL,params,headers).build();
    }
}
