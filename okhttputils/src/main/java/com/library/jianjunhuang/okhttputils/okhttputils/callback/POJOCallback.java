package com.library.jianjunhuang.okhttputils.okhttputils.callback;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Response;

import org.json.JSONException;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/22.
 */

public abstract class POJOCallback<T> extends ResultCallback {

    private Class<T> clazz;

    public POJOCallback(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void onResponse(String response, int code) {
        try {
            Gson gson = new Gson();
            T bean = gson.fromJson(response, clazz);
            onPOJO(bean, code);
        } catch (Exception e) {
            onError(null, code, e);
        }
    }

    public abstract void onPOJO(T bean, int code);
}
