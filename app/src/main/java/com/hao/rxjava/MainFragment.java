package com.hao.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hao.rxjava.databinding.FragmentMainBinding;
import com.hao.rxjava.operators.CreatingFragment;

/**
 * +-----------------------------------------------------
 * | @description:
 * +-----------------------------------------------------
 * | @author: hao
 * +-----------------------------------------------------
 * | @created on 17/10/22 上午10:00.
 * +-----------------------------------------------------
 */

public class MainFragment extends BaseFragment implements View.OnClickListener{
    @Override
    protected void initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMainBinding viewBinding = (FragmentMainBinding) viewDatabinding;
        viewBinding.mainToolbar.setTitle("RxJave使用");
        viewBinding.mainToolbar.setFitsSystemWindows(true);
        mActivity.setSupportActionBar(viewBinding.mainToolbar);
        viewBinding.btnBasicApply.setOnClickListener(this);
        viewBinding.btnCreatingOperators.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int setViewId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_basic_apply:
                start(BasicFragment.newInstance());
                break;
            case R.id.btn_creating_operators:
                start(new CreatingFragment());
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        return false;
    }
}
