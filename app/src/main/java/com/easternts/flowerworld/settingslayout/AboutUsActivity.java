package com.easternts.flowerworld.settingslayout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.util.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class AboutUsActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private AdRequest mAdRequest;
    private AdView mAdview;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        changeStatusBarColor();

        MobileAds.initialize(getApplicationContext(), Utils.banner_ad_unit_id);
        mAdview = (AdView) findViewById(R.id.adView);
        mAdRequest = new AdRequest.Builder().build();
        mAdview.loadAd(mAdRequest);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        setupTabs();

    }

    private void setupTabs() {
        final TabLayout tabLayoutAboutUsActivity = (TabLayout) findViewById(R.id.tab_layout_about_us_activity);
        final ViewPager viewPagerAboutUsActivity = (ViewPager) findViewById(R.id.viewpager_about_us_activity);

        //setup tabs
        if (tabLayoutAboutUsActivity != null) {
            tabLayoutAboutUsActivity.addTab(tabLayoutAboutUsActivity.newTab().setText("About Us"));
            tabLayoutAboutUsActivity.addTab(tabLayoutAboutUsActivity.newTab().setText("Contact Us"));
            tabLayoutAboutUsActivity.addTab(tabLayoutAboutUsActivity.newTab().setText("Follow Us"));
        }

        assert tabLayoutAboutUsActivity != null;
        final AboutUsVPAdapter aboutUsVPAdapter = new AboutUsVPAdapter(getSupportFragmentManager(), tabLayoutAboutUsActivity.getTabCount());
        if (viewPagerAboutUsActivity != null) {
            viewPagerAboutUsActivity.setAdapter(aboutUsVPAdapter);
            viewPagerAboutUsActivity.setCurrentItem(0, false);
            viewPagerAboutUsActivity.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutAboutUsActivity));
            tabLayoutAboutUsActivity.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPagerAboutUsActivity.setCurrentItem(tab.getPosition());
                    //Custom TabLayout
                    if (tab.getPosition() == 0) {

                        viewPagerAboutUsActivity.setCurrentItem(0);

                    } else if (tab.getPosition() == 1) {
                        viewPagerAboutUsActivity.setCurrentItem(1);

                    } else if (tab.getPosition() == 2) {
                        viewPagerAboutUsActivity.setCurrentItem(2);
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void changeStatusBarColor()
    {
        int primaryDark = ContextCompat.getColor(context,R.color.primary_dark);
        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(primaryDark);
    }

}
