package com.easternts.flowerworld.settingslayout;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.util.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FAQActivity extends AppCompatActivity {
    private Context context = this;
    private InterstitialAd mInterstitialAd;
    private AdRequest mAdRequest;
    private AdView mAdview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar =getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assert actionBar != null;

        actionBar.setHomeButtonEnabled(true);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
        changeStatusBarColor();

        MobileAds.initialize(getApplicationContext(), Utils.banner_ad_unit_id);
        mAdview = (AdView) findViewById(R.id.adView);
        mAdRequest = new AdRequest.Builder().build();
        mAdview.loadAd(mAdRequest);

    }


    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        ExpandableListView expandableListView;
        ExpandableListAdapter expandableListAdapter;
        List<String> expandableListTitle;
        HashMap<String, List<String>> expandableListDetail;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // View all FAQ's Questions From String File to Layout
            View rootView = inflater.inflate(R.layout.fragment_faq, container, false);
            expandableListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);

            expandableListDetail = ExpandableListDataPump.getData();

            expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());

            expandableListAdapter = new com.easternts.flowerworld.settingslayout.ExpandableListAdapter(getActivity(), expandableListTitle, expandableListDetail);
            expandableListView.setAdapter(expandableListAdapter);


            expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                        @Override
                        public void onGroupExpand(int groupPosition) {
                        }
                    });
            expandableListView
                    .setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
                        @Override
                        public void onGroupCollapse(int groupPosition) {
                        }
                    });
            expandableListView
                    .setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                        @Override
                        public boolean onChildClick(ExpandableListView parent,
                                                    View v, int groupPosition, int childPosition,
                                                    long id) {
                            return false;
                        }
                    });

            return rootView;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
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
