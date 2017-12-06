package test.couch.instafit.com.couchcatalog.data.source.local;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import test.couch.instafit.com.couchcatalog.data.AvatarPictures;
import test.couch.instafit.com.couchcatalog.data.Coach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(AndroidJUnit4.class)
public class CoachDaoTest {

    private static final Coach COACH = new Coach(1, "name", "desc", true, "url", new AvatarPictures("1", "2", "3", "4"));

    private CoachDatabase coachDatabase;

    @Before
    public void initDB() {
        coachDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), CoachDatabase.class).build();
    }

    @After
    public void closeDB() {
        coachDatabase.close();
    }

    @Test
    public void insertTaskAndGetById() {
        coachDatabase.coachDao().insertCoach(COACH);

        Coach fetchedCoach = coachDatabase.coachDao().getCoachById(COACH.getId());

        assertCoach(fetchedCoach, COACH.getId(), COACH.getName(), COACH.getDescription(), COACH.getFilterAvailable(), COACH.getAvatar(), COACH.getAvatarPictures());
    }

    @Test
    public void insertCoachReplacesOnConflict() {
        coachDatabase.coachDao().insertCoach(COACH);

        Coach newCoach = new Coach(1, "new Name", "new desc", true, "new url", new AvatarPictures("new 1", "new 2", "new 3", "new 4"));

        coachDatabase.coachDao().insertCoach(newCoach);

        Coach fetchUpdatedCoach = coachDatabase.coachDao().getCoachById(COACH.getId());

        assertCoach(fetchUpdatedCoach, newCoach.getId(), newCoach.getName(), newCoach.getDescription(), newCoach.getFilterAvailable(), newCoach.getAvatar(), newCoach.getAvatarPictures());
    }

    @Test
    public void insertCoachGetCoach() {
        coachDatabase.coachDao().insertCoach(COACH);

        List<Coach> coaches = coachDatabase.coachDao().getCoaches();

        assertThat(coaches.size(), is(1));

        assertCoach(coaches.get(0), COACH.getId(), COACH.getName(), COACH.getDescription(), COACH.getFilterAvailable(), COACH.getAvatar(), COACH.getAvatarPictures());
    }

    @Test
    public void deleteCoachesGetCoaches(){
        coachDatabase.coachDao().insertCoach(COACH);

        coachDatabase.coachDao().deleteCoaches();

        List<Coach> coaches = coachDatabase.coachDao().getCoaches();

        assertThat(coaches.size(),is(0));
    }

    private void assertCoach(Coach coach,
                             Integer id,
                             String name,
                             String desc,
                             boolean isFilter,
                             String url,
                             AvatarPictures avatarPictures) {
        assertThat(coach, notNullValue());
        assertThat(coach.getId(), is(id));
        assertThat(coach.getName(), is(name));
        assertThat(coach.getDescription(), is(desc));
        assertThat(coach.getFilterAvailable(), is(isFilter));
        assertThat(coach.getAvatar(), is(url));
        assertThat(coach.getAvatarPictures(), notNullValue());
    }
}
