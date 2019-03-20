package com.easternts.flowerworld.settingslayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.util.Utils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class AboutUsContactUsFragment extends Fragment {
    TextView tvEmailUrl, tvWebUrl;
    private InterstitialAd mInterstitialAd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us_contact, container, false);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(Utils.interstitial_ad_unit_id);
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                changeInterstitialAd();
            }
        });






        tvEmailUrl = (TextView) view.findViewById(R.id.tv_Email_Url);
        //Email Button Click Listener
        tvEmailUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("message/rfc822");
                share.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{getString(R.string.feed_to)});
                startActivity(Intent.createChooser(share,
                        "Choose an Email client :"));
            }
        });
        //Url Button Click Listener
        tvWebUrl = (TextView) view.findViewById(R.id.tv_Web_Url);
        tvWebUrl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getString(R.string.co_link));
                Intent webintent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(webintent);
            }
        });
        return view;
    }

    public void changeInterstitialAd() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

}
