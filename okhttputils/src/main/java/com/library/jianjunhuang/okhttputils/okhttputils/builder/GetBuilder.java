package com.library.jianjunhuang.okhttputils.okhttputils.builder;

import android.net.Uri;
import com.jianjunhuang.demo.okhttputils.okhttputils.request.GetRequest;
import com.jianjunhuang.demo.okhttputils.okhttputils.request.RequestCall;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/7.
 */

public class GetBuilder extends OkHttpRequestBuilder<GetBuilder>{

    @Override
    public GetBuilder params(String key, String value) {
        if(this.params == null){
            params = new LinkedHashMap<>();
        }
        params.put(key,value);
        return this;
    }

    @Override
    public GetBuilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    @Override
    public RequestCall build() {

        if(params != null){
            baseURL = appendParams(baseURL,params);
        }

        return new GetRequest(baseURL,params,headers).build();
    }

    /**
     * 生成完整的 url
     * @param url
     * @param params
     * @return
     */
    private String appendParams(String url, Map<String,String> params){

        if(url == null || params == null || params.isEmpty()
                ){
            return url;
        }
        Uri.Builder builder = Uri.parse(url).buildUpon();
        for(Map.Entry<String,String> entry : params.entrySet()){
            builder.appendQueryParameter(entry.getKey(),encode(entry.getValue()));
        }

        return builder.build().toString();
    }

}
