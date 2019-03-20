package com.easternts.flowerworld.settingslayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.util.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class SettingActivity extends AppCompatActivity {
    private Context context = this;
    private InterstitialAd mInterstitialAd;
    private AdRequest mAdRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MobileAds.initialize(getApplicationContext(), Utils.banner_ad_unit_id);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        mAdRequest = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);



        android.support.v7.app.ActionBar actionBar =getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assert actionBar != null;

        actionBar.setHomeButtonEnabled(true);

        changeStatusBarColor();

        setTitle(Utils.Settings);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new PrefFragment()).commit();
        }
    }

    public static class PrefFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        String ringtone = null;
        public CheckBoxPreference chkbox;
        public CheckBoxPreference chkbox1;
        boolean b;
        SharedPreferences prefs;
        RingtonePreference ringtonePreference;
        int timepicker;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            this.addPreferencesFromResource(R.xml.preferences);
        }




        @Override
        public void onSharedPreferenceChanged(
                SharedPreferences sharedPreferences, String key) {
        }

        @Override
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences()
                    .registerOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onPause() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences()
                    .unregisterOnSharedPreferenceChangeListener(this);
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
