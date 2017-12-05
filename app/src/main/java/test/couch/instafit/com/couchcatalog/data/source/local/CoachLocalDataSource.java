package test.couch.instafit.com.couchcatalog.data.source.local;

import android.support.annotation.NonNull;

import java.util.List;

import test.couch.instafit.com.couchcatalog.data.Coach;
import test.couch.instafit.com.couchcatalog.data.source.CoachDataSource;
import test.couch.instafit.com.couchcatalog.util.AppExecutors;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Concrete implementation of DataSource operations for Local Store Room
 */
public class CoachLocalDataSource implements CoachDataSource {


    private static volatile CoachLocalDataSource INSTANCE;

    private CoachDao coachDao;

    private AppExecutors mAppExecutors;

    // Prevent direct instantiation.
    private CoachLocalDataSource(@NonNull AppExecutors appExecutors,
                                 @NonNull CoachDao tasksDao) {
        mAppExecutors = appExecutors;
        coachDao = tasksDao;
    }

    public static CoachLocalDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                   @NonNull CoachDao tasksDao) {
        if (INSTANCE == null) {
            synchronized (CoachLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CoachLocalDataSource(appExecutors, tasksDao);
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public void saveCoach(@NonNull final Coach coach) {
        checkNotNull(coach);

        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                coachDao.insertCoach(coach);
            }
        };
        mAppExecutors.diskIO().execute(saveRunnable);
    }

    @Override
    public void deleteAllCoaches() {
        Runnable deleteRunnable = new Runnable() {
            @Override
            public void run() {
                coachDao.deleteCoaches();
            }
        };

        mAppExecutors.diskIO().execute(deleteRunnable);
    }

    @Override
    public void getAllCoaches(@NonNull final GetCoachesCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Coach> coaches = coachDao.getCoaches();
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (coaches.isEmpty()) {
                            // This will be called if the table is new or just empty.
                            callback.onNoData();
                        } else {
                            callback.onCoachesLoaded(coaches);
                        }
                    }
                });
            }
        };

        mAppExecutors.diskIO().execute(runnable);
    }
}
