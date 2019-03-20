package com.easternts.flowerworld.flowersubcategory.adapter;

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
import com.easternts.flowerworld.R;
import com.easternts.flowerworld.flowersubcategory.model.FlowerViewModel;
import com.easternts.flowerworld.util.Utils;

import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private List<FlowerViewModel> floweritems;
    private OnItemClickListener onItemClickListener;
    private Context context;
    //    private int s1;
    private int lastPosition = -1;
    private static final long[] delayList = {Utils.delayListTime, Utils.delayListTime, Utils.delayListTime, Utils.delayListTime, Utils.delayListTime, Utils.delayListTime};

    public RecyclerViewAdapter(Context context, List<FlowerViewModel> floweritems) {
        this.floweritems = floweritems;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        FlowerViewModel item = floweritems.get(position);
        holder.text.setText(context.getString(item.getFlowername()));
        holder.imageview.setImageBitmap(null);
        Glide.with(holder.imageview.getContext())
                .load(item.getFlowerimage())
                .override(200, 100)
//                .centerCrop()
//                .fitCenter()
                .into(holder.imageview);

        holder.itemView.setTag(item);

    }

    @Override
    public void onViewAttachedToWindow(final ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        final long delayTime = delayList[new Random().nextInt(5)];
        holder.cv.setVisibility(View.INVISIBLE);

        if (holder.getPosition() > lastPosition) {
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

            lastPosition = holder.getPosition();
        } else {
            holder.cv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return floweritems.size();
    }

    @Override
    public void onClick(final View v) {
        onItemClickListener.onItemClick(v, (FlowerViewModel) v.getTag());
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageview;
        public TextView text;
        public CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            imageview = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, FlowerViewModel flowerViewModel);

    }
}
