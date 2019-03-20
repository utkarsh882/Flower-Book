package com.easternts.flowerworld.detailview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.dal.Dalfile;
import com.easternts.flowerworld.flowersubcategory.model.FlowerViewModel;
import com.easternts.flowerworld.util.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private static final String KEY_FLOWER_ID = "key_flower_id";
    private static final String FLOWER_IMAGE = "flower_image";
    private static final String FLOWER_TITLE = "flower_title";
    private static final String FLOWER_DESCRIPTION = "flower_detail";
    private static final String FLOWER_FAVOURITE = "flower_favourite";
    private static final String Category_Key_Id = "category_key_id";
//    private static final String CategoryTitle = "category_title";
//    private static final String ItemImage = "category_key_image";
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Context mContext = this;
    private static final int FAVORITE_TRUE = 0;
    private static final int FAVORITE_FALSE = 1;
    private int mflagdesc = 0;
    private TextToSpeech mTextToSpeech;
    private FloatingActionButton mFavouriteFAB;
    private FloatingActionButton mTextToSpeechFAB;
    private AdRequest mAdRequest;
    private AdView mAdview;
    private int mSwitchFavouriteIcon;

    /**
     * start activity with
     * @param activity calling class activity.
     * @param transitionImage   sharedElement
     * @param flowerViewModel FlowerViewModel class object
     * below both parameter use for again back to trancation
     */
    public static void navigate(AppCompatActivity activity, View transitionImage, FlowerViewModel flowerViewModel) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(KEY_FLOWER_ID, flowerViewModel.getFlower_id());
        intent.putExtra(FLOWER_IMAGE, flowerViewModel.getFlowerimage());
        intent.putExtra(FLOWER_TITLE, flowerViewModel.getFlowername());
        intent.putExtra(FLOWER_DESCRIPTION, flowerViewModel.getFlower_description());
        intent.putExtra(FLOWER_FAVOURITE, flowerViewModel.getFlowerfavorite());
        intent.putExtra(Category_Key_Id, flowerViewModel.getCategory_id());

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, FLOWER_IMAGE);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
    //

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Dalfile dalfile = new Dalfile(mContext);
        initActivityTransitions();
        setContentView(R.layout.activity_detail);

        mAdview = (AdView) findViewById(R.id.adview);
        MobileAds.initialize(getApplicationContext(), Utils.banner_ad_unit_id);
        mAdRequest = new AdRequest.Builder().build();
        mAdview.loadAd(mAdRequest);

        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), FLOWER_IMAGE);
        supportPostponeEnterTransition();

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final int itemTitle = getIntent().getIntExtra(FLOWER_TITLE, 0);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle(getApplicationContext().getString(itemTitle));
        mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(mContext, android.R.color.white));

        int itemDescription = getIntent().getIntExtra(FLOWER_DESCRIPTION, 0);

        final int itemImage = getIntent().getIntExtra(FLOWER_IMAGE, 0);

        final ImageView image = (ImageView) findViewById(R.id.image);
        Picasso.with(this).load(itemImage).into(image, new Callback() {
            @Override
            public void onSuccess() {
                Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), itemImage);
                Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                Palette.from(myBitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette palette) {
                        applyPalette(palette);
                    }
                });

            }

            @Override
            public void onError() {

            }
        });


        TextView description = (TextView) findViewById(R.id.description);
        description.setText(Html.fromHtml(getApplicationContext().getString(itemDescription)));

        mFavouriteFAB = (FloatingActionButton) findViewById(R.id.favourite_floatingActionButton);
        dalfile.openDb();
        mSwitchFavouriteIcon = dalfile.findFavouriteValue(getIntent().getIntExtra(KEY_FLOWER_ID, 999));
        dalfile.closeDb();
        updateForeground((FloatingActionButton) findViewById(R.id.favourite_floatingActionButton), mSwitchFavouriteIcon);
        mFavouriteFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dalfile.openDb();
                mSwitchFavouriteIcon = dalfile.updateFavouriteValue(getIntent().getIntExtra(KEY_FLOWER_ID, 999));
                dalfile.closeDb();
                if (mSwitchFavouriteIcon == FAVORITE_TRUE) {
                    mFavouriteFAB.setImageResource(R.drawable.ic_favourite_icon);
                    Toast.makeText(mContext, "" + mContext.getString(itemTitle) + " " + mContext.getString(R.string.favourite_msg), Toast.LENGTH_SHORT).show();
                } else if (mSwitchFavouriteIcon == FAVORITE_FALSE) {
                    mFavouriteFAB.setImageResource(R.drawable.ic_unfavourite_icon);
                    Toast.makeText(mContext, mContext.getString(itemTitle) + " " + mContext.getString(R.string.unfavourite_msg), Toast.LENGTH_SHORT).show();
                }
            }
        });


        mTextToSpeech = new TextToSpeech(mContext, this);

        mTextToSpeechFAB = (FloatingActionButton) findViewById(R.id.text_to_speech_floatingActionButton);
        mTextToSpeechFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mflagdesc == 0) {
                        mTextToSpeechFAB.setImageResource(R.drawable.ic_pause_button);
                        mTextToSpeech.speak(String.valueOf(Html.fromHtml(mContext.getString(getIntent().getIntExtra(FLOWER_DESCRIPTION, 0)).toString())), TextToSpeech.QUEUE_FLUSH, null, null);
                        mflagdesc++;
                    } else {
                        mTextToSpeechFAB.setImageResource(R.drawable.ic_play_icon);
                        mTextToSpeech.stop();
                        mflagdesc = 0;
                    }

                } catch (Exception e) {
                    Log.e("Error", "Error" + e.toString());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_share:
                try {
                    Intent mShareIntent = new Intent(Intent.ACTION_SEND);
                    mShareIntent.setType("text/plain");
                    mShareIntent.putExtra(Intent.EXTRA_TEXT, "Name : " + Html.fromHtml(mContext.getString(getIntent().getIntExtra(FLOWER_TITLE, 0))) + "\n"
                            + "\n" + "Flower Description :" + "\n\n"
                            + Html.fromHtml((mContext.getString(getIntent().getIntExtra(FLOWER_DESCRIPTION, 0)))) + "\n\n"
                            + Html.fromHtml(Utils.PLAY_STORE_LINK));

                    startActivity(Intent.createChooser(mShareIntent, getString(R.string.choose_one)));

                } catch (Exception e) {
                    Log.e("Error", "Error" + e.toString());
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (NullPointerException e) {
            return false;
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
        int primaryDark = ContextCompat.getColor(mContext, R.color.primary_dark);
        int primary = ContextCompat.getColor(mContext, R.color.primary);
        int defaultColor = 0x000000;
        mCollapsingToolbarLayout.setContentScrimColor(palette.getLightMutedColor(defaultColor));
        mCollapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(defaultColor));

        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(palette.getDarkMutedColor(primaryDark));
        startPostponedEnterTransition();

    }

    private void updateForeground(FloatingActionButton Share_floatingActionButton, int mUpdateFavouriteValue) {
        if (mUpdateFavouriteValue == FAVORITE_FALSE) {
            Share_floatingActionButton.setImageResource(R.drawable.ic_unfavourite_icon);
        } else if (mUpdateFavouriteValue == FAVORITE_TRUE) {
            Share_floatingActionButton.setImageResource(R.drawable.ic_favourite_icon);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        shutDownTextToSpeech();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shutDownTextToSpeech();
    }

    private void shutDownTextToSpeech() {
        if (mTextToSpeech.isSpeaking()) {
            mTextToSpeech.shutdown();
        }
    }

    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.ERROR) {
            mTextToSpeech.setLanguage(Locale.UK);
        }
    }
}
