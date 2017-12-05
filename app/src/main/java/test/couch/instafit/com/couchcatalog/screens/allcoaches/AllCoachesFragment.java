package test.couch.instafit.com.couchcatalog.screens.allcoaches;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import test.couch.instafit.com.couchcatalog.R;
import test.couch.instafit.com.couchcatalog.data.source.remote.CoachResponse;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllCoachesFragment extends Fragment implements AllCoachesContract.View {

    AllCoachesContract.Presenter presenter;

    public AllCoachesFragment() {
        // Requires empty public constructor
    }

    public static AllCoachesFragment newInstance() {
        return new AllCoachesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_coaches, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void showCoaches(List<CoachResponse> coaches) {

    }

    @Override
    public void setPresenter(@NonNull AllCoachesContract.Presenter presenter) {
        this.presenter = checkNotNull(presenter);
    }
}
