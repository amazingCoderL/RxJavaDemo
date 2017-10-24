package com.hao.rxjava;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * +-----------------------------------------------------
 * | @description:
 * +-----------------------------------------------------
 * | @author: hao
 * +-----------------------------------------------------
 * | @created on 17/10/22 上午10:28.
 * +-----------------------------------------------------
 */

public class BaseViewModel {
    public WeakReference<Context> mWeakReference = null;
    protected BaseViewModel(Context context){
        mWeakReference = new WeakReference<Context>(context);
    }

    protected Context getContext(){
        return mWeakReference.get();
    }
}
