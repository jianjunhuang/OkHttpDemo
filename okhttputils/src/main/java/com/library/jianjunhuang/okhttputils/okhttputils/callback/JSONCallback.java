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
  public abstract void onError(Call call, Exception e);

  @Override public void onResponse(String response) throws IOException {
    JSONObject jsonObject = null;
    try {
      jsonObject = new JSONObject(response);
      onJSON(jsonObject);
    } catch (JSONException e) {
      e.printStackTrace();
      onError(null, e);
    }
  }

  public abstract void onJSON(JSONObject jsonObject);
}
