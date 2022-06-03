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
import android.widget.Toast;

import com.app.countriesapp.R;
import com.app.countriesapp.databinding.FragmentAmericaBinding;
import com.app.countriesapp.databinding.FragmentCanadaBinding;
import com.app.countriesapp.ux.adapter.AmericaAdapter;
import com.app.countriesapp.ux.adapter.CanadaAdapter;
import com.app.countriesapp.ux.model.AmericaModel;
import com.app.countriesapp.ux.model.CanadaModel;

import java.util.ArrayList;
import java.util.List;

public class CanadaFragment extends Fragment implements CanadaAdapter.SetOnItemClickListener{

    private FragmentCanadaBinding binding;
    private CanadaAdapter canadaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCanadaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerview();
    }

    private void setupRecyclerview() {
        canadaAdapter = new CanadaAdapter(setListData(), this);
        binding.recyclerviewCanada.setHasFixedSize(true);
        binding.recyclerviewCanada.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerviewCanada.setAdapter(canadaAdapter);
    }

    private List<CanadaModel> setListData(){
        List<CanadaModel> listItem = new ArrayList<>();
        listItem.add(new CanadaModel("http://cdn.cnn.com/cnnnext/dam/assets/140630124917-12-canada-most-beautiful-places.jpg", "Night"));
        listItem.add(new CanadaModel("https://globalgrasshopper.com/wp-content/uploads/2012/11/The-Rockies-Canada.jpg", "Mountain"));
        listItem.add(new CanadaModel("https://img.theculturetrip.com/wp-content/uploads/2021/05/kbace2-e1623920797764.jpg", "Light City"));
        listItem.add(new CanadaModel("https://media.cntraveler.com/photos/56cb76deb19e7d9b785202d9/master/pass/notre-dame-basilica-montreal-cr-getty.jpg", "Beautiful Place"));
        listItem.add(new CanadaModel("https://wallpapercave.com/wp/wp4612335.jpg", "The Fall Season"));
        listItem.add(new CanadaModel("https://handluggageonly.co.uk/wp-content/uploads/2018/01/Hand-Luggage-Only-7-7.jpg", "Ice"));
        listItem.add(new CanadaModel("https://img.freepik.com/free-photo/niagara-falls-covered-greenery-blue-sky-sunlight-us_181624-19647.jpg?w=2000", "Niagara Falls"));
        listItem.add(new CanadaModel("https://sabaplan.net/wp-content/uploads/2021/12/%D8%AF%D8%A7%D9%86%D8%B4%DA%AF%D8%A7%D9%87-%D8%A8%D8%B1%DB%8C%D8%AA%DB%8C%D8%B4-%DA%A9%D9%84%D9%85%D8%A8%DB%8C%D8%A7-%DA%A9%D8%A7%D9%86%D8%A7%D8%AF%D8%A7.webp", "University of British Columbia"));
        listItem.add(new CanadaModel("https://safirapply.com/wp-content/uploads/2020/12/University-of-Alberta_campus-min.jpg", "University of Alberta"));
        listItem.add(new CanadaModel("https://fa.gsiedu.com/wp-content/uploads/sites/2/2019/04/University-of-Toronto-900x492.jpg", "University of Toronto"));
        listItem.add(new CanadaModel("https://zanco.ir/upload/media/processed/thumb-1200-1200/8/j/8.jpg?1581251106", "University of Ottawa"));
        listItem.add(new CanadaModel("https://d15gkqt2d16c1n.cloudfront.net/images/universities/backgrounds/York-University-Toronto-bg.jpg", "University of York"));
        listItem.add(new CanadaModel("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Thorvaldson.jpg/1200px-Thorvaldson.jpg", "University of Saskatchewan"));
        listItem.add(new CanadaModel("https://trustimm.com/wp-content/uploads/2020/06/university-of-victoria-canada-trustimm.jpg", "University of Victoria"));

        return listItem;
    }



    @Override
    public void ItemClickedCanada(CanadaModel canadaModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("CANADA_MODEL", canadaModel);
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_nav_canada_to_detailsFragmentCanada, bundle);
    }
}