package com.library.jianjunhuang.okhttputils.okhttputils.request;

import com.jianjunhuang.demo.okhttputils.okhttputils.OkHttpUtils;
import com.jianjunhuang.demo.okhttputils.okhttputils.callback.ResultCallback;
import okhttp3.Call;
import okhttp3.Request;

/**
 * 对 OkHttpRequest 的封装 对外提供更多接口
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/7.
 */

public class RequestCall {

    private OkHttpRequest okHttpRequest;
    private Call call;
    private Request request;

    public RequestCall(OkHttpRequest okHttpRequest){
        this.okHttpRequest = okHttpRequest;
    }

    public Call buildCall(ResultCallback callback){
        request = generateRequest(callback);
        call = OkHttpUtils.getInstance().getClientInstance().newCall(request);
        return call;
    }


    private Request generateRequest(ResultCallback callback){
        return okHttpRequest.generateRequest(callback);
    }


    public void execute(ResultCallback callback){
        buildCall(callback);
        if(callback != null){
            OkHttpUtils.getInstance().execute(callback,request);
        }
    }
}
