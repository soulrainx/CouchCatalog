package test.couch.instafit.com.couchcatalog.screens.allcoaches;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.couch.instafit.com.couchcatalog.R;
import test.couch.instafit.com.couchcatalog.data.Coach;
import test.couch.instafit.com.couchcatalog.util.SimplePageTransformer;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllCoachesFragment extends Fragment implements AllCoachesContract.View {

    AllCoachesContract.Presenter presenter;

    ViewPager viewPager;
    @Nullable
    AllCoachesFragmentAdapter adapter;

    @Nullable
    @VisibleForTesting
    public ProgressDialog mProgressDialog;

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
        View view = inflater.inflate(R.layout.fragment_all_coaches, container, false);

        viewPager = view.findViewById(R.id.fragment_all_coaches_viewpager);

        viewPager.setAdapter(adapter = new AllCoachesFragmentAdapter(getFragmentManager(), new ArrayList<Coach>(0)));  //set ViewPager adapter

        SimplePageTransformer pageTransformer = new SimplePageTransformer()
                .addViewToParallax(new SimplePageTransformer.ParallaxTransformInformation(R.id.coach_info_name, 0.8f, 0.5f))
                .addViewToParallax(new SimplePageTransformer.ParallaxTransformInformation(R.id.coach_info_image, 1f, 1f))
                .addViewToParallax(new SimplePageTransformer.ParallaxTransformInformation(R.id.coach_info_description_webview, 1.3f, 2f));


        viewPager.setPageTransformer(true, pageTransformer); //set page transformer

        setHasOptionsMenu(true);

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_all_coaches_fragment_clear:
                presenter.clearStoredCoaches();
                break;
            case R.id.menu_all_coaches_fragment_load:
                presenter.loadCoaches();
                break;
        }
        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.all_coaches_fragment_menu, menu);
    }

    @Override
    public void showCoaches(List<Coach> coaches) {
        adapter.replaceData(coaches);
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            showProgressDialog();
        } else {
            hideProgressDialog();
        }
    }

    @Override
    public void setPresenter(@NonNull AllCoachesContract.Presenter presenter) {
        this.presenter = checkNotNull(presenter);
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getContext());
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }
}
