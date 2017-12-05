package test.couch.instafit.com.couchcatalog.screens.allcoaches;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import test.couch.instafit.com.couchcatalog.data.Coach;

import static com.google.common.base.Preconditions.checkNotNull;


public class AllCoachesFragmentAdapter extends FragmentStatePagerAdapter {

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    private List<Coach> coaches;

    public AllCoachesFragmentAdapter(FragmentManager fm, List<Coach> coaches) {
        super(fm);
        setCoaches(checkNotNull(coaches));
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return CoachInfoFragment.newInstance(coaches.get(position));
    }

    public void replaceData(List<Coach> coaches) {
        setCoaches(coaches);
        notifyDataSetChanged();
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return coaches.size();
    }
}
