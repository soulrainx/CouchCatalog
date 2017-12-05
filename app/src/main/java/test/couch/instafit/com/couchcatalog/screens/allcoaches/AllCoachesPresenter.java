package test.couch.instafit.com.couchcatalog.screens.allcoaches;

// Concrete implementation of the Contract for Presenter

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Retrofit;
import test.couch.instafit.com.couchcatalog.data.Coach;
import test.couch.instafit.com.couchcatalog.data.source.CoachDataSource;
import test.couch.instafit.com.couchcatalog.data.source.CoachDataSourceMain;

import static com.google.common.base.Preconditions.checkNotNull;

public class AllCoachesPresenter implements AllCoachesContract.Presenter {

    // Attached View
    private final AllCoachesContract.View view;

    // Main Entry caller between presenter and Data Local and Remote
    private final CoachDataSourceMain coachDataSourceMain;

    Retrofit retrofit;

    public AllCoachesPresenter(@NonNull AllCoachesContract.View view, @NonNull CoachDataSourceMain coachDataSourceMain) {

        this.view = checkNotNull(view, "Attach view cannot be null");
        this.coachDataSourceMain = checkNotNull(coachDataSourceMain, "coachDataSourceMain cannot be null");;

        this.view.setPresenter(this);
    }

    @Override
    public void loadCoaches() {

        coachDataSourceMain.getAllCoaches(new CoachDataSource.GetCoachesCallback() {
            @Override
            public void onCoachesLoaded(List<Coach> coaches) {

            }

            @Override
            public void onNoData() {

            }
        });
    }

    @Override
    public void start() {
        loadCoaches();
    }
}
