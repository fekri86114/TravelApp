package com.app.countriesapp.ui.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.countriesapp.R;
import com.app.countriesapp.databinding.FragmentCanadaBinding;
import com.app.countriesapp.databinding.FragmentIranBinding;
import com.app.countriesapp.ux.adapter.CanadaAdapter;
import com.app.countriesapp.ux.adapter.IranAdapter;
import com.app.countriesapp.ux.model.CanadaModel;
import com.app.countriesapp.ux.model.IranModel;

import java.util.ArrayList;
import java.util.List;

public class IranFragment extends Fragment implements IranAdapter.SetOnItemClickListener{

    private FragmentIranBinding binding;
    private IranAdapter iranAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIranBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerview();
    }

    private void setupRecyclerview() {
        iranAdapter = new IranAdapter(setListData(), this);
        binding.recyclerviewIran.setHasFixedSize(true);
        binding.recyclerviewIran.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerviewIran.setAdapter(iranAdapter);
    }

    private List<IranModel> setListData(){
        List<IranModel> listItem = new ArrayList<>();
        listItem.add(new IranModel("https://img.theculturetrip.com/wp-content/uploads/2015/07/shutterstock_343001582-masuleh-vilage-gilan-iran.jpg", "Gilan Village"));
        listItem.add(new IranModel("https://www.theglobetrottingdetective.com/wp-content/uploads/2021/03/Pink-Mosque-Shiraz.jpg", "Shiraz Mosque"));
        listItem.add(new IranModel("https://www.theglobetrottingdetective.com/wp-content/uploads/2020/12/Most-Beautiful-Places-in-Iran-Itinerary-Naqsh-e-Jahan-Square-Isfahan-AdobeStock_296771164-1024x684.jpg", "Naqshe-Jahan"));
        listItem.add(new IranModel("http://cdn.cnn.com/cnnnext/dam/assets/160210133440-eram-garden--shiraz-7.jpg", "Eram Garden"));
        listItem.add(new IranModel("https://www.theglobetrottingdetective.com/wp-content/uploads/2020/12/Most-beautiful-places-in-Iran-Khaju-Bridge-Isfahan-1024x665.jpg", "Khaju Bridge"));
        listItem.add(new IranModel("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Azadi_Tower_%2829358497718%29_%28cropped%29.jpg/1200px-Azadi_Tower_%2829358497718%29_%28cropped%29.jpg", "Azadi Tower"));
        listItem.add(new IranModel("https://shoesyourpath.com/wp-content/uploads/2018/04/iran-kerman-desert-lut-kalut-3.jpg", "Loot Desert"));
        listItem.add(new IranModel("https://rasekhoon.net/_files/images/media/Sharif%20University1-compressed(1).jpg", "Sharif University"));
        listItem.add(new IranModel("https://img9.irna.ir/old/Image/1397/13971212/83229844/N83229844-72879597.jpg", "University of Science and Technology"));
        listItem.add(new IranModel("https://media.ana.press/old/1398/08/04/637077028149403332_lg.jpg", "Amirkabir University"));
        listItem.add(new IranModel("https://ketabchi.com/blog/wp-content/uploads/2021/07/%D8%B3%D8%B2%DB%8C%D8%A8%D8%B1%DB%8C%D9%84%D8%B0%D8%B1%D8%A8%D8%B0%D8%A8%D8%B0%D9%85%D8%A8%D8%B0%D9%85%D8%A8%D9%85%D8%B0%D9%86-scaled.jpg", "Tehran University"));
        listItem.add(new IranModel("https://uma.ac.ir/files/chancellor/images/%DA%AF%D8%A7%D9%84%D8%B1%DB%8C_%D8%AA%D8%B5%D8%A7%D9%88%DB%8C%D8%B1/%D8%AF%D8%A7%D9%86%D8%B4%DA%AF%D8%A7%D9%87_%D8%AF%D8%B1_%D8%B2%D9%85%D8%B3%D8%AA%D8%A7%D9%86_1396/18%D8%A2%D8%A8%D8%A7%D9%86/3.jpg", "UMA University"));
        listItem.add(new IranModel("https://isic.ir/wp-content/uploads/2019/08/%D8%B5%D9%86%D8%B9%D8%AA%DB%8C-%D8%A7%D8%B5%D9%81%D9%87%D8%A7%D9%86.jpg", "Isfahan University of Technology"));
        listItem.add(new IranModel("https://www.sbu.ac.ir/documents/46019/275425/slider-1.jpg/c10a969f-6e9f-e3b2-a2d2-54178058edf3?t=1598103283394&download=true", "Shahid Beheshti University"));

        return listItem;
    }

    @Override
    public void ItemClickedIran(IranModel iranModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("IRAN_MODEL", iranModel);
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_nav_iran_to_detailsFragmentIran, bundle);
    }
}