package com.library.jianjunhuang.okhttputils.okhttputils.callback;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/22.
 */

public abstract class JSONCallback extends ResultCallback {
  public abstract void onError(Call call, IOException e);

  @Override public void onResponse(Response response) throws IOException, JSONException {
    JSONObject jsonObject = new JSONObject(response.body().string());
    onJSON(jsonObject);
  }

  public abstract void onJSON(JSONObject jsonObject);
}
