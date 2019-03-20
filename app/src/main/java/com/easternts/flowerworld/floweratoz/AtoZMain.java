package com.easternts.flowerworld.floweratoz;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.floweratoz.fragment.FlowerAtoZGridFragment;
import com.easternts.flowerworld.floweratoz.fragment.FlowerAtoZListFragment;


public class AtoZMain extends Fragment {
    private boolean mGridListFlag;

    public AtoZMain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atozmain, container, false);
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
        getFragmentManager().beginTransaction().add(R.id.flower_atoz_ll, new FlowerAtoZGridFragment()).commit();
    }


    public void grid_to_list() {
        getFragmentManager().beginTransaction().add(R.id.flower_atoz_ll, new FlowerAtoZListFragment()).commit();
    }
}
