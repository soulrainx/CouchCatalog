package test.couch.instafit.com.couchcatalog.data.source.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.couch.instafit.com.couchcatalog.data.Coach;
import test.couch.instafit.com.couchcatalog.data.source.CoachDataSource;

import static test.couch.instafit.com.couchcatalog.data.source.remote.InstaFitApiInterface.BASE_URL;


public class CoachRemoteDataSource implements CoachDataSource {


    private static CoachRemoteDataSource INSTANCE;
    private Retrofit retrofit;

    public static CoachRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CoachRemoteDataSource();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private CoachRemoteDataSource() {

        // Construct Retrofit
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);
        OkHttpClient okHttpClient = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) // Base Url or Domain
                .addConverterFactory(GsonConverterFactory.create()) // Serializer
                .client(okHttpClient) // For logging
                .build();

    }


    @Override
    public void saveCoach(@NonNull Coach coach) {

    }

    @Override
    public void deleteAllCoaches() {

    }

    @Override
    public void getAllCoaches(@NonNull final GetCoachesCallback callback) {

        InstaFitApiInterface apiService = retrofit.create(InstaFitApiInterface.class);

        Call<CoachResponse> call = apiService.getCoaches();
        call.enqueue(new Callback<CoachResponse>() {
            @Override
            public void onResponse(Call<CoachResponse> call, Response<CoachResponse> response) {
                Log.d("Network", response.message());
                callback.onCoachesLoaded(response.body().getData());
            }

            @Override
            public void onFailure(Call<CoachResponse> call, Throwable t) {
                Log.e("Network", t.getMessage());
                callback.onNoData();
            }
        });
    }
}
