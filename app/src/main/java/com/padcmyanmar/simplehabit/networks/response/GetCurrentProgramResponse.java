package com.padcmyanmar.simplehabit.networks.response;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;

import java.util.List;

/**
 * Created by PC on 5/26/2018.
 */

public class GetCurrentProgramResponse {
    private int code;
    private String message;
    private String apiVersion;
    @SerializedName("currentProgram")
    private CurrentProgramVO currentProgram;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }
}
