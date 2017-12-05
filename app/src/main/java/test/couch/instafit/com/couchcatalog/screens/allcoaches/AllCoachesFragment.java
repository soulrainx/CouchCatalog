package test.couch.instafit.com.couchcatalog.screens.allcoaches;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.couch.instafit.com.couchcatalog.mock.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllCoachesFragment extends Fragment {


    public AllCoachesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_coaches, container, false);
    }

}
