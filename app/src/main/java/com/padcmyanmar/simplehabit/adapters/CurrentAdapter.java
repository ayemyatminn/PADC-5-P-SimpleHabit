package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramActionDelegates;
import com.padcmyanmar.simplehabit.viewholders.CurrentItemViewHolder;
import com.padcmyanmar.simplehabit.viewholders.TeacherViewHolder;

/**
 * Created by PC on 5/27/2018.
 */

public class CurrentAdapter extends BaseRecyclerAdapter<CurrentItemViewHolder,CurrentProgramVO> {

    private CurrentProgramActionDelegates mCurrentProgramActionDelegates;

    public CurrentAdapter(Context context, CurrentProgramActionDelegates mCurrentProgramActionDelegates) {
        super(context);
        this.mCurrentProgramActionDelegates = mCurrentProgramActionDelegates;
    }

    @Override
    public CurrentItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemCurrent=inflater.inflate(R.layout.item_current,parent,false);
        CurrentItemViewHolder currentItemViewHolder=new CurrentItemViewHolder(itemCurrent,mCurrentProgramActionDelegates);

        return currentItemViewHolder;
    }
}
