package com.zy.storage.callback;

/**
 * @author:zhangyue
 * @date:2020/4/23
 * 异步回调结果接口
 */
public interface ResultCallback<T> {
    void getData(T data);

}
