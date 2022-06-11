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
import com.app.countriesapp.ux.model.CanadaModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class CanadaAdapter extends RecyclerView.Adapter<CanadaAdapter.CanadaViewHolder> {
    private final List<CanadaModel> canadaModelList;
    public SetOnItemClickListener listener;
    public SetOnMenuClickListenerCanada menuClickListenerCanada;
    private int lastPosition = -1;

    public CanadaAdapter(List<CanadaModel> canadaModelList, SetOnItemClickListener listener, SetOnMenuClickListenerCanada menuClickListenerCanada) {
        this.canadaModelList = canadaModelList;
        this.listener = listener;
        this.menuClickListenerCanada = menuClickListenerCanada;
    }

    public static class CanadaViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView textViewCanada;
        private final AppCompatImageView imageViewCanada;
        private AppCompatImageView imageMenuCanada;


        public CanadaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCanada = itemView.findViewById(R.id.textview_canada);
            imageViewCanada = itemView.findViewById(R.id.imageview_canada);
            imageMenuCanada = itemView.findViewById(R.id.imageview_popup_menu_canada);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CanadaAdapter.CanadaViewHolder holder, int position) {
        CanadaModel canadaModel = canadaModelList.get(position);
        Glide.with(holder.itemView.getContext()).load(canadaModel.getCanadaImage()).into(holder.imageViewCanada);
        holder.textViewCanada.setText(canadaModel.getCanadaName());
        setFadeAnimation(holder.itemView, position);
        holder.itemView.setOnClickListener(view -> listener.ItemClickedCanada(canadaModel, position));
        holder.imageMenuCanada.setOnClickListener(view -> menuClickListenerCanada.MenuClickedCanada(holder.imageMenuCanada));
    }

    @NonNull
    @Override
    public CanadaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CanadaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_canada, parent, false));
    }

    private void setFadeAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.enter_from_left_slide);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return canadaModelList.size();
    }

    public interface SetOnItemClickListener{
        void ItemClickedCanada(CanadaModel canadaModel, int position);
    }
    public interface SetOnMenuClickListenerCanada{
        void MenuClickedCanada(View view);
    }
    public void deleteItem(int position){
        canadaModelList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

}
