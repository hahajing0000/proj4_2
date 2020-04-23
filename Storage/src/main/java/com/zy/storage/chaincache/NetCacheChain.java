package com.zy.storage.chaincache;

import com.zy.storage.callback.ResultCallback;

/**
 * @author:zhangyue
 * @date:2020/4/23
 * 网络部分不适合封装到Storage基础组件中来
 */
@Deprecated
public class NetCacheChain<T> extends StorageChain<T> {
    @Override
    protected void saveData(String key, T data) {

    }

    @Override
    protected void getData(String key, ResultCallback callback) {

    }

    @Override
    protected void removeByKey(String key) {

    }

    @Override
    protected void clearData() {

    }
}
