package com.zy.usercenter.model.storagechain;

import com.zy.common.log.ZLog;
import com.zy.storage.callback.ResultCallback;
import com.zy.storage.chaincache.StorageChain;

/**
 * @author:zhangyue
 * @date:2020/4/23
 */
public class LoginStorageChain<T> extends StorageChain<T> {
    @Override
    protected void saveData(String key, T data) {
        ZLog.getInstance().d("LoginStorageChain save");
    }

    @Override
    protected void getData(String key, ResultCallback callback) {
        ZLog.getInstance().d("LoginStorageChain get");
    }

    @Override
    protected void removeByKey(String key) {

    }

    @Override
    protected void clearData() {

    }
}
