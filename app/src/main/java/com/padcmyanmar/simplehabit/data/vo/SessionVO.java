package com.padcmyanmar.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PC on 5/26/2018.
 */

public class SessionVO {
    @SerializedName("session-id")
     private String sessionId;

    @SerializedName("title")
     private String title;

    @SerializedName("length-in-seconds")
     private int lengthInSecond;

    @SerializedName("file-path")
     private String filePath;

    public String getSessionId() {
        return sessionId;
    }

    public String getTitle() {
        return title;
    }

    public int getLengthInSecond() {
        return lengthInSecond;
    }

    public String getFilePath() {
        return filePath;
    }
}
