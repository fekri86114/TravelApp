package com.app.countriesapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.countriesapp.R;
import com.app.countriesapp.ui.model.AmericaModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class AmericaAdapter extends RecyclerView.Adapter<AmericaAdapter.AmericaViewHolder> {
    private final List<AmericaModel> americaModelList;

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

}
