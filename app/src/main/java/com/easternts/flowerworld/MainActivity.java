package com.easternts.flowerworld;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.easternts.flowerworld.floweratoz.AtoZMain;
import com.easternts.flowerworld.flowercategory.CategoryMain;
import com.easternts.flowerworld.flowerfavourite.FavouriteMain;
import com.easternts.flowerworld.settingslayout.SettingActivity;
import com.easternts.flowerworld.quiz.QuizMainActivity;
import com.easternts.flowerworld.util.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int IC_EASTERN_LOGO = R.drawable.eastern_logo;

    private Context mContext = this;
    private View mContent;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FloatingActionButton mFabLayoutChange;
    private boolean mGridListFlag = true;
    private Bundle mBundle = new Bundle();
    private AdRequest mAdRequest;
    private String mSelectedFragment = null;
    private AdView mMainAdview;
    private long mBackPressed;
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mMainAdview = (AdView) findViewById(R.id.main_adView);

        MobileAds.initialize(getApplicationContext(), Utils.banner_ad_unit_id);
        AdView mMainAdview = (AdView) findViewById(R.id.main_adView);
        mAdRequest = new AdRequest.Builder().build();
        mMainAdview.loadAd(mAdRequest);


        mFabLayoutChange = (FloatingActionButton) findViewById(R.id.fab_layout_change);
        mFabLayoutChange.setOnClickListener(this);

        mFabLayoutChange.setImageResource(R.drawable.ic_menu_icon);

//        mSelectedFragment = getIntent().getStringExtra("activityData");

        if (getIntent().getStringExtra("Selected_Fragment") != null) {
            mSelectedFragment = getIntent().getStringExtra("Selected_Fragment");
        }

        if (mSelectedFragment == null) {
            mSelectedFragment = "home";
            getFragmentManager().beginTransaction().add(R.id.flower_main_activity_ll, calledFlowerCategory()).commit();
        } else {
            if (mSelectedFragment.equals("home")) {
                getFragmentManager().beginTransaction().add(R.id.flower_main_activity_ll, calledFlowerCategory()).commit();
            } else if (mSelectedFragment.equals("atoz")) {
                getFragmentManager().beginTransaction().add(R.id.flower_main_activity_ll, calledFlowerAtoZ()).commit();
            } else if (mSelectedFragment.equals("favourite")) {
                getFragmentManager().beginTransaction().add(R.id.flower_main_activity_ll, calledFlowerFavourite()).commit();
            }
        }
        setupDrawerLayout();
        initToolbar();

        mContent = findViewById(R.id.content);
        final ImageView avatar = (ImageView) mNavigationView.getHeaderView(0).findViewById(R.id.avatar);

        Glide.with(mContext)
                .load(IC_EASTERN_LOGO)
                .bitmapTransform(new CropCircleTransformation(mContext))
                .into(avatar);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
//            moveTaskToBack(true);
            finish();
            return;
        } else {
            Snackbar.make(mContent, "Tap Back Button Again To Exit", Snackbar.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();
    }

    @Override
    public void onClick(View v) {
        // true means Grid
        if (mGridListFlag == true) {
            // convert to grid_to_list view
            mGridListFlag = false;
            mFabLayoutChange.setImageResource(R.drawable.ic_grid_icon);
            if (mSelectedFragment.equals("home")) {
                getFragmentManager().beginTransaction().replace(R.id.flower_main_activity_ll, calledFlowerCategory()).commit();
            } else if (mSelectedFragment.equals("atoz")) {

                getFragmentManager().beginTransaction().replace(R.id.flower_main_activity_ll, calledFlowerAtoZ()).commit();
            } else if (mSelectedFragment.equals("favourite")) {
                getFragmentManager().beginTransaction().replace(R.id.flower_main_activity_ll, calledFlowerFavourite()).commit();
                mDrawerLayout.closeDrawer(Gravity.LEFT);

            }
        } else if (mGridListFlag == false) {
            // convert to list_to_grid view
            mGridListFlag = true;
            mFabLayoutChange.setImageResource(R.drawable.ic_menu_icon);
            String s = mSelectedFragment;
            if (mSelectedFragment.equals("home")) {

                getFragmentManager().beginTransaction().replace(R.id.flower_main_activity_ll, calledFlowerCategory()).commit();
            } else if (mSelectedFragment.equals("atoz")) {

                getFragmentManager().beginTransaction().replace(R.id.flower_main_activity_ll, calledFlowerAtoZ()).commit();
            } else if (mSelectedFragment.equals("favourite")) {

                getFragmentManager().beginTransaction().replace(R.id.flower_main_activity_ll, calledFlowerFavourite()).commit();
                mDrawerLayout.closeDrawer(Gravity.LEFT);

            }
        }
    }

    private void setupDrawerLayout() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//      Handle the  L Drawer click Event
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.getTitle().toString().toLowerCase().replace(" ", "").equals("home")) {

                    mSelectedFragment = "home";
                    mGridListFlag = true;
                    getFragmentManager().beginTransaction().replace(R.id.flower_main_activity_ll, calledFlowerCategory()).commit();
                    mDrawerLayout.closeDrawer(Gravity.LEFT);

                } else if (menuItem.getTitle().toString().toLowerCase().replace(" ", "").equals("atoz")) {

                    mSelectedFragment = "atoz";
                    mGridListFlag = true;
                    getFragmentManager().beginTransaction().replace(R.id.flower_main_activity_ll, calledFlowerAtoZ()).commit();
                    mDrawerLayout.closeDrawer(Gravity.LEFT);

                } else if (menuItem.getTitle().toString().toLowerCase().replace(" ", "").equals("favourite")) {

                    mSelectedFragment = "favourite";
                    mGridListFlag = true;
                    getFragmentManager().beginTransaction().replace(R.id.flower_main_activity_ll, calledFlowerFavourite()).commit();
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                } else if (menuItem.getTitle().toString().toLowerCase().replace(" ", "").equals("quiz")) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                    startActivity(new Intent(mContext, QuizMainActivity.class));

                } else if (menuItem.getTitle().toString().toLowerCase().replace(" ", "").equals("settings")) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                    startActivity(new Intent(mContext, SettingActivity.class));
                }
                return true;
            }
        });
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_icon);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public CategoryMain calledFlowerCategory()
    {
        mBundle.putBoolean("mGridListFlag", mGridListFlag);
        CategoryMain category_main = new CategoryMain();
        category_main.setArguments(mBundle);
        return category_main;
    }

    public AtoZMain calledFlowerAtoZ()
    {
        mBundle.putBoolean("mGridListFlag", mGridListFlag);
        AtoZMain atozmain = new AtoZMain();
        atozmain.setArguments(mBundle);
        return atozmain;
    }

    public FavouriteMain calledFlowerFavourite()
    {
        mBundle.putBoolean("mGridListFlag", mGridListFlag);
        FavouriteMain favouriteMain = new FavouriteMain();
        favouriteMain.setArguments(mBundle);
        return favouriteMain;
    }

}
