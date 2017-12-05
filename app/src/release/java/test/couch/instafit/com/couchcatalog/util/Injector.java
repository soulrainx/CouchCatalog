package test.couch.instafit.com.couchcatalog.util;

public class Injector {
    public static CoachDataSourceMain provideCoachDataSourceMain(@NonNull Context context) {
        checkNotNull(context);
        CoachDatabase database = CoachDatabase.getInstance(context);
        return CoachDataSourceMain.getInstance(CoachLocalDataSource.getInstance(new AppExecutors(),database.coachDao()),
                CoachRemoteDataSource.getInstance());
    }
}
