package com.xxm.headlines.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * activity的基类
 */
public abstract class BaseActivity extends Activity {
    protected BaseActivity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mActivity = this;
        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 布局id
     * @return
     */
    protected abstract int getContentViewId();
}
