package com.padcmyanmar.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.TopicesVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/27/2018.
 */

public class TopicViewHolder extends BaseViewHolder<TopicesVO> {
    @BindView(R.id.tv_all_topic_title)
    TextView tvAllTopicTitle;

    @BindView(R.id.tv_all_topices_breif)
    TextView tvAllTopicBreif;

    public TopicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(TopicesVO data) {
        tvAllTopicTitle.setText(data.getTopicName());
        tvAllTopicBreif.setText(data.getTopicDescription());

    }

    @Override
    public void onClick(View view) {

    }
}
