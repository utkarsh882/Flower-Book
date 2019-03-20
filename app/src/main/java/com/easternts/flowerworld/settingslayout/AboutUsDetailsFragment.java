package com.easternts.flowerworld.settingslayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easternts.flowerworld.R;


public class AboutUsDetailsFragment extends Fragment {


    public AboutUsDetailsFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us_details, container, false);
        return view;
    }


}
