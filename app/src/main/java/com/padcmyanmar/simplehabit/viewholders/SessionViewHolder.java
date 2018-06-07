package com.padcmyanmar.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.SessionVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 6/3/2018.
 */

public class SessionViewHolder extends BaseViewHolder<SessionVO> {

    @BindView(R.id.tv_session_title)
    TextView tvSessionTitle;

    @BindView(R.id.tv_session_time_taken)
    TextView tvSessionTimeTaken;

    @BindView(R.id.tv_session_id)
    TextView tvSessionId;

    public SessionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(SessionVO data) {
        tvSessionTitle.setText(data.getTitle());
        tvSessionId.setText(data.getSessionId());
        String timeLength = data.getLengthInSecond()/60+":"+data.getLengthInSecond()%60;
        tvSessionTimeTaken.setText(timeLength);

    }

    @Override
    public void onClick(View view) {

    }
}
