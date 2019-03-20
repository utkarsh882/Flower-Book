package com.easternts.flowerworld.flowercategory.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.easternts.flowerworld.flowercategory.model.Category;
import com.easternts.flowerworld.R;
import com.easternts.flowerworld.util.Utils;

import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    private List<Category> mCategoryList;
    private OnItemClickListener onItemClickListener;
    private Context mContext;
    private String mCategoryKeyId = "category_key_id";
    private int mlastPosition = -1;
    private static final long[] delayList = {Utils.delayListTime, Utils.delayListTime, Utils.delayListTime, Utils.delayListTime, Utils.delayListTime, Utils.delayListTime};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        Category category = mCategoryList.get(position);
        holder.flowerCategoryName.setText(category.getmCategoryName());
        holder.flowerCategoryImage.setImageBitmap(null);
        Glide.with(holder.flowerCategoryImage.getContext())
                .load(category.getmImageId())
                .override(200, 100)
                .into(holder.flowerCategoryImage);
        holder.itemView.setTag(category);
    }

    @Override
    public void onViewAttachedToWindow(final ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        final long delayTime = delayList[new Random().nextInt(5)];
        holder.cv.setVisibility(View.INVISIBLE);

        if (holder.getPosition() > mlastPosition) {
            holder.cv.getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    holder.cv.setVisibility(View.VISIBLE);
                    ObjectAnimator alpha = ObjectAnimator.ofFloat(holder.cv, "alpha", 0f, 1f);
                    ObjectAnimator scaleY = ObjectAnimator.ofFloat(holder.cv, "scaleY", 0f, 1f);
                    ObjectAnimator scaleX = ObjectAnimator.ofFloat(holder.cv, "scaleX", 0f, 1f);
                    AnimatorSet animSet = new AnimatorSet();
                    animSet.play(alpha).with(scaleY).with(scaleX);
                    animSet.setInterpolator(new OvershootInterpolator());
                    animSet.setDuration(1000);
                    animSet.start();

                }
            }, delayTime);

            mlastPosition = holder.getPosition();
        } else {
            holder.cv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    @Override
    public void onClick(final View v) {
        onItemClickListener.onItemClick(v, (Category) v.getTag());
    }

    public RecyclerViewAdapter(List<Category> categoryList, Context context) {
        this.mCategoryList = categoryList;
        this.mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cv;
        public ImageView flowerCategoryImage;
        public TextView flowerCategoryName;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            flowerCategoryImage = (ImageView) itemView.findViewById(R.id.flower_category_image);
            flowerCategoryName = (TextView) itemView.findViewById(R.id.flower_category_name);

        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, Category category);

    }

}
