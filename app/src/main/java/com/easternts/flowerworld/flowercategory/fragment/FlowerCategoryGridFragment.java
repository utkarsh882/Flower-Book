package com.easternts.flowerworld.flowercategory.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easternts.flowerworld.dal.Dalfile;
import com.easternts.flowerworld.R;
import com.easternts.flowerworld.flowercategory.adapter.RecyclerViewAdapter;
import com.easternts.flowerworld.flowercategory.model.Category;
import com.easternts.flowerworld.flowersubcategory.FlowerSubCategoryMain;

import java.util.List;

public class FlowerCategoryGridFragment extends Fragment implements RecyclerViewAdapter.OnItemClickListener {

    private List<Category> mCategoryList;

    public FlowerCategoryGridFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Dalfile dalfile = new Dalfile(getActivity());
        dalfile.openDb();
        mCategoryList = dalfile.getAllCategory();
        dalfile.closeDb();

        View view = inflater.inflate(R.layout.fragment_flower_category_grid, container, false);

        RecyclerView rvCategoryGrid = (RecyclerView) view.findViewById(R.id.rv_category_grid);
        rvCategoryGrid.setHasFixedSize(true);
        rvCategoryGrid.setNestedScrollingEnabled(false);
        rvCategoryGrid.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mCategoryList, getActivity());
        adapter.setOnItemClickListener(this);
        rvCategoryGrid.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(View view, Category category) {

        FlowerSubCategoryMain.navigate2((AppCompatActivity) getActivity(), view.findViewById(R.id.flower_category_image), category);
    }
}
