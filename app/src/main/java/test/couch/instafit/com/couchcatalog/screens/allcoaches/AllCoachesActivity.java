package test.couch.instafit.com.couchcatalog.screens.allcoaches;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import test.couch.instafit.com.couchcatalog.R;
import test.couch.instafit.com.couchcatalog.util.ActivityUtils;

public class AllCoachesActivity extends AppCompatActivity {

    AllCoachesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_coaches);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);


        AllCoachesFragment tasksFragment =
                (AllCoachesFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = AllCoachesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), tasksFragment, R.id.contentFrame);
        }

        // Create the presenter
        presenter = new AllCoachesPresenter(tasksFragment);
    }
}
