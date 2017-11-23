package com.hao.rxjava.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;

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
    protected ObservableField<String> obStr = null;
    protected StringBuilder mBuilder;
    protected BaseViewModel(Context context){
        mWeakReference = new WeakReference<Context>(context);
        obStr = new ObservableField<>();
        mBuilder = new StringBuilder();
    }
    public ObservableField<String> getObStr() {
        return obStr;
    }

    public void setObStr(ObservableField<String> obStr) {
        this.obStr = obStr;
    }

    protected Context getContext(){
        return mWeakReference.get();
    }
}
