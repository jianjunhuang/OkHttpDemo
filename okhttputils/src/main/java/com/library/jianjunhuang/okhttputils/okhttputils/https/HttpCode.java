package com.library.jianjunhuang.okhttputils.okhttputils.https;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianjunhuang.me@foxmail.com
 *         create on 2017/9/7.
 */

public class HttpCode {

    private static Map<Integer, String> codeMap;

    private static final String TAG = "HttpCode";

    public static void initMap(Context context) {
        if (null == codeMap) {
            codeMap = new HashMap<>();
        }
        try {
            InputStream inputStream = context.getAssets().open("http_code.hjj");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] keyValue = str.split(":");
                codeMap.put(Integer.valueOf(keyValue[0]), keyValue[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCodeExp(int code) {
        return codeMap.get(code);
    }

}
