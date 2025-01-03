package com.example.assignmaent;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new AllEventsFragment();
            case 1:
                return new PartyFragment();
            case 2:
                return new TechEventsFragment();
            case 3:
                return new ProgrammingMarathonFragment();
            default:
                return new AllEventsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4; // عدد علامات التبويب
    }



}
