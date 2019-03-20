package com.easternts.flowerworld.settingslayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easternts.flowerworld.R;


public class AboutUsFollowUsFragment extends Fragment {


    private Typeface tfAwesome;
    private TextView tvFacebookbutton;
    private TextView tvTwitterButton;
    private TextView tvGooglePlusButton;
    private TextView tvLikedInButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us_follow_us, container, false);

        tfAwesome = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
        tvFacebookbutton = (TextView) view.findViewById(R.id.facebookbutton);
        tvFacebookbutton.setTypeface(tfAwesome);
        tvTwitterButton = (TextView) view.findViewById(R.id.twitterbutton);
        tvTwitterButton.setTypeface(tfAwesome);
        tvGooglePlusButton = (TextView) view.findViewById(R.id.googleplusbutton);
        tvGooglePlusButton.setTypeface(tfAwesome);
        tvLikedInButton = (TextView) view.findViewById(R.id.likedinbutton);
        tvLikedInButton.setTypeface(tfAwesome);

        tvFacebookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getString(R.string.facebook_link));
                Intent webintent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(webintent);
            }
        });
        tvLikedInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getString(R.string.linkedinlink));
                Intent webintent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(webintent);
            }
        });
        tvGooglePlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getString(R.string.googlepluslink));
                Intent webintent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(webintent);
            }
        });
        tvTwitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getString(R.string.twitterlink));
                Intent webintent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(webintent);
            }
        });


        return view;
    }


}
