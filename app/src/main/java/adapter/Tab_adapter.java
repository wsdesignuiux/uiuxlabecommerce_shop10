package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.New_s10;
import fragment.Populer;
import fragment.Sale;

public class Tab_adapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public Tab_adapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                 New_s10 tab1 = new New_s10();
                return tab1;
            case 1:
                Populer tab2 = new Populer();
                return tab2;
            case 2:
                Sale tab3 = new Sale();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
