package com.padcmyanmar.simplehabit.events;

import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;

import java.util.List;

/**
 * Created by PC on 5/26/2018.
 */

public class LoadCurrentProgramEvent {

    private List<CurrentProgramVO> mCurrentProgramList;

    public LoadCurrentProgramEvent(List<CurrentProgramVO> mCurrentProgramList) {
        this.mCurrentProgramList = mCurrentProgramList;
    }

    public List<CurrentProgramVO> getmCurrentProgramList() {
        return mCurrentProgramList;
    }
}
