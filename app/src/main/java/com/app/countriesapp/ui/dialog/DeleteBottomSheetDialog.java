package com.app.countriesapp.ui.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.countriesapp.databinding.BottomSheetDeleteLayoutBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class DeleteBottomSheetDialog extends BottomSheetDialogFragment {
    private BottomSheetDeleteLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BottomSheetDeleteLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonCancel.setOnClickListener(it -> {
            dismiss();
        });
        binding.buttonConfirm.setOnClickListener(it -> {
            Toast.makeText(getContext(), "Confirm", Toast.LENGTH_SHORT).show();
        });

    }
}
