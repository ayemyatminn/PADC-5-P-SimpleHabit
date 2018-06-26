package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;
import com.padcmyanmar.simplehabit.data.vo.ProgramVO;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramActionDelegate;
import com.padcmyanmar.simplehabit.viewholders.ProgramViewHolder;
import com.padcmyanmar.simplehabit.viewholders.TeacherViewHolder;

/**
 * Created by PC on 5/27/2018.
 */

public class ProgramAdapter extends BaseRecyclerAdapter<ProgramViewHolder,ProgramVO> {

    private CategoryProgramActionDelegate mCategoryProgramActionDelegate;

    private CategoryProgramVO mCategoryProgramVO;

    public ProgramAdapter(Context context, CategoryProgramActionDelegate mCategoryProgramActionDelegate) {
        super(context);
        this.mCategoryProgramActionDelegate = mCategoryProgramActionDelegate;
    }

//    public ProgramAdapter(Context context) {
//        super(context);
//    }

    @Override
    public ProgramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemProgram=inflater.inflate(R.layout.item_program,parent,false);
        ProgramViewHolder programViewHolder=new ProgramViewHolder(itemProgram,mCategoryProgramActionDelegate);

        return programViewHolder;
    }

    @Override
    public void onBindViewHolder(ProgramViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.setData(mData.get(position));
        holder.setCategory(mCategoryProgramVO);
    }

    public void setmCategoryProgramVO(CategoryProgramVO mCategoryProgramVO) {
        this.mCategoryProgramVO = mCategoryProgramVO;
    }
}
