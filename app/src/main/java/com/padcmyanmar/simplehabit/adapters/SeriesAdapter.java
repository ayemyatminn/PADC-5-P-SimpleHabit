package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;
import com.padcmyanmar.simplehabit.data.vo.SharedParent;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramActionDelegate;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramActionDelegates;
import com.padcmyanmar.simplehabit.viewholders.BaseViewHolder;
import com.padcmyanmar.simplehabit.viewholders.CategoryViewHolder;
import com.padcmyanmar.simplehabit.viewholders.CurrentItemViewHolder;
import com.padcmyanmar.simplehabit.viewholders.SeriesViewHolder;
import com.padcmyanmar.simplehabit.viewholders.TopicViewHolder;

/**
 * Created by PC on 5/27/2018.
 */

public class SeriesAdapter extends BaseRecyclerAdapter<BaseViewHolder,SharedParent> {

    private static final int VT_CURRENT = 1;
    private static final int VT_CATEGORY = 2;
    private static final int VT_TOPIC = 3;

    private LayoutInflater mLayoutInflater;
    private Context mContext;

    private CategoryProgramActionDelegate mCategoryProgramActionDelegate;

    private CurrentProgramActionDelegates mCurrentProgramActionDelegates;

    public SeriesAdapter(Context context,CategoryProgramActionDelegate categoryProgramActionDelegate,CurrentProgramActionDelegates currentProgramActionDelegates) {
        super(context);
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
        mCategoryProgramActionDelegate=categoryProgramActionDelegate;
        mCurrentProgramActionDelegates=currentProgramActionDelegates;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VT_CURRENT) {
            View itemView = mLayoutInflater.inflate(R.layout.item_current, parent, false);
            return new CurrentItemViewHolder(itemView,mCurrentProgramActionDelegates);
        } else if (viewType == VT_CATEGORY) {
            View itemView = mLayoutInflater.inflate(R.layout.item_category, parent, false);
            return new CategoryViewHolder(itemView,mCategoryProgramActionDelegate);
        } else {
            View itemView = mLayoutInflater.inflate(R.layout.item_topic, parent, false);
            return new TopicViewHolder(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (mData.get(position) instanceof CurrentProgramVO){
            return VT_CURRENT;
        }else if (mData.get(position) instanceof CategoryProgramVO){
            return VT_CATEGORY;
        }else return VT_TOPIC;
    }
}
