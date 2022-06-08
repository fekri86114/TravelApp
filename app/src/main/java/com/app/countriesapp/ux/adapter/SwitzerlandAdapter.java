package com.app.countriesapp.ux.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.countriesapp.R;
import com.app.countriesapp.ux.model.IranModel;
import com.app.countriesapp.ux.model.SwitzerlandModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class SwitzerlandAdapter extends RecyclerView.Adapter<SwitzerlandAdapter.SwitzerlandViewHolder> {
    private final List<SwitzerlandModel> switzerlandModelList;
    public SwitzerlandAdapter.SetOnItemClickListener listener;
    private int lastPosition = -1;

    public SwitzerlandAdapter(List<SwitzerlandModel> switzerlandModelList, SwitzerlandAdapter.SetOnItemClickListener listener) {
        this.switzerlandModelList = switzerlandModelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SwitzerlandAdapter.SwitzerlandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new SwitzerlandAdapter.SwitzerlandViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_switzerland, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SwitzerlandAdapter.SwitzerlandViewHolder holder, int position) {
        SwitzerlandModel switzerlandModel = switzerlandModelList.get(position);
        Glide.with(holder.itemView.getContext()).load(switzerlandModel.getSwitzerlandImage()).into(holder.imageViewSwitzerland);
        holder.textViewSwitzerland.setText(switzerlandModel.getSwitzerlandName());
        setFadeAnimation(holder.itemView, position);
        holder.itemView.setOnClickListener(view -> listener.ItemClickedSwitzerland(switzerlandModel));
    }

    private void setFadeAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.enter_from_left_slide);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public static class SwitzerlandViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView textViewSwitzerland;
        private final AppCompatImageView imageViewSwitzerland;

        public SwitzerlandViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSwitzerland = itemView.findViewById(R.id.textview_switzerland);
            imageViewSwitzerland = itemView.findViewById(R.id.imageview_switzerland);
        }
    }
    @Override
    public int getItemCount() {
        return switzerlandModelList.size();
    }
    public interface SetOnItemClickListener{
        void ItemClickedSwitzerland(SwitzerlandModel switzerlandModel);
    }
}
