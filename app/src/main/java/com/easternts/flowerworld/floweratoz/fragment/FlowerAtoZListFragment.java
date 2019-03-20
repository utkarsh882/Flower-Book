package com.easternts.flowerworld.floweratoz.fragment;


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
import com.easternts.flowerworld.floweratoz.atozview.AtoZDetailActivity;
import com.easternts.flowerworld.flowersubcategory.adapter.RecyclerViewAdapter;
import com.easternts.flowerworld.flowersubcategory.model.FlowerViewModel;

import java.util.List;


public class FlowerAtoZListFragment extends Fragment implements RecyclerViewAdapter.OnItemClickListener {

    private static List<FlowerViewModel> items;

    public FlowerAtoZListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Dalfile dalfile = new Dalfile(getActivity());
        dalfile.openDb();
        items = dalfile.getAtoZFlowers();
        dalfile.closeDb();
        View view = inflater.inflate(R.layout.fragment_floweratozlist, container, false);

        RecyclerView rv_a_to_z_list = (RecyclerView) view.findViewById(R.id.rv_a_to_z_list);
        rv_a_to_z_list.setHasFixedSize(true);
        rv_a_to_z_list.setNestedScrollingEnabled(false);
        rv_a_to_z_list.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),items);
        adapter.setOnItemClickListener(this);
        rv_a_to_z_list.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(View view, FlowerViewModel flowerViewModel) {
        AtoZDetailActivity.navigate((AppCompatActivity) getActivity(), view.findViewById(R.id.image),flowerViewModel);
    }
}
