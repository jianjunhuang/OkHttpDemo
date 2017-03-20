package com.library.jianjunhuang.okhttputils.okhttputils;

import android.os.Handler;
import com.library.jianjunhuang.okhttputils.okhttputils.builder.GetBuilder;
import com.library.jianjunhuang.okhttputils.okhttputils.builder.PostBuilder;
import com.library.jianjunhuang.okhttputils.okhttputils.callback.ResultCallback;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;

/**
 * @author jianjunhuang.me@foxmail.com
 * @since 2017/2/6.
 */

public class OkHttpUtils {
  private static OkHttpUtils mInstance;
  private OkHttpClient client;
  private Handler mHandler;
  //    private Platform platform;

  /**
   * 创建 OkHttpClient 对象
   */
  private OkHttpUtils(OkHttpClient client) {
    if (client == null) {
      client = new OkHttpClient();
    } else {
      this.client = client;
    }

    mHandler = new Handler();
    //        platform = Platform.get();
  }

  /**
   * 传入 OkHttpClient 对象,初始化 OkHttpUtils 对象
   */
  public static OkHttpUtils initUtils(OkHttpClient client) {
    if (mInstance == null) {
      synchronized (OkHttpUtils.class) {
        if (mInstance == null) {
          mInstance = new OkHttpUtils(client);
        }
      }
    }
    return mInstance;
  }

  /**
   * 获取 OkHttpUtils 对象实例
   */
  public static OkHttpUtils getInstance() {
    return initUtils(null);
  }

  /**
   * 获取 OkHttpClient 对象实例
   */
  public OkHttpClient getClientInstance() {
    return client;
  }

  //TODO setting client

  /**
   * 设置 OkHttpClient
   */
  public OkHttpUtils initOkHttpClient() {

    return initUtils(null);
  }

  public GetBuilder getAsy() {
    return new GetBuilder();
  }

  public PostBuilder postAsy() {
    return new PostBuilder();
  }

  public void execute(ResultCallback callback, Request request) {
    Call call = client.newCall(request);
    dealResult(call, callback);
  }

  private void dealResult(Call call, final ResultCallback callback) {
    call.enqueue(new Callback() {
      @Override public void onFailure(Call call, IOException e) {
        sendFailedCallback(call, callback, e);
      }

      @Override public void onResponse(Call call, Response response) throws IOException {
        sendSuccessCallback(response.body().string(), callback);
      }
    });
  }

  private void sendSuccessCallback(final String response, final ResultCallback callback) {
    mHandler.post(new Runnable() {
      @Override public void run() {
        if (callback != null) {
          try {
            callback.onResponse(response);
          } catch (IOException e) {
            e.printStackTrace();
          } catch (JSONException e) {
            e.printStackTrace();
          }
        }
      }
    });
  }

  private void sendFailedCallback(final Call call, final ResultCallback callback,
      final IOException e) {
    mHandler.post(new Runnable() {
      @Override public void run() {
        if (callback != null) {
          callback.onError(call, e);
        }
      }
    });
  }
}
