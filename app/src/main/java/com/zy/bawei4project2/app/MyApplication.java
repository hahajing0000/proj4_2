package com.zy.bawei4project2.app;

import android.app.Application;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zy.common.app.AppUtils;
import com.zy.common.log.ZLog;
import com.zy.imageloader.ImageLoader;
import com.zy.imageloader.impl.GlideStrategy;

/**
 * @author:zhangyue
 * @date:2020/4/17
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化


        /**
         * 设置开启log
         */
        ZLog.getInstance().openDebug(true);

        /**
         * 设置Application的上下文提供给各Moudle使用
         */
        AppUtils.setContext(this);

        /**
         * 初始化ImageLoader的策略为Glide
         */
        ImageLoader.getInstance().initStrategy(new GlideStrategy());
    }

    private boolean isDebug() {
        return true;
    }
}
