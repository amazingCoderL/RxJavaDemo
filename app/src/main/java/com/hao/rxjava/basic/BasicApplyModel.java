package com.hao.rxjava.basic;

/**
 * Description: RxJava订阅方式实现
 * @author hao
 * Created on 17/10/17 上午10:35.
 */

public class BasicApplyModel {

    private ObservableCreateModel observableCreateModel = null;
    private ObserverCreateModel observerCreateModel = null;

    public BasicApplyModel(){
        observableCreateModel = new ObservableCreateModel();
        observerCreateModel = new ObserverCreateModel();
    }
    public void onSubscribeOne(){
        observableCreateModel.createObservableCreate()
                .subscribe(observerCreateModel.createObserver());
    }

    public void onSubscribeTwo(){
        observableCreateModel.createObservableCreate()
                .subscribe(observerCreateModel.createDisposableObserver());
    }
    public void onSubscribeThree(){
        observableCreateModel.createObservableJust()
                .subscribe(observerCreateModel.createObserver());
    }
    public void onSubscribeFour(){
        observableCreateModel.createObservableJust()
                .subscribe(observerCreateModel.createDisposableObserver());
    }

    public void onSubscribeFive(){
        observableCreateModel.createObservableFrom()
                .subscribe(observerCreateModel.createObserver());
    }

    public void onSubscribeSix(){
        observableCreateModel.createObservableFrom()
                .subscribe(observerCreateModel.createDisposableObserver());
    }
}
