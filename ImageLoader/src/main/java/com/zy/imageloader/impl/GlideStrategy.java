package com.zy.imageloader.impl;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zy.imageloader.base.ImgLoaderStrategy;
import com.zy.imageloader.setting.NormalImageSetting;

/**
 * @author:zhangyue
 * @date:2020/4/21
 * Glide的图片加载策略
 */
public class GlideStrategy implements ImgLoaderStrategy<NormalImageSetting> {
    @Override
    public void loadImage(Context context, NormalImageSetting setting) {

        RequestOptions requestOptions=null;
        if (setting.getImgRadius()>0){
            requestOptions=RequestOptions.bitmapTransform(new RoundedCorners(setting.getImgRadius()));
        }
        else{
            requestOptions=new RequestOptions();
        }

        if (setting.getmPlaceholder()>0){
            requestOptions.placeholder(setting.getmPlaceholder());
            requestOptions.error(setting.getmPlaceholder());
        }

        //关闭内存缓存
        //requestOptions.skipMemoryCache(true);
        //都缓存  原生数据 本地数据 转换的数据都缓存
        //requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(setting.getmUrl()).apply(requestOptions).into(setting.getmView());
    }
}
