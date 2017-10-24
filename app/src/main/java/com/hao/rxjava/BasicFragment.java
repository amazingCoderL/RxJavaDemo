package com.hao.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hao.rxjava.databinding.FragmentBasicBinding;
import com.hao.rxjava.viewmodel.BasicViewModel;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * +-----------------------------------------------------
 * | @description:
 * +-----------------------------------------------------
 * | @author: hao
 * +-----------------------------------------------------
 * | @created on 17/10/22 下午9:08.
 * +-----------------------------------------------------
 */

public class BasicFragment extends BaseFragment implements View.OnClickListener{
    private BasicViewModel basicViewModel = null;

    public static BasicFragment newInstance(){
        BasicFragment basicFragment = new BasicFragment();
        Bundle bundle = new Bundle();
        basicFragment.setArguments(bundle);
        return basicFragment;
    }
    @Override
    protected void initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBasicBinding basicViewBinding = (FragmentBasicBinding) viewDatabinding;
        basicViewModel = new BasicViewModel(mActivity);
        basicViewBinding.basicToolbar.setTitle("基本使用");
        basicViewBinding.basicToolbar.setFitsSystemWindows(true);
        mActivity.setSupportActionBar(basicViewBinding.basicToolbar);
        basicViewBinding.btnBasicCreate.setOnClickListener(this);
        basicViewBinding.btnBasicJust.setOnClickListener(this);
        basicViewBinding.btnBasicFrom.setOnClickListener(this);
        basicViewBinding.setData(basicViewModel);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int setViewId() {
        return R.layout.fragment_basic;
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_basic_create:
                basicViewModel.onSubscribeCreate();
                break;
            case R.id.btn_basic_just:
                basicViewModel.onSubscribeJust();
                break;
            case R.id.btn_basic_from:
                basicViewModel.onSubscribeForm();
                break;
            default:
                break;
        }
    }
}
