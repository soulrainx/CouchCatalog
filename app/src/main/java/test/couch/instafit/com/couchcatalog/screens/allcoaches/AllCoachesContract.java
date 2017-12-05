package test.couch.instafit.com.couchcatalog.screens.allcoaches;

import java.util.List;

import test.couch.instafit.com.couchcatalog.BasePresenter;
import test.couch.instafit.com.couchcatalog.BaseView;
import test.couch.instafit.com.couchcatalog.data.source.remote.CoachResponse;

public interface AllCoachesContract {

    // Operations performed by View
    interface View extends BaseView<Presenter> {

        void showCoaches(List<CoachResponse> coaches);

    }

    // Operations Presenter should perform
    interface Presenter extends BasePresenter {

        void loadCoaches();

    }
}
