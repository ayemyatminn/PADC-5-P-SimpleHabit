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

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.adapters.TeacherAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/17/2018.
 */

public class TeacherFragment extends BaseFragment {
    @BindView(R.id.rv_teacher)
    RecyclerView rvTeacher;

    private TeacherAdapter mTeacherAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_teacher,container,false);
        ButterKnife.bind(this,view);
        mTeacherAdapter=new TeacherAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvTeacher.setLayoutManager(linearLayoutManager);
        rvTeacher.setAdapter(mTeacherAdapter);

        return view;

    }
}
