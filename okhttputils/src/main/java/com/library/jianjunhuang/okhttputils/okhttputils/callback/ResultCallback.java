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
    public abstract void onError(Call call, IOException e);

    public abstract void onResponse(String response) throws IOException, JSONException;
}
