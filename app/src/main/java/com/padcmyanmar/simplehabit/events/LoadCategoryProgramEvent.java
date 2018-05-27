package com.padcmyanmar.simplehabit.events;

import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;

import java.util.List;

/**
 * Created by PC on 5/26/2018.
 */

public class LoadCategoryProgramEvent {
    private List<CategoryProgramVO> mCategoryProgramList;

    public LoadCategoryProgramEvent(List<CategoryProgramVO> mCategoryProgramList) {
        this.mCategoryProgramList = mCategoryProgramList;
    }

    public List<CategoryProgramVO> getmCategoryProgramList() {
        return mCategoryProgramList;
    }
}
