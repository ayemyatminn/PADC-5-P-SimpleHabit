package com.padcmyanmar.simplehabit.mvp.views;

import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;

/**
 * Created by PC on 6/23/2018.
 */

public interface DetailScreenView extends BaseView {

    void displayCurrentDetailScreen(CurrentProgramVO currentProgramVO);

    void displayCategoryDetailScreen(CurrentProgramVO currentProgramVO);


}
