package com.example.vaibhav.screen10;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import adapter.Tab_adapter;
import adapter.Tab_adapter1;
import adapter.WrapContentHeightViewPager;
import me.relex.circleindicator.CircleIndicator;

public class Screen10Activity extends AppCompatActivity {
    //1st viewpager

    private WrapContentHeightViewPager viewPager1;
    private CircleIndicator circleIndicator;
    private Tab_adapter1 viewPagerAdapter;

    //2nd viewpager
    WrapContentHeightViewPager viewPager;
    TabLayout tablayout;
    private Tab_adapter tab_adapter;

    private Typeface mTypeface;
    private Typeface mTypefaceBold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen10);

        //1st viewpager

        viewPager1 = (WrapContentHeightViewPager) findViewById(R.id.vp1);
        circleIndicator = (CircleIndicator) findViewById(R.id.circleindicator);

        viewPagerAdapter = new Tab_adapter1(getSupportFragmentManager());
        viewPager1.setAdapter(viewPagerAdapter);
        circleIndicator.setViewPager(viewPager1);
        viewPagerAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        //2nd viewpager

        viewPager = findViewById(R.id.viewpager);
        tablayout = findViewById(R.id.tablayout1);

        setCustomFontAndStyle(tablayout, 0);
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tablayout.addTab(tablayout.newTab().setText("New"));
        tablayout.addTab(tablayout.newTab().setText("Populer"));
        tablayout.addTab(tablayout.newTab().setText("Sale"));

        Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");
        ViewGroup vg = (ViewGroup) tablayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
                }
            }
        }

        Tab_adapter adapter = new Tab_adapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                LinearLayout tabLayout = (LinearLayout) ((ViewGroup) tablayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
                tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.BOLD);
                Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                LinearLayout tabLayout = (LinearLayout) ((ViewGroup) tablayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
                tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.NORMAL);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
    }

    private void setCustomFontAndStyle(TabLayout tabLayout, Integer position) {

        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");
        mTypefaceBold = Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    if (j == position) {
                        ((TextView) tabViewChild).setTypeface(mTypefaceBold, Typeface.BOLD);
                    } else {
                        ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
                    }
                }
            }
        }
    }
}