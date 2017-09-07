package com.library.jianjunhuang.okhttputils.okhttputils.callback;

import java.io.IOException;

import okhttp3.Call;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/22.
 */

public abstract class JSONCallback extends ResultCallback {

    @Override
    public void onResponse(String response, int code) throws IOException {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);
            onJSON(jsonObject, code);
        } catch (JSONException e) {
            e.printStackTrace();
            onError(null, code, e);
        }
    }

    public abstract void onJSON(JSONObject jsonObject, int code);
}
