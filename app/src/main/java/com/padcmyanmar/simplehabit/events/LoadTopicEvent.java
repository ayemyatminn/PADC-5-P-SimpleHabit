package com.padcmyanmar.simplehabit.events;

import com.padcmyanmar.simplehabit.data.vo.TopicesVO;

import java.util.List;

/**
 * Created by PC on 5/25/2018.
 */

public class LoadTopicEvent {

    private List<TopicesVO> mTopicList;

    public LoadTopicEvent(List<TopicesVO> mTopicList) {
        this.mTopicList = mTopicList;
    }

    public List<TopicesVO> getmTopicList() {
        return mTopicList;
    }
}
