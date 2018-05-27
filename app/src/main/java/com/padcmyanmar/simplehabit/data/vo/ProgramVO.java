package com.padcmyanmar.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by PC on 5/26/2018.
 */

public class ProgramVO {
    @SerializedName("program-id")
    private String programId;

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("average-lengths")
    private List<Integer> averageLengths;

    @SerializedName("description")
    private String description;

    @SerializedName("sessions")
    private List<SessionVO> sessions;

    public String getProgramId() {
        return programId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Integer> getAverageLengths() {
        return averageLengths;
    }

    public String getDescription() {
        return description;
    }

    public List<SessionVO> getSessions() {
        return sessions;
    }
}

