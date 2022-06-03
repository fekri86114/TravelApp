package com.app.countriesapp.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.countriesapp.databinding.FragmentAmericaBinding;
import com.app.countriesapp.ux.adapter.AmericaAdapter;
import com.app.countriesapp.ux.model.AmericaModel;

import java.util.ArrayList;
import java.util.List;

public class AmericaFragment extends Fragment {

private FragmentAmericaBinding binding;
private AmericaAdapter americaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAmericaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        americaAdapter = new AmericaAdapter(setListData());
        binding.recyclerviewAmerica.setHasFixedSize(true);
        binding.recyclerviewAmerica.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerviewAmerica.setAdapter(americaAdapter);
    }

    private List<AmericaModel> setListData(){
        List<AmericaModel> listItem = new ArrayList<>();
        listItem.add(new AmericaModel("https://i.pinimg.com/736x/c7/5c/e1/c75ce1ad67382bba705d94d37b0ca9bd.jpg", "White House"));
        listItem.add(new AmericaModel("https://upload.wikimedia.org/wikipedia/commons/0/0c/GoldenGateBridge-001.jpg", "Bridge"));
        listItem.add(new AmericaModel("https://www.followmeaway.com/wp-content/uploads/2019/05/Castles-in-America-Alexandria-Bay-New-York-.jpg", "Castle"));
        listItem.add(new AmericaModel("https://www.worldatlas.com/r/w1200/upload/81/ba/f8/shutterstock-91150394.jpg", "Statue of Liberty"));
        listItem.add(new AmericaModel("https://media.cntraveler.com/photos/6114162c98f72af89032b677/master/pass/Borealis%20Basecamp_0oHPeCPQ.jpeg", "Igloo"));
        listItem.add(new AmericaModel("https://npca.s3.amazonaws.com/images/8944/6253678b-af18-4981-a7a8-d92abf0dbcca-banner.jpg?1445971287", "Mount Rushmore"));
        listItem.add(new AmericaModel("https://a.cdn-hotels.com/gdcs/production163/d1220/05c72d71-a9f3-4805-9733-00a1b1d26593.jpg?impolicy=fcrop&w=800&h=533&q=medium", "Alaska Home"));
        listItem.add(new AmericaModel("https://media.glassdoor.com/l/77/d1/ca/78/harvard-university.jpg", "Harvard University"));
        listItem.add(new AmericaModel("https://cdnapisec.kaltura.com/p/537811/thumbnail/entry_id/1_7vli4o6f/width/1280/height/720", "Cornell University"));
        listItem.add(new AmericaModel("https://static01.nyt.com/images/2020/03/08/nyregion/08xp-columbia1/08xp-columbia1-videoSixteenByNineJumbo1600.jpg", "Colombia University"));
        listItem.add(new AmericaModel("https://news.virginia.edu/sites/default/files/article_image/spring-2021-header_ss.jpg", "University of Virginia"));
        listItem.add(new AmericaModel("https://applyplus.org/img/University/13-12-2019-1576256632.jpg", "Stanford University"));

        return listItem;
    }


}