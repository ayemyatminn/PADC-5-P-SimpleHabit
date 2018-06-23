package com.padcmyanmar.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.adapters.ProgramAdapter;
import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramActionDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/27/2018.
 */

public class CategoryViewHolder extends BaseViewHolder<CategoryProgramVO> {
    @BindView(R.id.tv_evening_meditation)
    TextView tvEveningMeditation;

    @BindView(R.id.rv_program)
    RecyclerView rvProgram;

    private ProgramAdapter programAdapter;

    private CategoryProgramActionDelegate mCategoryProgramActionDelegate;

    public CategoryViewHolder(View itemView,CategoryProgramActionDelegate categoryProgramActionDelegate) {

        super(itemView);
        ButterKnife.bind(this,itemView);
        mCategoryProgramActionDelegate=categoryProgramActionDelegate;
        programAdapter=new ProgramAdapter(itemView.getContext(),mCategoryProgramActionDelegate);
        rvProgram.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));
        rvProgram.setAdapter(programAdapter);
    }

    @Override
    public void setData(CategoryProgramVO data) {
        programAdapter.setData(data.getProgram());
        tvEveningMeditation.setText(data.getTitle());
        //TODO call categoryProgramVO setCategory

    }

    @Override
    public void onClick(View view) {


    }
}
