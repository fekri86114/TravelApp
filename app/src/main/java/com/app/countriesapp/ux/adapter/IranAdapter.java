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
import com.app.countriesapp.ui.fragments.SwitzerlandFragment;
import com.app.countriesapp.ux.model.AmericaModel;
import com.app.countriesapp.ux.model.IranModel;
import com.app.countriesapp.ux.model.SwitzerlandModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class IranAdapter extends RecyclerView.Adapter<IranAdapter.IranViewHolder> {
    private final List<IranModel> iranModelList;
    public IranAdapter.SetOnItemClickListener listener;
    private int lastPosition = -1;

    public IranAdapter(List<IranModel> iranModelList, IranAdapter.SetOnItemClickListener listener) {
        this.iranModelList = iranModelList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public IranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new IranViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_iran, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IranViewHolder holder, int position) {
        IranModel iranModel = iranModelList.get(position);
        Glide.with(holder.itemView.getContext()).load(iranModel.getIranImage()).into(holder.imageViewIran);
        holder.textViewIran.setText(iranModel.getIranName());
        setFadeAnimation(holder.itemView, position);
        holder.itemView.setOnClickListener(view -> listener.ItemClickedIran(iranModel));
    }

    private void setFadeAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.enter_from_left_slide);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public static class IranViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView textViewIran;
        private final AppCompatImageView imageViewIran;

        public IranViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewIran = itemView.findViewById(R.id.textview_iran);
            imageViewIran = itemView.findViewById(R.id.imageview_iran);
        }
    }
    @Override
    public int getItemCount() {
        return iranModelList.size();
    }
    public interface SetOnItemClickListener{
        void ItemClickedIran(IranModel iranModel);
    }
}
