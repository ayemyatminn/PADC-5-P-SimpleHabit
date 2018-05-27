package com.padcmyanmar.simplehabit.data.model;

import com.padcmyanmar.simplehabit.data.vo.SharedParent;
import com.padcmyanmar.simplehabit.data.vo.TopicesVO;
import com.padcmyanmar.simplehabit.events.HomeReadyEvent;
import com.padcmyanmar.simplehabit.events.LoadCategoryProgramEvent;
import com.padcmyanmar.simplehabit.events.LoadCurrentProgramEvent;
import com.padcmyanmar.simplehabit.events.LoadTopicEvent;
import com.padcmyanmar.simplehabit.events.RestApiEvents;
import com.padcmyanmar.simplehabit.networks.RetrofitDataAgent;
import com.padcmyanmar.simplehabit.networks.SimpleHabitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PC on 5/25/2018.
 */

public class SimpleHabitModel {

    private static SimpleHabitModel sobjInstance;

    private SimpleHabitDataAgent mSimpleHabitDataAgent;

    private List<SharedParent> homeScreen;

    private SimpleHabitModel() {

        mSimpleHabitDataAgent= RetrofitDataAgent.getObjInstance();
        homeScreen=new ArrayList<>();
        EventBus.getDefault().register(this);

    }

    public static SimpleHabitModel getSobjInstance() {
        if (sobjInstance==null){
            sobjInstance=new SimpleHabitModel();
        }
        return sobjInstance;
    }



    public void loadData(){
        mSimpleHabitDataAgent.loadCurrentProgram();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoadCurrent(RestApiEvents.CurrentDataLoadedEvent event){
        homeScreen.add(event.getLoadCurrent());
        mSimpleHabitDataAgent.loadCategoryProgram();
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoadcategory(RestApiEvents.CategoryDataLoadedEvent event){
        homeScreen.addAll(event.getLoadCategory());
        mSimpleHabitDataAgent.loadTopic();
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoadTopic(RestApiEvents.TopicDataLoadedEvent event){
        homeScreen.addAll(event.getLoadTopices());
        HomeReadyEvent homeReadyEvent=new HomeReadyEvent(homeScreen);
        EventBus.getDefault().post(homeReadyEvent);
    }


}
