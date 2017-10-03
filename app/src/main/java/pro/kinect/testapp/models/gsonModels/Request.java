package pro.kinect.testapp.models.gsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("microtime")
    @Expose
    private String microtime;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getMicrotime() {
        return microtime;
    }

    public void setMicrotime(String microtime) {
        this.microtime = microtime;
    }

}
