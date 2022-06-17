package com.app.countriesapp.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.countriesapp.R;
import com.app.countriesapp.databinding.FragmentAboutUsBinding;
import com.app.countriesapp.databinding.FragmentAmericaBinding;

public class AboutUsFragment extends Fragment implements View.OnClickListener{
    private AppCompatTextView gMail, gitHub, linkedIn;
    private FragmentAboutUsBinding binding;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAboutUsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gitHub = binding.githubLink.findViewById(R.id.github_link);
        linkedIn = binding.linkedinLink.findViewById(R.id.linkedin_link);

        gitHub.setOnClickListener(this);
        linkedIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (getId()) {
            case R.id.linkedin_link:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/fekri86114")));
                break;

            case R.id.github_link:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mohammadreza-fekri-057a68223/")));
                break;
        }
    }
}