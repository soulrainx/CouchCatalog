package test.couch.instafit.com.couchcatalog.screens.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.couch.instafit.com.couchcatalog.screens.allcoaches.AllCoachesActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = new Intent(SplashActivity.this, AllCoachesActivity.class);
        startActivity(intent);
        finish();
    }
}
