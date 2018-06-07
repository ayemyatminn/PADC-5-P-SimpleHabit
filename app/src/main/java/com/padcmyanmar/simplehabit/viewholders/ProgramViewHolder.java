package com.padcmyanmar.simplehabit.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;
import com.padcmyanmar.simplehabit.data.vo.ProgramVO;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramActionDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PC on 5/27/2018.
 */

public class ProgramViewHolder extends BaseViewHolder<ProgramVO> {
    @BindView(R.id.tv_news_simple_habits_title)
    TextView tvNewsSimpleHabitsTitle;

    @BindView(R.id.tv_news_simple_habits_duraion)
    TextView getTvNewsSimpleHabitsDuration;

    @BindView(R.id.rl_program)
    RelativeLayout rlProgram;

    private CategoryProgramActionDelegate mCategoryProgramActionDelegate;

    private CategoryProgramVO mCategoryProgramVO;

    private ProgramVO mProgramVO;

    public ProgramViewHolder(View itemView,CategoryProgramActionDelegate categoryProgramActionDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mCategoryProgramActionDelegate=categoryProgramActionDelegate;
        rlProgram.setOnClickListener(this);
    }

    @Override
    public void setData(ProgramVO data) {
        mProgramVO=data;
        tvNewsSimpleHabitsTitle.setText(data.getTitle());
        getTvNewsSimpleHabitsDuration.setText(data.getAverageLengths().get(0).toString() + "mins");
    }


    public void setCategory(CategoryProgramVO categoryProgramVO){
        mCategoryProgramVO=categoryProgramVO;
    }

    @Override
    public void onClick(View view) {
        mCategoryProgramActionDelegate.onTapCategoryProgramItem(mCategoryProgramVO.getCategoryId(),mProgramVO.getProgramId());
    }
}
