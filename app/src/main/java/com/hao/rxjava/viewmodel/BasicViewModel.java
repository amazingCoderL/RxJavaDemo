package com.hao.rxjava.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * +-----------------------------------------------------
 * | @description:RxJava基本使用
 * +-----------------------------------------------------
 * | @author: hao
 * +-----------------------------------------------------
 * | @created on 17/10/22 下午9:21.
 * +-----------------------------------------------------
 */

public class BasicViewModel extends BaseViewModel {

    public BasicViewModel(Context context) {
        super(context);
    }

    /**
     * create实现订阅
     */
    public void onSubscribeCreate(){
        if(mBuilder.length()>0){
            mBuilder.delete(0,obStr.get().length());
        }
        mBuilder.append("Create实现：\n");
        obStr.set(mBuilder.toString());
        createObservableCreate()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(createDisposableObserver());
    }

    /**
     * Just实现订阅
     */
    public void onSubscribeJust(){
        if(mBuilder.length()>0){
            mBuilder.delete(0,obStr.get().length());
        }
        mBuilder.append("Just实现：\n");
        createObservableJust().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(createDisposableObserver());
    }

    /**
     * Form实现
     */
    public void onSubscribeForm(){
        if(mBuilder.length()>0){
            mBuilder.delete(0,obStr.get().length());
        }
        mBuilder.append("From实现：\n");
        createObservableFrom().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(createDisposableObserver());
    }

// ################################################################################################

/**
 * +---------------------------------------------------------------
 * |* Description: 观察者创建方式
 * | 2种方法的区别
 * |相同点：二者基本使用方式完全一致（实质上，在RxJava的 subscribe 过程中，Observer总是会先被转换成Subscriber再使用）
 * |不同点：Subscriber抽象类对 Observer 接口进行了扩展，新增了两个方法：
 * |     1. onStart()：在还未响应事件前调用，用于做一些初始化工作
 * |      2. unsubscribe()：用于取消订阅。在该方法被调用后，观察者将不再接收 & 响应事件
 * |调用该方法前，先使用 isUnsubscribed() 判断状态，确定被观察者Observable是否还持有观察者Subscriber的引用，如果引用不能及时释放，就会出现内存泄露
 * +---------------------------------------------------------------
 */

// ################################################################################################

    /**
     * 创建观察者Observer
     */
    private Observer<Integer> createObserver(){
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
    private DisposableObserver<String> createDisposableObserver(){
        return new DisposableObserver<String>(){

            @Override
            public void onNext(String integer) {
                mBuilder.append("Subscriber::::::(onNext-->"+integer+")\n");
                obStr.set(mBuilder.toString());
                Log.i("Subscriber","onNext"+"-->"+integer);
            }

            @Override
            public void onError(Throwable t) {
                mBuilder.append("Subscriber::::::(onError-->"+t.toString()+")\n");
                obStr.set(mBuilder.toString());
                Log.i("Subscriber","onError"+"-->"+t.toString());
            }

            @Override
            public void onComplete() {
                mBuilder.append("Subscriber::::::(onComplete)\n");
                obStr.set(mBuilder.toString());
                Log.i("Subscriber","onComplete");
            }
        };
    }

    /**
     * 基本创建方式，一个参数
     */
    private Observable<String> createObservableCreate(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("Create1");
                Thread.sleep(1000);
                e.onNext("Create2");
                Thread.sleep(1000);
                e.onNext("Create3");
                Thread.sleep(1000);
                e.onNext("Create4");
                Thread.sleep(1000);
                e.onNext("Create5");
            }
        });
    }

    /**
     * just创建方式
     * 等价于create创建，依次调用onNext(1),onNext(2),onNext(3),onNext(4),onNext(5)
     * 参数最多十位
     */
    private Observable<String> createObservableJust(){
        return Observable.just("Just1","Just2","Just3","Just4","Just5");
    }

    /**
     * from创建方式
     * 同理 依次调用onNext("a"),onNext("b"),onNext("c")
     * 参数为数组形式，可传大于十位参数
     */
    private Observable<String> createObservableFrom(){
        String[] str = {"from1","from2","from3","from4","from5"};
        return Observable.fromArray(str);
    }

}
