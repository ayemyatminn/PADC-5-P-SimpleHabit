package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.ProgramVO;
import com.padcmyanmar.simplehabit.viewholders.ProgramViewHolder;
import com.padcmyanmar.simplehabit.viewholders.TeacherViewHolder;

/**
 * Created by PC on 5/27/2018.
 */

public class ProgramAdapter extends BaseRecyclerAdapter<ProgramViewHolder,ProgramVO> {
    public ProgramAdapter(Context context) {
        super(context);
    }

    @Override
    public ProgramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemProgram=inflater.inflate(R.layout.item_program,parent,false);
        ProgramViewHolder programViewHolder=new ProgramViewHolder(itemProgram);

        return programViewHolder;
    }


}
