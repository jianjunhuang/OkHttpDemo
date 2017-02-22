package com.library.jianjunhuang.okhttputils.okhttputils.builder;

import com.jianjunhuang.demo.okhttputils.okhttputils.request.RequestCall;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/6.
 */

public abstract class OkHttpRequestBuilder<T extends OkHttpRequestBuilder> {
    protected String baseURL;
    protected Map<String,String> params;
    protected Map<String,String> headers;

    public T baseURL(String baseURL){
        this.baseURL = baseURL;
        return (T)this;
    }

    public T headers(Map<String,String> headers){
        this.headers = headers;
        return (T)this;
    }

    public T header(String key , String value){
        if(this.headers == null){
            headers = new LinkedHashMap<>();
        }
        headers.put(key,value);
        return (T)this;
    }

    public abstract T params(String key,String value);

    public abstract T params(Map<String,String> params);

    public abstract RequestCall build();

    protected String encode(String value){
        try {
            return URLEncoder.encode(value,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String decode(String value){
        try {
            return URLDecoder.decode(value,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
