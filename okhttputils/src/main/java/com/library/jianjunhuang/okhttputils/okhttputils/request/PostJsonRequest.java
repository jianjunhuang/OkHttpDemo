package com.library.jianjunhuang.okhttputils.okhttputils.request;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/3/20.
 */

public class PostJsonRequest extends OkHttpRequest<PostJsonRequest> {
  private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

  public PostJsonRequest(String url, Map<String, String> params, Map<String, String> headers) {
    super(url, params, headers);
  }

  @Override protected RequestBody buildRequestBody() {
    Gson gson = new Gson();
    RequestBody body = RequestBody.create(JSON, gson.toJson(params));
    return body;
  }

  @Override protected Request buildRequest(RequestBody requestBody, Builder builder) {
    return builder.post(requestBody).build();
  }
}
