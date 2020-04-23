package com.zy.storage.chaincache;

import com.zy.storage.callback.ResultCallback;
import com.zy.storage.common.ZDiskLRUCache;

/**
 * @author:zhangyue
 * @date:2020/4/23
 * 内置存储/磁盘存储链节点
 */
public class DiskCacheChain<T> extends StorageChain<T> {
    @Override
    protected void saveData(String key, T data) {
        ZDiskLRUCache.getInstance().saveData(key,data);

    }

    @Override
    protected void getData(String key, ResultCallback callback) {
        T data = (T) ZDiskLRUCache.getInstance().getData(key);
        if (data!=null){
            callback.getData(data);
        }
        else{
            callback.getData(null);
        }
    }

    @Override
    protected void removeByKey(String key) {
        ZDiskLRUCache.getInstance().removeByKey(key);
    }

    @Override
    protected void clearData() {
        ZDiskLRUCache.getInstance().clearData();
    }
}
