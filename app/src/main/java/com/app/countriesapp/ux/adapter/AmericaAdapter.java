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
import com.app.countriesapp.ux.model.AmericaModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class AmericaAdapter extends RecyclerView.Adapter<AmericaAdapter.AmericaViewHolder> {
    private final List<AmericaModel> americaModelList;
    private int lastPosition = -1;

    public AmericaAdapter(List<AmericaModel> americaModelList) {
        this.americaModelList = americaModelList;
    }

    @NonNull
    @Override
    public AmericaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new AmericaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_america, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AmericaViewHolder holder, int position) {
        AmericaModel americaModel = americaModelList.get(position);
        Glide.with(holder.itemView.getContext()).load(americaModel.getAmericaImage()).into(holder.imageViewAmerica);
        holder.textViewAmerica.setText(americaModel.getAmericaName());

        setFadeAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return americaModelList.size();
    }

    public static class AmericaViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView textViewAmerica;
        private final AppCompatImageView imageViewAmerica;

        public AmericaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAmerica = itemView.findViewById(R.id.textview_america);
            imageViewAmerica = itemView.findViewById(R.id.imageview_america);
        }
    }
    private void setFadeAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.enter_from_left_slide);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}