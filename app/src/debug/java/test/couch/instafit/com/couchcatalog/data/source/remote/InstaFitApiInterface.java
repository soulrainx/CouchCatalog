package test.couch.instafit.com.couchcatalog.data.source.remote;


import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InstaFitApiInterface {

    String BASE_URL = "https://dev.instafit.com/";

    // Request method and URL specified in the annotation
    @NonNull
    @GET("api/v3.1/user/697257/a6kt_yP5y8opx9sz_9Pe/catalog_of/coaches")
    Call<CoachResponse> getCoaches();
}
