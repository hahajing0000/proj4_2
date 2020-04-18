package com.zy.core.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.zy.core.BasePresenter;
import com.zy.core.IView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author:zhangyue
 * @date:2020/4/18
 * mvp中activity的基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView {
    /**
     * P 层引用
     */
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        createPresenter();
        initView(savedInstanceState);
        initData();
        initEvent();
    }

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
     * 获取布局资源ID
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * toast消息
     * @param msg
     */
    protected void showMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null!=mPresenter){
            mPresenter=null;
        }
    }
}
