package com.zy.core.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.core.BasePresenter;
import com.zy.core.IView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author:zhangyue
 * @date:2020/4/18
 * mvp中fragment的基类
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IView
{
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container ,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createPresenter();
        initView(savedInstanceState);
        initData();
        initEvent();
    }

    /**
     * 获取布局ID
     * @return
     */
    protected abstract int getLayoutId();
    /**
     * 创建/初始化P
     */
    protected abstract void createPresenter();

    /**
     * 初始化页面事件
     */
    protected abstract void initEvent();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化视图
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * Fragment获取资源id方法
     * @param viewId
     * @param <T>
     * @return
     */
    protected <T extends View> T $(@IdRes int viewId) {
        return this.getView().findViewById(viewId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null!=mPresenter){
            mPresenter=null;
        }
    }
}
