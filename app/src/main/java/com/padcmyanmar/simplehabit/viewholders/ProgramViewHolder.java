package com.padcmyanmar.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.ProgramVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/27/2018.
 */

public class ProgramViewHolder extends BaseViewHolder<ProgramVO> {
    @BindView(R.id.tv_news_simple_habits_title)
    TextView tvNewsSimpleHabitsTitle;

    @BindView(R.id.tv_news_simple_habits_duraion)
    TextView getTvNewsSimpleHabitsDuration;

    public ProgramViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(ProgramVO data) {
        tvNewsSimpleHabitsTitle.setText(data.getTitle());
        getTvNewsSimpleHabitsDuration.setText(data.getAverageLengths().get(0).toString() + "mins");
    }

    @Override
    public void onClick(View view) {

    }
}
