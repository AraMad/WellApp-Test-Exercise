package pro.kinect.testapp.utils;

import pro.kinect.testapp.models.gsonModels.Request;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Arina on 03.10.2017
 */

public interface TestRequestApi {
    @GET("/api/get")
    Call<Request> getData();
}
