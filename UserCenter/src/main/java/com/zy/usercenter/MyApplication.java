package com.zy.usercenter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.zy.common.app.AppUtils;
import com.zy.common.log.ZLog;
import com.zy.imageloader.ImageLoader;
import com.zy.imageloader.impl.FresoStrategy;
import com.zy.imageloader.impl.GlideStrategy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2020/4/20
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        registerLifecycle();

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
//        ZLog.getInstance().setLogType(new ConsoleImpl());
    }

    private void registerLifecycle() {
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                Log.d("123", "onActivityCreated: ........");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                Log.d("123", "onActivityStarted: ......");
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }


}
