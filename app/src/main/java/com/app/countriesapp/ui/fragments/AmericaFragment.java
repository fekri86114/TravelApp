package com.app.countriesapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.app.countriesapp.R;
import com.app.countriesapp.databinding.FragmentAmericaBinding;
import com.app.countriesapp.ux.adapter.AmericaAdapter;
import com.app.countriesapp.ux.model.AmericaModel;

import java.util.ArrayList;
import java.util.List;

public class AmericaFragment extends Fragment implements AmericaAdapter.SetOnItemClickListener, AmericaAdapter.SetOnMenuClickListener {

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
        setupRecyclerview();
    }

    private void setupRecyclerview() {
        americaAdapter = new AmericaAdapter(setListData(), this, this);
        binding.recyclerviewAmerica.setHasFixedSize(true);
        binding.recyclerviewAmerica.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerviewAmerica.setAdapter(americaAdapter);
    }

    private List<AmericaModel> setListData() {
        List<AmericaModel> listItem = new ArrayList<>();
        listItem.add(new AmericaModel("https://i.pinimg.com/originals/29/4a/df/294adf525edf1ab4e94db8039159794c.jpg", "White House"));
        listItem.add(new AmericaModel("https://i.pinimg.com/originals/23/37/03/233703cfaae80a3c24fc652f7ace910a.jpg", "Bridge"));
        listItem.add(new AmericaModel("https://www.roadaffair.com/wp-content/uploads/2021/11/castle-kentucky-usa-shutterstock_130598195.jpg", "Castle"));
        listItem.add(new AmericaModel("https://www.worldatlas.com/r/w1200/upload/81/ba/f8/shutterstock-91150394.jpg", "Statue of Liberty"));
        listItem.add(new AmericaModel("https://media.cntraveler.com/photos/6114162c98f72af89032b677/master/pass/Borealis%20Basecamp_0oHPeCPQ.jpeg", "Igloo"));
        listItem.add(new AmericaModel("https://npca.s3.amazonaws.com/images/8944/6253678b-af18-4981-a7a8-d92abf0dbcca-banner.jpg?1445971287", "Mount Rushmore"));
        listItem.add(new AmericaModel("https://auroracabin.com/wp-content/uploads/2015/02/Aurora-Lodge-2.jpg", "Alaska Home"));
        listItem.add(new AmericaModel("https://media.glassdoor.com/l/77/d1/ca/78/harvard-university.jpg", "Harvard University"));
        listItem.add(new AmericaModel("https://cdnapisec.kaltura.com/p/537811/thumbnail/entry_id/1_7vli4o6f/width/1280/height/720", "Cornell University"));
        listItem.add(new AmericaModel("https://static01.nyt.com/images/2020/03/08/nyregion/08xp-columbia1/08xp-columbia1-videoSixteenByNineJumbo1600.jpg", "Colombia University"));
        listItem.add(new AmericaModel("https://news.virginia.edu/sites/default/files/article_image/spring-2021-header_ss.jpg", "University of Virginia"));
        listItem.add(new AmericaModel("https://applyplus.org/img/University/13-12-2019-1576256632.jpg", "Stanford University"));
        listItem.add(new AmericaModel("http://ezapply.ir/sliders/slider_1597861061.png", "Duke University"));
        listItem.add(new AmericaModel("https://ezapply.ir/sliders/slider_1493112852.jpeg", "University of Illinois at Chicago"));

        return listItem;
    }

    @Override
    public void ItemClicked(AmericaModel americaModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("AMERICA_MODEL", americaModel);
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_nav_america_to_detailsFragment2, bundle);
    }

    @Override
    public void MenuClicked(View view) {
        showPopupMenu(view);
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(getContext(), "You Clicked: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popupMenu.show();
    }
}