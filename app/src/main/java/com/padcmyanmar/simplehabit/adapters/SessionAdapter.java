package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.SessionVO;
import com.padcmyanmar.simplehabit.viewholders.SessionViewHolder;

/**
 * Created by PC on 6/3/2018.
 */

public class SessionAdapter extends BaseRecyclerAdapter<SessionViewHolder,SessionVO> {
    public SessionAdapter(Context context) {
        super(context);
    }

    @Override
    public SessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View itemsession=layoutInflater.inflate(R.layout.item_sessions,parent,false);
        SessionViewHolder sessionViewHolder=new SessionViewHolder(itemsession);
        return sessionViewHolder;
    }

    @Override
    public void onBindViewHolder(SessionViewHolder holder, int position) {
        holder.setData(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
