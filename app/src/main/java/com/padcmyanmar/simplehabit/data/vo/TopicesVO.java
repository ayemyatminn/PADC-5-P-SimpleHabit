package com.padcmyanmar.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.simplehabit.data.vo.SharedParent;

/**
 * Created by PC on 5/25/2018.
 */

public class TopicesVO implements SharedParent {

    @SerializedName("topic-name")
    private String topicName;

    @SerializedName("topic-desc")
    private String topicDescription;

    @SerializedName("icon")
    private String topicIcon;

    @SerializedName("background")
    private String topicBackgroundImage;

    public String getTopicName() {
        return topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public String getTopicIcon() {
        return topicIcon;
    }

    public String getTopicBackgroundImage() {
        return topicBackgroundImage;
    }
}
