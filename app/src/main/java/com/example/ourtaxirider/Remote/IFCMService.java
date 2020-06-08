package com.example.ourtaxirider.Remote;

import com.example.ourtaxirider.Model.FCMResponse;
import com.example.ourtaxirider.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAcsWf7Dw:APA91bFfxwhOUYh1avYnBpZJbd0jkUEl9Hvs1nUq3Y4OpO0Gsywtt-NhCk_DsyEtIFRhAUOqs8m-kmtIuJ0T_hP40JBXXmKpvlgbhMT8ywfk9mnjVgD1jEfWL_ux-k-BN4v4OLtVK9Up"
    })
    @POST("fcm/send")
    Call<FCMResponse> sendMessage (@Body Sender body);
}
