package com.zy.core;

/**
 * @author:zhangyue
 * @date:2020/4/18
 * 数据仓库基础接口
 */
public abstract class Repository<M extends IModel> {
    /**
     * 数据业务
     */
    protected M mModel;

    /**
     * 创建/初始化业务Model
     */
    protected abstract void createModel();

    public Repository(){
        createModel();
    }

    /**
     * 释放业务Model
     */
    protected void releaseModel(){
        if (null!=mModel){
            mModel=null;
        }
    }
}
