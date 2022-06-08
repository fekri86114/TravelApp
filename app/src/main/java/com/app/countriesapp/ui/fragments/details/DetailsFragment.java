package com.app.countriesapp.ui.fragments.details;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.countriesapp.databinding.FragmentDetailsBinding;
import com.app.countriesapp.ux.model.AmericaModel;
import com.bumptech.glide.Glide;

public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;
    private AmericaModel americaModel;
    private static final String TAG = "DetailsFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       americaModel = (AmericaModel) getArguments().getSerializable("AMERICA_MODEL");
        Log.i(TAG, "onCreate: " + americaModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(requireActivity()).load(americaModel.getAmericaImage()).into(binding.imageviewAmericaDetails);
        binding.textviewAmericaNameDetails.setText(americaModel.getAmericaName());
    }
}
