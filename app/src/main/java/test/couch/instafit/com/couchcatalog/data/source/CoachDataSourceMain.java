package test.couch.instafit.com.couchcatalog.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import test.couch.instafit.com.couchcatalog.data.Coach;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Main class that will serve as Entry point for Data access will be injected according to the used source set
 * <p>
 * Contain the local and Remote implementations of CoachDataSource
 */

public class CoachDataSourceMain implements CoachDataSource {

    private static CoachDataSourceMain INSTANCE;
    CoachDataSource localDataSource;
    CoachDataSource remoteDataSource;


    // Prevent direct instantiation.
    private CoachDataSourceMain(@NonNull CoachDataSource coachDataSourceLocal,
                                @NonNull CoachDataSource coachDataSourceRemote) {
        this.localDataSource = checkNotNull(coachDataSourceLocal);
        this.remoteDataSource = checkNotNull(coachDataSourceRemote);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param coachDataSourceLocal  the backend data source
     * @param coachDataSourceRemote the device storage data source
     * @return the {@link CoachDataSourceMain} instance
     */
    public static CoachDataSourceMain getInstance(CoachDataSource coachDataSourceLocal,
                                                  CoachDataSource coachDataSourceRemote) {
        if (INSTANCE == null) {
            INSTANCE = new CoachDataSourceMain(coachDataSourceLocal, coachDataSourceRemote);
        }
        return INSTANCE;
    }


    @Override
    public void saveCoach(@NonNull Coach coach) {

    }

    @Override
    public void deleteAllCoaches() {

    }

    @Override
    public void getAllCoaches(@NonNull final GetCoachesCallback callback) {

        checkNotNull(callback);

        //Check local Room
        localDataSource.getAllCoaches(new GetCoachesCallback() {
            @Override
            public void onCoachesLoaded(List<Coach> coaches) {
                // Local Data Available send it back to caller
                callback.onCoachesLoaded(coaches);
            }

            @Override
            public void onNoData() {


                // No local Data Call Remote
                remoteDataSource.getAllCoaches(new GetCoachesCallback() {
                    @Override
                    public void onCoachesLoaded(List<Coach> coaches) {
                        //Remote coaches fetched send it back to caller
                        refreshLocalDataSource(coaches);
                        callback.onCoachesLoaded(coaches);
                    }

                    @Override
                    public void onNoData() {
                        // No data
                        callback.onNoData();
                    }
                });

            }
        });
    }

    private void refreshLocalDataSource(List<Coach> coaches) {
        localDataSource.deleteAllCoaches();
        for (Coach task : coaches) {
            localDataSource.saveCoach(task);
        }
    }
}
