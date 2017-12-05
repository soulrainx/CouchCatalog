package test.couch.instafit.com.couchcatalog.screens.allcoaches;

// Concrete implementation of the Contract for Presenter

import android.support.annotation.NonNull;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.couch.instafit.com.couchcatalog.data.source.remote.CoachResponse;
import test.couch.instafit.com.couchcatalog.data.source.remote.InstaFitApiInterface;

import static com.google.common.base.Preconditions.checkNotNull;

public class AllCoachesPresenter implements AllCoachesContract.Presenter {


    AllCoachesContract.View view;

    public static final String BASE_URL = "https://dev.instafit.com/";
    Retrofit retrofit;

    public AllCoachesPresenter(@NonNull AllCoachesContract.View view) {

        checkNotNull(view, "Attach view cannot be null");

        this.view = view;
        this.view.setPresenter(this);

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
    public void loadCoaches() {

        InstaFitApiInterface apiService = retrofit.create(InstaFitApiInterface.class);


        Call<CoachResponse> call = apiService.getCoaches();
        call.enqueue(new Callback<CoachResponse>() {
            @Override
            public void onResponse(Call<CoachResponse> call, Response<CoachResponse> response) {
                Log.d("Network", response.message());
            }

            @Override
            public void onFailure(Call<CoachResponse> call, Throwable t) {
                Log.e("Network", t.getMessage());
            }
        });

    }

    @Override
    public void start() {
        loadCoaches();
    }
}
