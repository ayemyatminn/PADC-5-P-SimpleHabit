package com.padcmyanmar.simplehabit.networks.response;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.simplehabit.data.vo.TopicesVO;

import java.util.List;

/**
 * Created by PC on 5/25/2018.
 */

public class GetTopicResponse {
    private int code;
    private String message;
    private String apiVersion;
    private int page;
    @SerializedName("topics")
    private List<TopicesVO> topicList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<TopicesVO> getTopicList() {
        return topicList;
    }
}
