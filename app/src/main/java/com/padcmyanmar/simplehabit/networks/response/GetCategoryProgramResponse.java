package com.padcmyanmar.simplehabit.networks.response;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;

import java.util.List;

/**
 * Created by PC on 5/26/2018.
 */

public class GetCategoryProgramResponse {
    private int code;
    private String message;
    private String apiVersion;
    private int page;
    @SerializedName("categoriesPrograms")
    private List<CategoryProgramVO> categoryProgram;

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

    public List<CategoryProgramVO> getCategoryProgram() {
        return categoryProgram;
    }
}
