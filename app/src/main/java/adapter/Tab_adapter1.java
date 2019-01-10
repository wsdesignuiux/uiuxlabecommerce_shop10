package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.Viewpager1;
import fragment.Viewpager2;
import fragment.Viewpager3;


public class Tab_adapter1 extends FragmentStatePagerAdapter {


    public Tab_adapter1(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Viewpager1 tab1 = new Viewpager1();
                return tab1;
            case 1:
                Viewpager2 tab2 = new Viewpager2();
                return tab2;
            case 2:
                Viewpager3 tab3 = new Viewpager3();
                return tab3;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
