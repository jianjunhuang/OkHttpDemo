package com.library.jianjunhuang.okhttputils.okhttputils.https;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianjunhuang.me@foxmail.com
 *         create on 2017/9/7.
 */

public class HttpCode {

    private static Map<Integer, String> codeMap;

    private void initMap() {
        if (null == codeMap) {
            codeMap = new HashMap<>();
        }
        codeMap.put(200,"success");
    }

}
