package com.padcmyanmar.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by PC on 5/26/2018.
 */

public class CurrentProgramVO implements SharedParent {
    @SerializedName("program-id")
    private String programId;

    @SerializedName("title")
    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    @SerializedName("background")
    private String background;

    @SerializedName("average-lengths")
    private List<Integer> averageLength;

    @SerializedName("description")
    private String description;

    @SerializedName("sessions")
    private List<SessionVO> session;

    public String getProgramId() {
        return programId;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public String getBackground() {
        return background;
    }

    public List<Integer> getAverageLength() {
        return averageLength;
    }

    public String getDescription() {
        return description;
    }

    public List<SessionVO> getSession() {
        return session;
    }


}
