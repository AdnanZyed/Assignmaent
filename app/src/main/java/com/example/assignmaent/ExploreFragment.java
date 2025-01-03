package com.example.assignmaent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.assignmaent.R;
import com.example.assignmaent.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
public class ExploreFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        tabLayout = view.findViewById(R.id.tab);
        viewPager = view.findViewById(R.id.vew_pager2);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("All Events");
                    break;
                case 1:
                    tab.setText("Party");
                    break;
                case 2:
                    tab.setText("Tech Events");
                    break;
                case 3:
                    tab.setText("Programming Marathon");
                    break;
                default:
                    tab.setText("Tab " + position);
                    break;
            }
        }).attach();

        return view;
    }

    public boolean isDefaultTabSelected() {
        return viewPager.getCurrentItem() == 0;
    }

    public void setDefaultTab() {
        viewPager.setCurrentItem(0);
    }
}
