package com.zy.common.log;

import android.util.Log;

/**
 * @author:zhangyue
 * @date:2020/4/21
 * 使用Logcat实现log的输出
 */
public class LogcatImpl implements ILog {
    private final String TAG="zhangyuelog";
    @Override
    public void d(String log) {
        Log.d(TAG,log);
    }

    @Override
    public void d(String TAG, String log) {
        d(TAG+" -> "+log);

    }

    @Override
    public void i(String log) {
        Log.i(TAG,log);
    }

    @Override
    public void i(String TAG, String log) {
        i(TAG+" -> "+log);
    }

    @Override
    public void w(String log) {
        Log.w(TAG,log);
    }

    @Override
    public void w(String TAG, String log) {
        w(TAG+" -> "+log);
    }

    @Override
    public void e(String log) {
        Log.e(TAG,log);
    }

    @Override
    public void e(String TAG, String log) {
        e(TAG+" -> "+log);
    }
}
