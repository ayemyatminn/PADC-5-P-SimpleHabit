package com.padcmyanmar.simplehabit.mvp.views;

import com.padcmyanmar.simplehabit.data.vo.SharedParent;

import java.util.List;

/**
 * Created by PC on 6/23/2018.
 */

public interface SeriesView extends BaseView {

    void displaySeriesData(List<SharedParent> data);

    void lunchCurrentDetailScreen();

    void lunchCategoryDetailScreen();

    //void lunchCategoryDetailScreen(String categoryId,String categoryProgramId)
}
