package com.zy.storage.chaincache;

import com.zy.storage.callback.ResultCallback;
import com.zy.storage.common.ZLRUCache;

/**
 * @author:zhangyue
 * @date:2020/4/23
 * 内存存储链节点
 */
public class MemoryCacheChain<T> extends StorageChain<T> {
    @Override
    protected void saveData(String key, T data) {
        ZLRUCache.getInstance().put(key,data);
    }

    @Override
    protected void getData(String key, ResultCallback callback) {
        T result = (T) ZLRUCache.getInstance().get(key);
        if (result!=null){
            callback.getData(result);
        }
        else {
            callback.getData(null);
        }
    }

    @Override
    protected void removeByKey(String key) {
        ZLRUCache.getInstance().remove(key);
    }

    @Override
    protected void clearData() {
        ZLRUCache.getInstance().clear();
    }
}
