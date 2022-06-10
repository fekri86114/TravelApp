package com.app.countriesapp.ux.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

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
    public SetOnItemClickListener listener;
    public SetOnMenuClickListener menuClickListener;
    private int lastPosition = -1;

    public AmericaAdapter(List<AmericaModel> americaModelList, SetOnItemClickListener listener, SetOnMenuClickListener menuClickListener) {
        this.americaModelList = americaModelList;
        this.listener = listener;
        this.menuClickListener = menuClickListener;
    }

    public static class AmericaViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView textViewAmerica;
        private AppCompatImageView imageViewAmerica;
        private AppCompatImageView imageMenu;

        public AmericaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAmerica = itemView.findViewById(R.id.textview_america);
            imageViewAmerica = itemView.findViewById(R.id.imageview_america);
            imageMenu = itemView.findViewById(R.id.imageview_popup_menu);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull AmericaViewHolder holder, int position) {
        AmericaModel americaModel = americaModelList.get(position);
        Glide.with(holder.itemView.getContext()).load(americaModel.getAmericaImage()).into(holder.imageViewAmerica);
        holder.textViewAmerica.setText(americaModel.getAmericaName());
        setFadeAnimation(holder.itemView, position);
        holder.itemView.setOnClickListener(view -> listener.ItemClicked(americaModel));
        holder.imageMenu.setOnClickListener(view -> menuClickListener.MenuClicked(holder.imageMenu));
    }

    @NonNull
    @Override
    public AmericaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new AmericaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_america, parent, false));
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
        return americaModelList.size();
    }
    public interface SetOnItemClickListener{
        void ItemClicked(AmericaModel americaModel);
    }
    public interface SetOnMenuClickListener{
        void MenuClicked(View view);
    }
}
