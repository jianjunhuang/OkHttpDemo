package com.library.jianjunhuang.okhttputils.okhttputils.request;

import com.jianjunhuang.demo.okhttputils.okhttputils.callback.ResultCallback;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 *
 * 用于构建 Request 目前用到的东西较少 后期再增加 TODO
 *
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/7.
 */

public abstract class OkHttpRequest<T> {
    protected String url;
    protected Map<String,String> params;
    protected Map<String,String> headers;

    protected Request.Builder builder = new Request.Builder();

    protected OkHttpRequest(String url,Map<String,String>params,Map<String,String>headers){
        this.url = url;
        this.params = params;
        this.headers = headers;

        //init some params
        builder.url(url);
        appendHeaders();
    }

    protected abstract RequestBody buildRequestBody();

    protected abstract Request buildRequest(RequestBody requestBody,Request.Builder builder);

    public Request generateRequest(ResultCallback callback){
        RequestBody requestBody = buildRequestBody();
        RequestBody wrappedRequestBody = wrapRequestBody(requestBody,callback);
        return buildRequest(wrappedRequestBody,builder);
    }

    //把 requestbody 和 callback 绑定
    public RequestBody wrapRequestBody(RequestBody requestBody,final ResultCallback callback){
       return requestBody;
    }


    public RequestCall build(){
        return new RequestCall(this);
    }

    protected void appendHeaders(){
        Headers.Builder headerBuilder = new Headers.Builder();
        if(headers == null || headers.isEmpty()){
            return;
        }
        for(String key : headers.keySet()){
            headerBuilder.add(key,headers.get(key));
        }
        builder.headers(headerBuilder.build());
    }
}

