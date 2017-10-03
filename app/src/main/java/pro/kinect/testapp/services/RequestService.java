package pro.kinect.testapp.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import pro.kinect.testapp.models.gsonModels.Request;
import pro.kinect.testapp.utils.TestRequestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static pro.kinect.testapp.utils.Constants.BROADCAST_ACTION;
import static pro.kinect.testapp.utils.Constants.INTENT_SERVICE_NAME;
import static pro.kinect.testapp.utils.Constants.REQUEST_INTENT_DATA_KEY;

/**
 * Created by Arina on 03.10.2017
 */

public class RequestService extends IntentService {

    Retrofit retrofit;

    public RequestService() {
        super(INTENT_SERVICE_NAME);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.test.wellapp.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TestRequestApi testApi = retrofit.create(TestRequestApi.class);

        testApi.getData().enqueue(new Callback<Request>() {
            @Override
            public void onResponse(Call<Request> call, Response<Request> response) {

                if(response.body() != null){
                    sendBroadcast((new Intent(BROADCAST_ACTION))
                            .putExtra(REQUEST_INTENT_DATA_KEY, response.body().getMicrotime()));
                }
            }
            @Override
            public void onFailure(Call<Request> call, Throwable t) {
                sendBroadcast((new Intent(BROADCAST_ACTION))
                        .putExtra(REQUEST_INTENT_DATA_KEY, t.getMessage()));
            }
        });

    }
}
