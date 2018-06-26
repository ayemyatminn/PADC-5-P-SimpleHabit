package com.padcmyanmar.simplehabit.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.activities.MainActivity;
import com.padcmyanmar.simplehabit.adapters.SeriesAdapter;
import com.padcmyanmar.simplehabit.mvp.presenters.SeriesPresenter;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/17/2018.
 */

public class SeriesFragment extends BaseFragment {

    @BindView(R.id.rv_series)
    RecyclerView rvSeries;

    private SeriesAdapter mSeriesAdapter;

    private SeriesPresenter mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        mPresenter = activity.getPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);



        mSeriesAdapter=new SeriesAdapter(getContext(), mPresenter, mPresenter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvSeries.setLayoutManager(linearLayoutManager);
        rvSeries.setAdapter(mSeriesAdapter);

        mPresenter.onFinishUIComponentSetUp();

        return view;
    }




//    @Override
//    public void onTapCategoryProgramItem(String categoryId,String categoryProgramId) {
//        Intent intent = ProgramDetailActivity.newIntent(getContext());
//        Intent intent = ProgramDetailActivity.newIntent(getContext(),categoryId,categoryProgramId);
//        startActivity(intent);
//    }



}
