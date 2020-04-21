package com.zy.common.log;

/**
 * @author:zhangyue
 * @date:2020/4/21
 * log的基础接口
 */
public interface ILog {
    void d(String log);
    void d(String TAG,String log);

    void i(String log);
    void i(String TAG,String log);

    void w(String log);
    void w(String TAG,String log);

    void e(String log);
    void e(String TAG,String log);
}
