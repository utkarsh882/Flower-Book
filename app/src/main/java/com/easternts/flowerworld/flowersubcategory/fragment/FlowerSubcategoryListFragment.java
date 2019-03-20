package com.easternts.flowerworld.flowersubcategory.fragment;

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
import com.easternts.flowerworld.detailview.DetailActivity;
import com.easternts.flowerworld.flowersubcategory.adapter.RecyclerViewAdapter;
import com.easternts.flowerworld.flowersubcategory.model.FlowerViewModel;

import java.util.List;

public class FlowerSubcategoryListFragment extends Fragment implements RecyclerViewAdapter.OnItemClickListener {
    private static List<FlowerViewModel> SUBCATEGORYLIST;


    public FlowerSubcategoryListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int Id = getArguments().getInt("Id");
        Dalfile dalfile = new Dalfile(getActivity());
        dalfile.openDb();
        SUBCATEGORYLIST =dalfile.getSubFlower(Id);
        dalfile.closeDb();
        View view = inflater.inflate(R.layout.fragment_flower_subcategory_list, container, false);

        RecyclerView rvFlowerList = (RecyclerView) view.findViewById(R.id.rv_subcategory_list);
        rvFlowerList.setHasFixedSize(true);
        rvFlowerList.setNestedScrollingEnabled(false);
        rvFlowerList.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), SUBCATEGORYLIST);
        adapter.setOnItemClickListener(this);
        rvFlowerList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(View view, FlowerViewModel flowerViewModel) {
        DetailActivity.navigate((AppCompatActivity) getActivity(), view.findViewById(R.id.image),flowerViewModel);
    }
}
