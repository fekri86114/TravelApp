package com.app.countriesapp.ui.fragments.details;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.countriesapp.databinding.FragmentDetailsIranBinding;
import com.app.countriesapp.databinding.FragmentDetailsSwitzerlandBinding;
import com.app.countriesapp.ux.model.IranModel;
import com.app.countriesapp.ux.model.SwitzerlandModel;
import com.bumptech.glide.Glide;

public class DetailsFragmentSwitzerland extends Fragment {
    private FragmentDetailsSwitzerlandBinding binding;
    private SwitzerlandModel switzerlandModel;
    private static final String TAG = "DetailsFragmentSwitzerland";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switzerlandModel = (SwitzerlandModel) getArguments().getSerializable("SWITZERLAND_MODEL");
        Log.i(TAG, "onCreate: " + switzerlandModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsSwitzerlandBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(requireActivity()).load(switzerlandModel.getSwitzerlandImage()).into(binding.imageviewSwitzerlandDetails);
        binding.textviewSwitzerlandNameDetails.setText(switzerlandModel.getSwitzerlandName());
    }

}
