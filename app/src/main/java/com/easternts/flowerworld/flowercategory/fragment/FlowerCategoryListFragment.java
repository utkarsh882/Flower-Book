package com.easternts.flowerworld.flowercategory.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
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

public class FlowerCategoryListFragment extends Fragment implements RecyclerViewAdapter.OnItemClickListener{

    private List<Category> mCategoryList;

    public FlowerCategoryListFragment() {
        // Required empty public constructor
    }

 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     Dalfile dalfile = new Dalfile(getActivity());
     dalfile.openDb();
     mCategoryList = dalfile.getAllCategory();
     dalfile.closeDb();

     View view = inflater.inflate(R.layout.fragment_flower_category_list, container, false);

     RecyclerView rvCategoryList = (RecyclerView) view.findViewById(R.id.rv_category_list);
     rvCategoryList.setHasFixedSize(true);
     rvCategoryList.setNestedScrollingEnabled(false);
     rvCategoryList.setLayoutManager(new LinearLayoutManager(getActivity()));

     RecyclerViewAdapter adapter = new RecyclerViewAdapter(mCategoryList, getActivity());
     adapter.setOnItemClickListener(this);
     rvCategoryList.setAdapter(adapter);


     return view;
    }

    @Override
    public void onItemClick(View view, Category category) {
        FlowerSubCategoryMain.navigate2((AppCompatActivity) getActivity(), view.findViewById(R.id.flower_category_image) , category);
    }
}
