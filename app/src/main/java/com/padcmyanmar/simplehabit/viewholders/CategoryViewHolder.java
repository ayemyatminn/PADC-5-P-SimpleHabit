package com.padcmyanmar.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.adapters.ProgramAdapter;
import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;

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

    public CategoryViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this,itemView);
        programAdapter=new ProgramAdapter(itemView.getContext());
        rvProgram.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));
        rvProgram.setAdapter(programAdapter);
    }

    @Override
    public void setData(CategoryProgramVO data) {
        programAdapter.setData(data.getProgram());
        tvEveningMeditation.setText(data.getTitle());
    }

    @Override
    public void onClick(View view) {

    }
}
