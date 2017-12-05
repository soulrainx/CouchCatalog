package test.couch.instafit.com.couchcatalog.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import test.couch.instafit.com.couchcatalog.data.Coach;

/**
 *  Main entry point to Data operations by Tests or code
 *
 *  implemented by CoachLocalDataSource, CoachRemoteDataSource and
 */
public interface CoachDataSource {

    // Callback for Remote call
    interface LoadCoachesCallback {
        void onCoachesLoaded(List<Coach> coaches);

        void onNoData();
    }

    // Callback for Local call
    interface GetCoachesCallback {
        void onCoachesLoaded(List<Coach> coaches);

        void onNoData();
    }

    // Data operations to perform as

    // Save Coach on Room
    void saveCoach(@NonNull Coach coach);

    // Delete all Coaches from Room
    void deleteAllCoaches();

    // Get Coaches from Room or network depending who implements it
    void getAllCoaches(@NonNull GetCoachesCallback callback);

}
