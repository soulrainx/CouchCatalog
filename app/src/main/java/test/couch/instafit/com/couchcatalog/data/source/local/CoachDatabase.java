package test.couch.instafit.com.couchcatalog.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import test.couch.instafit.com.couchcatalog.data.Coach;

@Database(entities = {Coach.class}, version = 1)
public abstract class CoachDatabase extends RoomDatabase {

    private static CoachDatabase INSTANCE;


    public abstract CoachDao coachDao();

    private static final Object sLock = new Object();

    public static CoachDatabase getInstance(Context context) {

        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        CoachDatabase.class, "Coaches.db").build();
            }

            return INSTANCE;
        }
    }
}
