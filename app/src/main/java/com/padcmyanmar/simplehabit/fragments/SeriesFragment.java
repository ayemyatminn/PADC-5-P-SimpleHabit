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
import com.padcmyanmar.simplehabit.delegates.CategoryProgramActionDelegate;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramActionDelegates;
import com.padcmyanmar.simplehabit.events.HomeReadyEvent;
import com.padcmyanmar.simplehabit.events.TapProgramId;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/17/2018.
 */

public class SeriesFragment extends BaseFragment implements CategoryProgramActionDelegate,CurrentProgramActionDelegates{

    @BindView(R.id.rv_series)
    RecyclerView rvSeries;

    private SeriesAdapter mSeriesAdapter;

    private CategoryProgramActionDelegate categoryProgramActionDelegate;

    private CurrentProgramActionDelegates currentProgramActionDelegates;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);

        mSeriesAdapter=new SeriesAdapter(getContext(),this,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvSeries.setLayoutManager(linearLayoutManager);
        rvSeries.setAdapter(mSeriesAdapter);

        SimpleHabitModel.getSobjInstance().loadData();


        return view;
    }



    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHomeDataLoaded(HomeReadyEvent event){
        mSeriesAdapter.setData(event.getmHome());
    }


    @Override
    public void onTapCategoryProgramItem(String categoryId,String categoryProgramId) {
        Intent intent = ProgramDetailActivity.newIntent(getContext(),categoryId,categoryProgramId);
        startActivity(intent);
    }

    @Override
    public void onTapCurrentProgramItem() {
        Intent intent = ProgramDetailActivity.newIntent(getContext());
        startActivity(intent);
    }
}
