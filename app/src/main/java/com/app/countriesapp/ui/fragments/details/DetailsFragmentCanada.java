package com.app.countriesapp.ui.fragments.details;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.app.countriesapp.databinding.FragmentDetailsCanadaBinding;
import com.app.countriesapp.ux.model.CanadaModel;
import com.bumptech.glide.Glide;

public class DetailsFragmentCanada extends Fragment {

    private FragmentDetailsCanadaBinding binding;
    private CanadaModel canadaModel;
    private static final String TAG = "DetailsFragmentCanada";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canadaModel = (CanadaModel) getArguments().getSerializable("CANADA_MODEL");
        Log.i(TAG, "onCreate: " + canadaModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsCanadaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(requireActivity()).load(canadaModel.getCanadaImage()).into(binding.imageviewCanadaDetails);
        binding.textviewCanadaNameDetails.setText(canadaModel.getCanadaName());
    }
}
