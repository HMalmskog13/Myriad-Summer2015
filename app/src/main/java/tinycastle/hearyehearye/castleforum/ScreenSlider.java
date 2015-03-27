package tinycastle.hearyehearye.castleforum;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/*
viewPager for kingdom
 */
public class ScreenSlider extends FragmentActivity {

    private static final int NUM_PAGES = 5;


    private ViewPager mPager;


    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kingdom);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSliderAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            //back button
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }


    private class ScreenSliderAdapter extends FragmentStatePagerAdapter {
        public ScreenSliderAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new Fragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}