package com.hao.rxjava.basic;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Description: 观察者创建方式
 * 2种方法的区别
 *相同点：二者基本使用方式完全一致（实质上，在RxJava的 subscribe 过程中，Observer总是会先被转换成Subscriber再使用）
 *不同点：Subscriber抽象类对 Observer 接口进行了扩展，新增了两个方法：
 *      1. onStart()：在还未响应事件前调用，用于做一些初始化工作
 *      2. unsubscribe()：用于取消订阅。在该方法被调用后，观察者将不再接收 & 响应事件
 *调用该方法前，先使用 isUnsubscribed() 判断状态，确定被观察者Observable是否还持有观察者Subscriber的引用，如果引用不能及时释放，就会出现内存泄露
 * Created on 17/10/17 上午10:22.
 * @author hao
 */

public class ObserverCreateModel {
    /**
     * 创建观察者Observer
     */
    public Observer<Integer> createObserver(){
        return new Observer<Integer>() {
            // 观察者接收事件前，默认最先调用复写 onSubscribe（）
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i("Observer","onSubscribe");
            }
            // 当被观察者生产Next事件 & 观察者接收到时，会调用该复写方法
            @Override
            public void onNext(@NonNull Integer o) {
                Log.i("Observer","onNext"+"-->"+o);
            }
            // 当被观察者生产Error事件调用该方法
            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("Observer","onSubscribe"+"-->"+e.toString());
            }
            // 当被观察者生产Complete事件调用该方法
            @Override
            public void onComplete() {
                Log.i("Observer","onComplete");
            }
        };
    }

    /**
     * 创建观察者DisposableObserver，方法回调时机和Observer创建方式相同
     */
    public DisposableObserver<Integer> createDisposableObserver(){
        return new DisposableObserver<Integer>(){

            @Override
            public void onNext(Integer integer) {
                Log.i("Subscriber","onNext"+"-->"+integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.i("Subscriber","onError"+"-->"+t.toString());
            }

            @Override
            public void onComplete() {
                Log.i("Subscriber","onComplete");
            }
        };
    }
}
