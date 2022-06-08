package com.app.countriesapp.ui.fragments;

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
import com.app.countriesapp.databinding.FragmentIranBinding;
import com.app.countriesapp.databinding.FragmentSwitzerlandBinding;
import com.app.countriesapp.ux.adapter.IranAdapter;
import com.app.countriesapp.ux.adapter.SwitzerlandAdapter;
import com.app.countriesapp.ux.model.IranModel;
import com.app.countriesapp.ux.model.SwitzerlandModel;

import java.util.ArrayList;
import java.util.List;


public class SwitzerlandFragment extends Fragment implements SwitzerlandAdapter.SetOnItemClickListener{

    private FragmentSwitzerlandBinding binding;
    private SwitzerlandAdapter switzerlandAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSwitzerlandBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerview();
    }

    private void setupRecyclerview() {
        switzerlandAdapter = new SwitzerlandAdapter(setListData(), this);
        binding.recyclerviewIran.setHasFixedSize(true);
        binding.recyclerviewIran.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerviewIran.setAdapter(switzerlandAdapter);
    }

    private List<SwitzerlandModel> setListData(){
        List<SwitzerlandModel> listItem = new ArrayList<>();
        listItem.add(new SwitzerlandModel("https://www.wanderluststorytellers.com/wp-content/uploads/2017/10/Most-Beautiful-Places-in-Switzerland-1080x720.jpg", "Beautiful Place"));
        listItem.add(new SwitzerlandModel("https://www.wanderluststorytellers.com/wp-content/uploads/2017/10/Jungfraujoch-Switzerland_thumb-1-e1596513224915.jpg", "Mountain and Train"));
        listItem.add(new SwitzerlandModel("https://www.wanderluststorytellers.com/wp-content/uploads/2017/10/Interlaken-Switzerland-e1596513366524.jpg", "Homes"));
        listItem.add(new SwitzerlandModel("https://www.wanderluststorytellers.com/wp-content/uploads/2017/10/Bern-Switzerland_thumb-e1596514026504.jpg", "Bern City"));
        listItem.add(new SwitzerlandModel("https://www.wanderluststorytellers.com/wp-content/uploads/2017/10/Lake-Geneva-Switzerland_thumb-e1596514092570.jpg", "Lake Geneva"));
        listItem.add(new SwitzerlandModel("https://www.wanderluststorytellers.com/wp-content/uploads/2017/10/The-Matterhorn-Switzerland_thumb-1-e1596514193452.jpg", "The Matterhorn"));
        listItem.add(new SwitzerlandModel("https://www.wanderluststorytellers.com/wp-content/uploads/2017/10/M%C3%BCrren-Switzerland_thumb-e1596514362648.jpg", "Mürren"));
        listItem.add(new SwitzerlandModel("https://applyplus.org/img/University/13-05-2020-1589369097.jpg", "University of Geneva"));
        listItem.add(new SwitzerlandModel("http://gsia.tums.ac.ir/Images/UserFiles/2986/image/ISLH/University_of_Zurich_welcome_video.jpg", "University Zurich(Zürich)"));
        listItem.add(new SwitzerlandModel("http://ezapply.ir/sliders/slider_1504424719.jpg","University of Bern"));
        listItem.add(new SwitzerlandModel("https://samanstudy.com/wp-content/uploads/2021/09/unil-uni.jpg", "University of Lausanne"));
        listItem.add(new SwitzerlandModel("https://ezapply.ir/sliders/slider_1534595978.jpg", "University of St. Gallen"));
        listItem.add(new SwitzerlandModel("https://mapio.net/images-p/2715268.jpg", "University of Neuchâtel"));
        listItem.add(new SwitzerlandModel("https://ezapply.ir/sliders/slider_1506092813.jpg", "University Basel"));

        return listItem;
    }

    @Override
    public void ItemClickedSwitzerland(SwitzerlandModel switzerlandModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("SWITZERLAND_MODEL", switzerlandModel);
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_nav_switzerland_to_detailsFragmentSwitzerland, bundle);
    }
}