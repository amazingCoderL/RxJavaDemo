package com.hao.rxjava.operators;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hao.rxjava.BaseFragment;
import com.hao.rxjava.R;
import com.hao.rxjava.databinding.FragmentCreatingBinding;
import com.hao.rxjava.viewmodel.CreatingViewModel;

import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.SupportFragmentDelegate;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * +-----------------------------------------------------
 * | @description:
 * +-----------------------------------------------------
 * | @author: hao
 * +-----------------------------------------------------
 * | @created on 17/10/21 下午10:48.
 * +-----------------------------------------------------
 */

public class CreatingFragment extends BaseFragment {

    private FragmentCreatingBinding creatingBinding;



    @Override
    protected void initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        creatingBinding = (FragmentCreatingBinding)viewDatabinding;
        CreatingViewModel creatingVm = new CreatingViewModel(mActivity);
    }
    @Override
    protected void setListener() {
        creatingBinding.btnInteval.setOnClickListener(this);
        creatingBinding.btnRange.setOnClickListener(this);
        creatingBinding.btnRepeat.setOnClickListener(this);
        creatingBinding.btnStart.setOnClickListener(this);
        creatingBinding.btnTimer.setOnClickListener(this);
    }
    @Override
    protected void initData() {

    }

    @Override
    protected int setViewId() {
        return R.layout.fragment_creating;
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {

    }
}
