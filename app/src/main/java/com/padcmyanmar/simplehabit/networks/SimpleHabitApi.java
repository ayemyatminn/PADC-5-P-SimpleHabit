package com.padcmyanmar.simplehabit.networks;

import com.padcmyanmar.simplehabit.networks.response.GetCategoryProgramResponse;
import com.padcmyanmar.simplehabit.networks.response.GetCurrentProgramResponse;
import com.padcmyanmar.simplehabit.networks.response.GetTopicResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by PC on 5/25/2018.
 */

public interface SimpleHabitApi {
    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicResponse> loadTopic(@Field("access_token") String access_token, @Field("page") int page);

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentProgramResponse> loadCurrentProgram(@Field("access_token") String access_token, @Field("page") int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoryProgramResponse> loadCategoryProgram(@Field("access_token") String access_token, @Field("page") int page);
}
