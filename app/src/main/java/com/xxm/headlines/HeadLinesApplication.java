package com.xxm.headlines;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by XUXIAOMING on 2017/10/15.
 */
public class HeadLinesApplication extends Application {

    /**
     * 是否加载服务器数据
     */
    public static final Boolean isLoadServerData = false;

    @Override
    public void onCreate() {
        super.onCreate();

        // Logger.addLogAdapter(new AndroidLogAdapter());
        //若是在项目上线之后，隐藏日志就要实现：
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
                //return false;
            }
        });
    }
}
