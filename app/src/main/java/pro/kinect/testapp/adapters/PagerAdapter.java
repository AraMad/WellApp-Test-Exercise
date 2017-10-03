package pro.kinect.testapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import pro.kinect.testapp.fragments.ListFragment;
import pro.kinect.testapp.fragments.PermissionFragment;
import pro.kinect.testapp.fragments.RequestFragment;

/**
 * Created by Arina on 03.10.2017
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ListFragment();
            case 1:
                return new RequestFragment();
            case 2:
                return new PermissionFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TAB 1";
            case 1:
                return "TAB 2";
            case 2:
                return "TAB 3";
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
