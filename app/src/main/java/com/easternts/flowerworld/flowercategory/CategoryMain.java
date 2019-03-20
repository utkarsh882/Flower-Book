package com.easternts.flowerworld.flowercategory;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easternts.flowerworld.R;
import com.easternts.flowerworld.flowercategory.fragment.FlowerCategoryGridFragment;
import com.easternts.flowerworld.flowercategory.fragment.FlowerCategoryListFragment;

public class CategoryMain extends Fragment {
    //    private FloatingActionButton fabLayoutChange;
    private boolean mGridListFlag;
    public CategoryMain() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categorymain, container, false);
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
        getFragmentManager().beginTransaction().add(R.id.flower_category_ll, new FlowerCategoryGridFragment()).commit();
    }
    public void grid_to_list() {
        getFragmentManager().beginTransaction().add(R.id.flower_category_ll, new FlowerCategoryListFragment()).commit();
    }
}
