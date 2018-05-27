package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.TopicesVO;

import com.padcmyanmar.simplehabit.viewholders.TopicViewHolder;

/**
 * Created by PC on 5/27/2018.
 */

public class TopicAdapter extends BaseRecyclerAdapter<TopicViewHolder,TopicesVO> {
    public TopicAdapter(Context context) {
        super(context);
    }

    @Override
    public TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemTopic=inflater.inflate(R.layout.item_topic,parent,false);
        TopicViewHolder itemTopicViewHolder=new TopicViewHolder(itemTopic);
        return itemTopicViewHolder;
    }
}
