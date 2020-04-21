package com.zy.imageloader.base;

import android.content.Context;

import com.zy.imageloader.setting.ImageSetting;

/**
 * @author:zhangyue
 * @date:2020/4/21
 * Image加载注解的基础策略接口
 */
public interface ImgLoaderStrategy<Setting extends ImageSetting> {
    /**
     * 加载图片
     * @param context 上下文
     * @param setting 图片加载设置
     */
    void loadImage(Context context,Setting setting);
}
