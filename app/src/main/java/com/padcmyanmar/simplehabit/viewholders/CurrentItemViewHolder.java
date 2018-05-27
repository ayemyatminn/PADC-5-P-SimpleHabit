package com.padcmyanmar.simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/27/2018.
 */

public class CurrentItemViewHolder extends BaseViewHolder<CurrentProgramVO> {
    @BindView(R.id.tv_starter)
    TextView tvStarter;

    @BindView(R.id.tv_simple_habit)
    TextView tvSimpleHabit;

    @BindView(R.id.tv_starter_duration)
    TextView tvStarterDuration;


    public CurrentItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(CurrentProgramVO data) {
        tvSimpleHabit.setText(data.getTitle());
        tvStarter.setText(data.getSession().get(0).getTitle());
        tvStarterDuration.setText(data.getAverageLength().get(0).toString() + "mins");
    }

    @Override
    public void onClick(View view) {

    }
}
