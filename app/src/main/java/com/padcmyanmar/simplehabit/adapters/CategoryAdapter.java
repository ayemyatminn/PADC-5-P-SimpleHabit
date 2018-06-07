package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramActionDelegate;
import com.padcmyanmar.simplehabit.viewholders.CategoryViewHolder;
import com.padcmyanmar.simplehabit.viewholders.TopicViewHolder;

import butterknife.ButterKnife;

/**
 * Created by PC on 5/27/2018.
 */

public class CategoryAdapter extends BaseRecyclerAdapter<CategoryViewHolder,CategoryProgramVO> {

    private CategoryProgramActionDelegate mCategoryProgramActionDelegate;

    public CategoryAdapter(Context context, CategoryProgramActionDelegate categoryProgramActionDelegate) {
        super(context);
        mCategoryProgramActionDelegate=categoryProgramActionDelegate;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemCategory=inflater.inflate(R.layout.item_category,parent,false);
        CategoryViewHolder categoryViewHolder=new CategoryViewHolder(itemCategory,mCategoryProgramActionDelegate);
        return categoryViewHolder;
    }


}
