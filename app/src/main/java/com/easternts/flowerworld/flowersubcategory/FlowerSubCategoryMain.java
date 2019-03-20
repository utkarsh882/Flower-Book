package com.easternts.flowerworld.flowersubcategory;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.flowercategory.model.Category;
import com.easternts.flowerworld.flowersubcategory.fragment.FlowerSubcategoryGridFragment;
import com.easternts.flowerworld.flowersubcategory.fragment.FlowerSubcategoryListFragment;
import com.easternts.flowerworld.util.Utils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class FlowerSubCategoryMain extends AppCompatActivity implements View.OnClickListener {
    // AVATAR_URL display the face of user
    private static String Category_Key_Id = "category_key_id";
    private static String Category_TITLE = "category_title";
    private static String CATEGORY_KEY_IMAGE = "category_key_image";


    private View content;
    private Context context = this;
    private NavigationView navigationView;
    private FloatingActionButton fabLayoutChange;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private boolean mGridListFlag = true;
    Bundle bundle = new Bundle();
    private AppBarLayout appBarLayout;
    //    private CardView subCategory_cv;
    private static int id = 0;
    private static int categoryTitle = 0;
    private static int itemImage = 0;
    private InterstitialAd mInterstitialAd;
    private AdRequest mAdRequest;
    private AdView mAdview;

    public static void navigate2(AppCompatActivity activity, View transitionImage, Category category) {
        Intent intent2 = new Intent(activity, FlowerSubCategoryMain.class);
        intent2.putExtra(Category_Key_Id, category.getmCategoryId());
        intent2.putExtra(Category_TITLE, category.getmCategoryName());
        intent2.putExtra(CATEGORY_KEY_IMAGE, category.getmImageId());

        ActivityOptionsCompat options2 = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, CATEGORY_KEY_IMAGE);
        ActivityCompat.startActivity(activity, intent2, options2.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityTransitions();
        setContentView(R.layout.activity_flower_subcategory_main);

        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), CATEGORY_KEY_IMAGE);
        supportPostponeEnterTransition();

        MobileAds.initialize(getApplicationContext(), Utils.banner_ad_unit_id);
        mAdview = (AdView) findViewById(R.id.adView);
        mAdRequest = new AdRequest.Builder().build();
        mAdview.loadAd(mAdRequest);

        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(Utils.interstitial_ad_unit_id);

        initToolbar();

        categoryTitle = getIntent().getIntExtra(Category_TITLE, 0);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(context.getString(categoryTitle));
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(context, android.R.color.white));

        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);

        itemImage = getIntent().getIntExtra(CATEGORY_KEY_IMAGE, 0);
        final ImageView image = (ImageView) findViewById(R.id.image_category);
        Picasso.with(this).load(itemImage).into(image, new Callback() {
            @Override
            public void onSuccess() {
                Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette palette) {
                        applyPalette(palette);
                    }
                });
            }

            @Override
            public void onError() {

            }
        });


        Intent intent = getIntent();
        id = intent.getIntExtra(Category_Key_Id, 0);
        bundle.putInt("Id", id);
//        bundle.putInt("CategoryTitle", categoryTitle);
//        bundle.putInt("ItemImage", itemImage);


        fabLayoutChange = (FloatingActionButton) findViewById(R.id.fab_layout_change_fd);
        fabLayoutChange.setOnClickListener(this);

        content = findViewById(R.id.content);

        if (savedInstanceState == null || mGridListFlag == true) {
            // Display Grid view
            fabLayoutChange.setImageDrawable(getDrawable(R.drawable.ic_menu_icon));
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            FlowerSubcategoryGridFragment flowerSubcategoryGridFragment = new FlowerSubcategoryGridFragment();
            flowerSubcategoryGridFragment.setArguments(bundle);
            ft.add(R.id.flower_flower_ll, flowerSubcategoryGridFragment);
            ft.commit();
        }

    }

    private void initToolbar() {
        final Toolbar toolbar_sub = (Toolbar) findViewById(R.id.toolbar_sub);
        setSupportActionBar(toolbar_sub);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
    }

    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }

    private void applyPalette(Palette palette) {
        int primaryDark = ContextCompat.getColor(context,R.color.primary_dark);
        int primary = ContextCompat.getColor(context,R.color.primary);
        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));

        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(palette.getDarkMutedColor(primaryDark));
        startPostponedEnterTransition();

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onClick(View v) {
        // true means Grid
        if (mGridListFlag == true) {
            // convert to grid_to_list view
            mGridListFlag = false;
            changeInterstitialAd();
            grid_to_list();
        }
        // false means List
        else if (mGridListFlag == false) {
            // convert to list_to_grid view
            mGridListFlag = true;
            changeInterstitialAd();
            list_to_grid();
        }
    }

    public void list_to_grid() {
        fabLayoutChange.setImageDrawable(getDrawable(R.drawable.ic_menu_icon));
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        FlowerSubcategoryGridFragment flowerSubcategoryGridFragment = new FlowerSubcategoryGridFragment();
        flowerSubcategoryGridFragment.setArguments(bundle);
        ft.replace(R.id.flower_flower_ll, flowerSubcategoryGridFragment);
        ft.commit();
    }

    public void grid_to_list() {
        fabLayoutChange.setImageDrawable(getDrawable(R.drawable.ic_grid_icon));
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        FlowerSubcategoryListFragment flowerSubcategoryListFragment = new FlowerSubcategoryListFragment();
        flowerSubcategoryListFragment.setArguments(bundle);
        ft.replace(R.id.flower_flower_ll, flowerSubcategoryListFragment);
        ft.commit();
    }


    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void changeInterstitialAd()
    {
        mInterstitialAd.loadAd(mAdRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
    }

}
