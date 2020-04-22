package com.zy.common.app;

import android.content.Context;

/**
 * @author:zhangyue
 * @date:2020/4/21
 */
public class AppUtils {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        AppUtils.context = context;
    }


}
