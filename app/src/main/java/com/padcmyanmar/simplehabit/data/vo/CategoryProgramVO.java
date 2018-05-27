package com.padcmyanmar.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by PC on 5/26/2018.
 */

public class CategoryProgramVO implements SharedParent {

    @SerializedName("category-id")
    private String categoryId;

    @SerializedName("title")
    private String title;

    @SerializedName("programs")
    private List<ProgramVO> program;

    public String getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public List<ProgramVO> getProgram() {
        return program;
    }


}
