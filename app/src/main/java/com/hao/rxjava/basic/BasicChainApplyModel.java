package com.hao.rxjava.basic;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

/**
 * Description: <br>
 * @author hao
 * Created on 17/10/17 上午11:00.
 */

public class BasicChainApplyModel {
    /**
     * RxJava基于Observer观察者的链式调用
     */
    public void applyChainOne(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {

            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 基于DisposableObserver观察者的链式调用模式
     */
    public void applyChainTwo(){
        Observable.just(1,2,3)
                .subscribe(new DisposableObserver<Integer>() {
                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.i("applyChainTwo","onNext"+"-->"+integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("applyChainTwo","onError"+"-->"+e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.i("applyChainTwo","onComplete");
                    }
                });
    }

    /**
     * 简便式的RxJava调用方式
     * 其他简便式接口有：Action,BiConsumer,Cancellable,Function,Function3-Function9等等
     * 可查看io.reactivex.functions包下源码
     */
    public void applyChaninThree(){
        Integer[] inter = {1,2,3};
        Observable.fromArray(inter)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i("applyChaninThree","accept"+"-->"+integer);
                    }
                });
    }
}
