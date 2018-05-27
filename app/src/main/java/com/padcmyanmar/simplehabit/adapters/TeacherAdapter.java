package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.viewholders.TeacherViewHolder;

/**
 * Created by PC on 5/17/2018.
 */

public class TeacherAdapter extends RecyclerView.Adapter<TeacherViewHolder> {


    @Override
    public TeacherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemTeacher=inflater.inflate(R.layout.item_teacher,parent,false);
        TeacherViewHolder itemTeacherViewHolder=new TeacherViewHolder(itemTeacher);

        return itemTeacherViewHolder;
    }

    @Override
    public void onBindViewHolder(TeacherViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 12;
    }
}
