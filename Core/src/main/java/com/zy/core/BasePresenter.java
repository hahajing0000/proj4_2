package com.zy.core;

import java.lang.ref.WeakReference;

/**
 * @author:zhangyue
 * @date:2020/4/18
 */
public abstract class BasePresenter<R extends Repository,V extends IView> {
    protected R mRepository;
    protected WeakReference<V> mView;


    protected abstract void createRepository();

    public BasePresenter(V _v){
        createRepository();
        mView=new WeakReference<>(_v);

    }

}
