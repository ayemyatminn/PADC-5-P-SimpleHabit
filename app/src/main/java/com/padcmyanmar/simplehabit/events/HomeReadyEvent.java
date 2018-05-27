package com.padcmyanmar.simplehabit.events;

import com.padcmyanmar.simplehabit.data.vo.SharedParent;

import java.util.List;

/**
 * Created by PC on 5/26/2018.
 */

public class HomeReadyEvent {
    private List<SharedParent> mHome;

    public HomeReadyEvent(List<SharedParent> mHome) {
        this.mHome = mHome;
    }

    public List<SharedParent> getmHome() {
        return mHome;
    }
}
