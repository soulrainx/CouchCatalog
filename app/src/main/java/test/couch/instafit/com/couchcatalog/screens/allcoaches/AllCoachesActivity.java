package test.couch.instafit.com.couchcatalog.screens.allcoaches;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import test.couch.instafit.com.couchcatalog.R;
import test.couch.instafit.com.couchcatalog.util.ActivityUtils;
import test.couch.instafit.com.couchcatalog.util.Injector;

public class AllCoachesActivity extends AppCompatActivity {

    AllCoachesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_coaches);

        // Set up the toolbar.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AllCoachesFragment allCoachesFragment =
                (AllCoachesFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (allCoachesFragment == null) {
            // Create the fragment
            allCoachesFragment = AllCoachesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), allCoachesFragment, R.id.contentFrame);
        }

        // Create the presenter
        presenter = new AllCoachesPresenter(allCoachesFragment, Injector.provideCoachDataSourceMain(getApplicationContext()));
    }
}
