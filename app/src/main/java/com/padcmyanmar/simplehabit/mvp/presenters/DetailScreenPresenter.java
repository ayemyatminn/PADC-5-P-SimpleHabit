package com.padcmyanmar.simplehabit.mvp.presenters;

import com.padcmyanmar.simplehabit.data.model.SimpleHabitModel;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;
import com.padcmyanmar.simplehabit.data.vo.ProgramVO;
import com.padcmyanmar.simplehabit.mvp.views.DetailScreenView;

/**
 * Created by PC on 6/23/2018.
 */

public class DetailScreenPresenter extends BasePresenter<DetailScreenView> {

    private DetailScreenView mView;

    public DetailScreenPresenter(DetailScreenView view) {
        super(view);
        mView=view;
    }

    public void onFinishUIComponentSetUpForCurrent(){
        CurrentProgramVO currentProgram = SimpleHabitModel.getSobjInstance().getCurrentProgram();
        mView.displayCurrentDetailScreen(currentProgram);
    }

    public void onFinishUIComponentsetUpForCategory(String categoryId,String categoryProgramId){
        ProgramVO categoryProgram = SimpleHabitModel.getSobjInstance().getProgram(categoryId, categoryProgramId);

        mView.displayCategoryDetailScreen(categoryProgram);
    }
}
