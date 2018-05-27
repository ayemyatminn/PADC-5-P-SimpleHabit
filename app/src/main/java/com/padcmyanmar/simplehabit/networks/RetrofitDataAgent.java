package com.padcmyanmar.simplehabit.networks;

import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.simplehabit.events.LoadCategoryProgramEvent;
import com.padcmyanmar.simplehabit.events.LoadCurrentProgramEvent;
import com.padcmyanmar.simplehabit.events.LoadTopicEvent;
import com.padcmyanmar.simplehabit.events.RestApiEvents;
import com.padcmyanmar.simplehabit.networks.response.GetCategoryProgramResponse;
import com.padcmyanmar.simplehabit.networks.response.GetCurrentProgramResponse;
import com.padcmyanmar.simplehabit.networks.response.GetTopicResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC on 5/25/2018.
 */

public class RetrofitDataAgent implements SimpleHabitDataAgent {

    private static RetrofitDataAgent objInstance;

    private SimpleHabitApi simpleHabitApi;

    public static RetrofitDataAgent getObjInstance() {
        if (objInstance==null){
            objInstance=new RetrofitDataAgent();
        }
        return objInstance;
    }

    private RetrofitDataAgent() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        simpleHabitApi=retrofit.create(SimpleHabitApi.class);
    }

    @Override
    public void loadTopic() {

        Call<GetTopicResponse> getTopicResponseCall=simpleHabitApi.loadTopic("b002c7e1a528b7cb460933fc2875e916",1);
        getTopicResponseCall.enqueue(new Callback<GetTopicResponse>() {
            @Override
            public void onResponse(Call<GetTopicResponse> call, Response<GetTopicResponse> response) {
                GetTopicResponse getTopicResponse=response.body();
                if (getTopicResponse !=null && getTopicResponse.getTopicList().size()>0){
                    RestApiEvents.TopicDataLoadedEvent event=new RestApiEvents.TopicDataLoadedEvent(getTopicResponse.getPage(),getTopicResponse.getTopicList());
                    EventBus.getDefault().post(event);
                }else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetTopicResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });

    }

    @Override
    public void loadCurrentProgram() {

        Call<GetCurrentProgramResponse> getCurrentProgramResponseCall=simpleHabitApi.loadCurrentProgram("b002c7e1a528b7cb460933fc2875e916",1);
        getCurrentProgramResponseCall.enqueue(new Callback<GetCurrentProgramResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
                GetCurrentProgramResponse getCurrentProgramResponse=response.body();
                if (getCurrentProgramResponse !=null && getCurrentProgramResponse.getCurrentProgram()!=null){
                    RestApiEvents.CurrentDataLoadedEvent event=new RestApiEvents.CurrentDataLoadedEvent(getCurrentProgramResponse.getCode(),getCurrentProgramResponse.getCurrentProgram());
                    EventBus.getDefault().post(event);
                }else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

    @Override
    public void loadCategoryProgram() {
        Call<GetCategoryProgramResponse> getCategoryProgramResponseCall=simpleHabitApi.loadCategoryProgram("b002c7e1a528b7cb460933fc2875e916",1);
        getCategoryProgramResponseCall.enqueue(new Callback<GetCategoryProgramResponse>() {
            @Override
            public void onResponse(Call<GetCategoryProgramResponse> call, Response<GetCategoryProgramResponse> response) {
                GetCategoryProgramResponse getCategoryProgramResponse=response.body();
                if (getCategoryProgramResponse !=null && getCategoryProgramResponse.getCategoryProgram().size()>0){
                    RestApiEvents.CategoryDataLoadedEvent event=new RestApiEvents.CategoryDataLoadedEvent(getCategoryProgramResponse.getPage(),getCategoryProgramResponse.getCategoryProgram());
                    EventBus.getDefault().post(event);
                }else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCategoryProgramResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });

    }
}
