package com.padcmyanmar.simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramActionDelegates;

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

    @BindView(R.id.rl_current)
    RelativeLayout rlCurrent;

    private CurrentProgramVO currentVO;

    private CurrentProgramActionDelegates mCurrentProgramActionDelegates;


    public CurrentItemViewHolder(View itemView,CurrentProgramActionDelegates currentProgramActionDelegates) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mCurrentProgramActionDelegates=currentProgramActionDelegates;
        rlCurrent.setOnClickListener(this);
    }

    @Override
    public void setData(CurrentProgramVO data) {
        currentVO=data;

        tvSimpleHabit.setText(data.getTitle());
        tvStarter.setText(data.getSession().get(0).getTitle());
        tvStarterDuration.setText(data.getAverageLength().get(0).toString() + "mins");
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(itemView.getContext(),"click current program",Toast.LENGTH_SHORT).show();
        mCurrentProgramActionDelegates.onTapCurrentProgramItem();
    }
}
