package com.library.jianjunhuang.okhttputils.okhttputils.builder;

import com.library.jianjunhuang.okhttputils.okhttputils.request.PostJsonRequest;
import com.library.jianjunhuang.okhttputils.okhttputils.request.RequestCall;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/3/20.
 */

public class PostJsonBuilder extends OkHttpRequestBuilder<PostJsonBuilder> {
  @Override public PostJsonBuilder params(String key, String value) {
    if(params == null){
      params = new LinkedHashMap<>();
    }
    params.put(key,value);
    return this;
  }

  @Override public PostJsonBuilder params(Map<String, String> params) {
    this.params = params;
    return this;
  }

  @Override public RequestCall build() {
    return new PostJsonRequest(baseURL,params,headers).build();
  }
}
