package com.zy.common.exception;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.widget.Toast;

import com.zy.common.log.ZLog;

import androidx.annotation.NonNull;

/**
 * @author:zhangyue
 * @date:2020/4/26
 * 全局异常捕获
 */
public class ZGlobalExceptionManager implements Thread.UncaughtExceptionHandler {
    private Context mContext;
    private static ZGlobalExceptionManager instance=new ZGlobalExceptionManager();
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    private ZGlobalExceptionManager(){

    }
    public static ZGlobalExceptionManager getInstance(){
        return instance;
    }

    /**
     * 初始化方法
     * @param context
     */
    public void init(Context context){
        mContext=context;
        //获取到系统提供的异常处理器
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置成我们自己实现的异常处理器 也就是当前类
        Thread.setDefaultUncaughtExceptionHandler(this);

    }


    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        if (!handleException(t,e)&&defaultUncaughtExceptionHandler!=null){
            defaultUncaughtExceptionHandler.uncaughtException(t,e);
        }
        else{
            SystemClock.sleep(3*1000);
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }

    /**
     * 自定义处理异常
     * @param t
     * @param e
     * @return
     */
    private boolean handleException(Thread t, Throwable e) {
        if (t==null&&e==null){
            return false;
        }
        //确切的异常信息
        final String message = e.getMessage();
        String threadName=t.getName();
        /**
         * 暂时将msg缓存(SP Sqlite) 获取提交到服务器
         *
         * 异常信息的处理策略
         */
        //TODO:有具体的业务处理 这里暂时不实现

        new Thread(){
            @Override
            public void run() {

                Looper.prepare();
                Toast.makeText(mContext,"哎呦！程序挂了",Toast.LENGTH_SHORT).show();
                ZLog.getInstance().e(message);
                Looper.loop();

            }
        }.start();
        return true;
    }
}
