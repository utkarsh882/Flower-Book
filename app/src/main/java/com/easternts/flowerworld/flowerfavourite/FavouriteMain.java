package com.easternts.flowerworld.flowerfavourite;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.flowerfavourite.fragment.FlowerFavouriteGridFragment;
import com.easternts.flowerworld.flowerfavourite.fragment.FlowerFavouriteListFragment;


public class FavouriteMain extends Fragment {
    private boolean mGridListFlag;

    public FavouriteMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite_main, container, false);

        mGridListFlag = getArguments().getBoolean("mGridListFlag");
        if (mGridListFlag == true) {
            // Display Grid view
            list_to_grid();
        }

        if (mGridListFlag == false) {
            // Display Grid view
            grid_to_list();

        }

        return view;
    }


    public void list_to_grid() {
        getFragmentManager().beginTransaction().add(R.id.flower_favourite_ll, new FlowerFavouriteGridFragment()).commit();
    }


    public void grid_to_list() {
        getFragmentManager().beginTransaction().add(R.id.flower_favourite_ll, new FlowerFavouriteListFragment()).commit();
    }
}