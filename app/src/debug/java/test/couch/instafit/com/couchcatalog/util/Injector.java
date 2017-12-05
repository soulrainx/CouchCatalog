package test.couch.instafit.com.couchcatalog.util;


import android.content.Context;
import android.support.annotation.NonNull;

import test.couch.instafit.com.couchcatalog.data.source.CoachDataSourceMain;
import test.couch.instafit.com.couchcatalog.data.source.local.CoachDatabase;
import test.couch.instafit.com.couchcatalog.data.source.local.CoachLocalDataSource;
import test.couch.instafit.com.couchcatalog.data.source.remote.CoachRemoteDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

public class Injector {

    public static CoachDataSourceMain provideCoachDataSourceMain(@NonNull Context context) {
        checkNotNull(context);
        CoachDatabase database = CoachDatabase.getInstance(context);
        return CoachDataSourceMain.getInstance(CoachLocalDataSource.getInstance(new AppExecutors(),database.coachDao()),
                CoachRemoteDataSource.getInstance());
    }
}
