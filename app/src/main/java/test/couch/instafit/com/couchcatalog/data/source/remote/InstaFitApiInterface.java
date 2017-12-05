package test.couch.instafit.com.couchcatalog.data.source.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import test.couch.instafit.com.couchcatalog.data.Coach;

public interface API {

    // Request method and URL specified in the annotation
    @GET("api/v3.1/user/697257/a6kt_yP5y8opx9sz_9Pe/catalog_of/coaches")
    Call<List<Coach>> getCoaches();
}
