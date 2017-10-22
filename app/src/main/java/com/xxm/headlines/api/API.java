package com.xxm.headlines.api;

/**
 * api 接口
 */

public class API {

    private static final String BASE_URL = "http://toutiao-ali.juheapi.com/toutiao";

    /**
     * 获取请求地址
     *
     * @param type 类型
     * @return url字符串
     */
    public static String getUrl(String type) {
        return BASE_URL + "/index?type=" + type;
    }

}
