package com.app.countriesapp.ui.fragments.details;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.countriesapp.databinding.FragmentDetailsBinding;
import com.app.countriesapp.databinding.FragmentDetailsIranBinding;
import com.app.countriesapp.ux.model.AmericaModel;
import com.app.countriesapp.ux.model.IranModel;
import com.bumptech.glide.Glide;

public class DetailsFragmentIran extends Fragment {
    private FragmentDetailsIranBinding binding;
    private IranModel iranModel;
    private static final String TAG = "DetailsFragmentIran";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iranModel = (IranModel) getArguments().getSerializable("IRAN_MODEL");
        Log.i(TAG, "onCreate: " + iranModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsIranBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(requireActivity()).load(iranModel.getIranImage()).into(binding.imageviewIranDetails);
        binding.textviewIranNameDetails.setText(iranModel.getIranName());
    }

}
