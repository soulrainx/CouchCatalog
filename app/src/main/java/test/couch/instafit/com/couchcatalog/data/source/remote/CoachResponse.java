package test.couch.instafit.com.couchcatalog.data.source.remote;

import android.support.annotation.Nullable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import test.couch.instafit.com.couchcatalog.data.Coach;

public class CoachResponse {

    @Nullable
    @SerializedName("data")
    @Expose
    private List<Coach> data = null;

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("message")
    @Expose
    private String message;

    @Nullable
    public List<Coach> getData() {
        return data;
    }

    public void setData(List<Coach> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
