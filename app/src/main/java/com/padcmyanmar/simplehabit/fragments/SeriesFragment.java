package com.padcmyanmar.simplehabit.fragments;

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
import com.padcmyanmar.simplehabit.adapters.SeriesAdapter;
import com.padcmyanmar.simplehabit.data.model.SimpleHabitModel;
import com.padcmyanmar.simplehabit.events.HomeReadyEvent;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/17/2018.
 */

public class SeriesFragment extends BaseFragment {

    @BindView(R.id.rv_series)
    RecyclerView rvSeries;

    private SeriesAdapter mSeriesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);

        mSeriesAdapter=new SeriesAdapter(getContext());
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



}
