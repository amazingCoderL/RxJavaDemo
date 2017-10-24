package com.hao.rxjava.operators;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Description:
 * 创建型操作符有：
 *      Create，
 *      Defer,
 *      Empty/Never/Throw,
 *      fromArray,
 *      Interval,
 *      Just,
 *      Range,
 *      Repeat,
 *      Start,
 *      Timer
 * Author: hao<br>
 * Created on 17/10/17 上午11:33.
 */

public class CreatingOperators {

    /**
     * fromArray操作符使用
     * @param integers fromArray接收参数 数组，集合
     */
    public Disposable fromArrayOperators(final Context context,@NonNull Integer[] integers){
        return Observable.fromArray(integers).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.i("fromArrayOperators","integer["+integer+"]-->"+integer);
                Toast.makeText(context, "integer["+integer+"]-->"+integer, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * interval操作符使用
     * @param initialDelay 第一次轮询延时时间
     * @param period 轮询时间间隔
     * @param unit 时间单位
     * @param scheduler 指定轮询执行线程
     */
    public Disposable intervalOperators(long initialDelay, long period, TimeUnit unit,Scheduler scheduler){
        return Observable.interval(initialDelay, period, unit, scheduler).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.i("intervalOperators", "Long-->"+aLong);
            }
        });
    }
}
