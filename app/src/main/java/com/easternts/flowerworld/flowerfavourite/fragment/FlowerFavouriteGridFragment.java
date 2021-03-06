package com.easternts.flowerworld.flowerfavourite.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easternts.flowerworld.dal.Dalfile;
import com.easternts.flowerworld.R;
import com.easternts.flowerworld.flowerfavourite.favouriteview.FavouriteDetailActivity;
import com.easternts.flowerworld.flowersubcategory.adapter.RecyclerViewAdapter;
import com.easternts.flowerworld.flowersubcategory.model.FlowerViewModel;

import java.util.List;

public class FlowerFavouriteGridFragment extends Fragment implements RecyclerViewAdapter.OnItemClickListener {

    private static List<FlowerViewModel> items;
    private TextView tvNoData;

    public FlowerFavouriteGridFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flower_favourite_grid, container, false);
        tvNoData = (TextView) view.findViewById(R.id.no_data);
        RecyclerView rvFavouriteGrid = (RecyclerView) view.findViewById(R.id.rv_favourite_grid);
        try {
            Dalfile dalfile = new Dalfile(getActivity());
            dalfile.openDb();
            items = dalfile.getFavouriteFlowers();
            dalfile.closeDb();
            if (items.size() == 0) {
                rvFavouriteGrid.setVisibility(View.GONE);
                tvNoData.setTextColor(Color.parseColor("#000000"));
                tvNoData.setText(R.string.no_favourite_flower_add);
                tvNoData.setVisibility(View.VISIBLE);
            } else {
                rvFavouriteGrid.setVisibility(View.VISIBLE);
                tvNoData.setVisibility(View.GONE);
                rvFavouriteGrid.setHasFixedSize(true);
                rvFavouriteGrid.setNestedScrollingEnabled(false);
                rvFavouriteGrid.setLayoutManager(new GridLayoutManager(getActivity(), 2));

                RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), items);
                adapter.setOnItemClickListener(this);
                rvFavouriteGrid.setAdapter(adapter);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return view;
    }

    @Override
    public void onItemClick(View view, FlowerViewModel flowerViewModel) {
        getFragmentManager().isDestroyed();
        FavouriteDetailActivity.navigate((AppCompatActivity) getActivity(), view.findViewById(R.id.image), flowerViewModel);
    }
}
