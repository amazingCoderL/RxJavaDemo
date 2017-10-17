package com.hao.rxjava.basic;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Description: 被观察者创建方式<br>
 * Created on 17/10/17 上午9:58.
 * @author hao
 */

public class ObservableCreateModel {

    /**
     * 基本创建方式，一个参数
     */
    public Observable<Integer> createObservableCreate(){
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        });
    }

    /**
     * just创建方式
     * 等价于create创建，依次调用onNext(1),onNext(2),onNext(3),onNext(4),onNext(5)
     * 参数最多十位
     */
    public Observable<Integer> createObservableJust(){
        return Observable.just(1,2,3,4,5);
    }

    /**
     * from创建方式
     * 同理 依次调用onNext("a"),onNext("b"),onNext("c")
     * 参数为数组形式，可传大于十位参数
     */
    public Observable<Integer> createObservableFrom(){
        Integer[] str = {1,2,3};
        return Observable.fromArray(str);
    }



}
