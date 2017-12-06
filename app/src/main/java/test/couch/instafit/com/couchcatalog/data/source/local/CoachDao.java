package test.couch.instafit.com.couchcatalog.data.source.local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import test.couch.instafit.com.couchcatalog.data.Coach;

@Dao
public interface CoachDao {

    @Query("SELECT * FROM Coaches")
    List<Coach> getCoaches();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCoach(Coach coach);

    @Query("DELETE FROM Coaches")
    void deleteCoaches();

    @Query("SELECT * FROM Coaches WHERE coachId = :coachId")
    Coach getCoachById(Integer coachId);
}
