package com.library.jianjunhuang.okhttputils.okhttputils.callback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

import org.json.JSONException;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/7.
 */

public abstract class ResultCallback<T> {
    public abstract void onError(Call call, int code, Exception e);

    public abstract void onResponse(String response, int code) throws IOException, JSONException;
}
