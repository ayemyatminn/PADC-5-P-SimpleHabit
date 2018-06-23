package com.padcmyanmar.simplehabit.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.activities.ProgramDetailActivity;
import com.padcmyanmar.simplehabit.adapters.SeriesAdapter;
import com.padcmyanmar.simplehabit.data.model.SimpleHabitModel;
import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;
import com.padcmyanmar.simplehabit.data.vo.SharedParent;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramActionDelegate;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramActionDelegates;
import com.padcmyanmar.simplehabit.events.HomeReadyEvent;
import com.padcmyanmar.simplehabit.events.TapProgramId;
import com.padcmyanmar.simplehabit.mvp.presenters.SeriesPresenter;
import com.padcmyanmar.simplehabit.mvp.views.SeriesView;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/17/2018.
 */

public class SeriesFragment extends BaseFragment implements SeriesView{

    @BindView(R.id.rv_series)
    RecyclerView rvSeries;

    private SeriesAdapter mSeriesAdapter;

    private SeriesPresenter mPresentr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);

        mPresentr=new SeriesPresenter(this);
        mPresentr.onCreate();

        mSeriesAdapter=new SeriesAdapter(getContext(),mPresentr,mPresentr);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvSeries.setLayoutManager(linearLayoutManager);
        rvSeries.setAdapter(mSeriesAdapter);

        mPresentr.onFinishUIComponentSetUp();

        return view;
    }



    @Override
    public void onStart() {
        super.onStart();
        mPresentr.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresentr.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresentr.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresentr.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresentr.onDestroy();
    }

//    @Override
//    public void onTapCategoryProgramItem(String categoryId,String categoryProgramId) {
//        Intent intent = ProgramDetailActivity.newIntent(getContext());
//        Intent intent = ProgramDetailActivity.newIntent(getContext(),categoryId,categoryProgramId);
//        startActivity(intent);
//    }

    @Override
    public void displayErrorMessage(String errorMessage) {

    }


    @Override
    public void displaySeriesData(List<SharedParent> data) {
        mSeriesAdapter.setData(data);
    }

    @Override
    public void lunchCurrentDetailScreen() {
        Intent intent = ProgramDetailActivity.newIntent(getContext());
        startActivity(intent);
    }

    @Override
    public void lunchCategoryDetailScreen() {
        Intent intent = ProgramDetailActivity.newIntent(getContext());
        startActivity(intent);
    }
}
