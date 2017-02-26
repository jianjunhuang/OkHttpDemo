package com.library.jianjunhuang.okhttputils.okhttputils.request;

import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/8.
 */

public class PostRequest extends OkHttpRequest<PostRequest> {

  public PostRequest(String url, Map<String, String> params, Map<String, String> headers) {
    super(url, params, headers);
  }

  @Override protected RequestBody buildRequestBody() {
    RequestBody requestBody;
    FormBody.Builder builder = new FormBody.Builder();
    StringBuffer sb = new StringBuffer();

    for (Map.Entry<String, String> entry : params.entrySet()) {
      //builder.add(entry.getKey(),entry.getValue());
      sb.append(entry.getKey() + "=" + entry.getValue() + "&");
    }

    //requestBody = builder.build();
    requestBody =
        RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"),
            sb.toString());
    return requestBody;
  }

  @Override protected Request buildRequest(RequestBody requestBody, Request.Builder builder) {
    return builder.post(requestBody).build();
  }
}
