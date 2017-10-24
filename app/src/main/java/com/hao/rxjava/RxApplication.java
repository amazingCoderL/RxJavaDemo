package com.hao.rxjava;

import android.app.Application;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * +-----------------------------------------------------
 * | @description:
 * +-----------------------------------------------------
 * | @author: hao
 * +-----------------------------------------------------
 * | @created on 17/10/22 下午10:29.
 * +-----------------------------------------------------
 */

public class RxApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fragmentation.builder()
                .stackViewMode(Fragmentation.NONE)
                .debug(BuildConfig.DEBUG)
                .install();
    }
}
