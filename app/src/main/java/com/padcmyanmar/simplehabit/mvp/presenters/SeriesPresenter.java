package com.padcmyanmar.simplehabit.mvp.presenters;

import com.padcmyanmar.simplehabit.data.model.SimpleHabitModel;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramActionDelegate;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramActionDelegates;
import com.padcmyanmar.simplehabit.events.HomeReadyEvent;
import com.padcmyanmar.simplehabit.mvp.views.SeriesView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by PC on 6/23/2018.
 */

public class SeriesPresenter extends BasePresenter<SeriesView> implements CategoryProgramActionDelegate,CurrentProgramActionDelegates{

    private SeriesView mView;

    public SeriesPresenter(SeriesView view) {
        super(view);
        mView=view;
    }

    public void onFinishUIComponentSetUp(){
        SimpleHabitModel.getSobjInstance().loadData();
    }

    public void onStart(){
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    public void onStop(){
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHomeDataLoaded(HomeReadyEvent event){
        if (event.getmHome()==null){
            mView.displayErrorMessage("Empty Data");
        }else {
            mView.displaySeriesData(event.getmHome());
        }
    }

    @Override
    public void onTapCurrentProgramItem() {
        mView.lunchCurrentDetailScreen();
    }

    @Override
    public void onTapCategoryProgramItem(String categoryId, String categoryProgramId) {
        mView.lunchCategoryDetailScreen(categoryId,categoryProgramId);
    }
}
