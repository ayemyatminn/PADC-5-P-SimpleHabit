package com.padcmyanmar.simplehabit.data.model;

import android.util.ArrayMap;

import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;
import com.padcmyanmar.simplehabit.data.vo.ProgramVO;
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

    private Map<String, ProgramVO> mProgram;

    private SimpleHabitModel() {

        mSimpleHabitDataAgent = RetrofitDataAgent.getObjInstance();
        homeScreen = new ArrayList<>();
        mProgram = new ArrayMap<>();
        EventBus.getDefault().register(this);

    }

    public static SimpleHabitModel getSobjInstance() {
        if (sobjInstance == null) {
            sobjInstance = new SimpleHabitModel();
        }
        return sobjInstance;
    }


    public void loadData() {
        mSimpleHabitDataAgent.loadCurrentProgram();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoadCurrent(RestApiEvents.CurrentDataLoadedEvent event) {
        homeScreen.add(event.getLoadCurrent());
        mSimpleHabitDataAgent.loadCategoryProgram();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoadcategory(RestApiEvents.CategoryDataLoadedEvent event) {
        homeScreen.addAll(event.getLoadCategory());
        mProgram.put(event.getLoadCategory().get(0).getProgram().get(0).getProgramId(), event.getLoadCategory().get(0).getProgram().get(0));
        mSimpleHabitDataAgent.loadTopic();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoadTopic(RestApiEvents.TopicDataLoadedEvent event) {
        homeScreen.addAll(event.getLoadTopices());
        HomeReadyEvent homeReadyEvent = new HomeReadyEvent(homeScreen);
        EventBus.getDefault().post(homeReadyEvent);
    }

    public List<SharedParent> getHomeScreen() {
        return homeScreen;
    }

    public CurrentProgramVO getCurrentProgram() {
        for (SharedParent obj : homeScreen) {
            if (obj instanceof CurrentProgramVO) return (CurrentProgramVO) obj;
        }
        return null;
    }

    public ProgramVO getProgram(String categoryId, String categoryProgramId) {
        for (int i = 0; i < homeScreen.size(); i++) {
            if (homeScreen.get(i) instanceof CategoryProgramVO) {
                if (((CategoryProgramVO) homeScreen.get(i)).getCategoryId().equals(categoryId)) {
                    for (int j = 0; j < ((CategoryProgramVO) homeScreen.get(i)).getProgram().size(); j++) {
                        if (((CategoryProgramVO) homeScreen.get(i)).getProgram().get(j).getProgramId().equals(categoryProgramId)) {
                            return ((CategoryProgramVO) homeScreen.get(i)).getProgram().get(j);
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
