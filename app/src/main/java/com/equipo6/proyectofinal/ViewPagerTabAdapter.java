package com.equipo6.proyectofinal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.equipo6.proyectofinal.ui.filter.Tab1Fragment;
import com.equipo6.proyectofinal.ui.filter.Tab2Fragment;
import com.equipo6.proyectofinal.ui.filter.Tab3Fragment;

public class ViewPagerTabAdapter extends FragmentStateAdapter {

    public ViewPagerTabAdapter(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1 :
                return new Tab2Fragment();
            case 2:
                return new Tab3Fragment();
            default:
                return  new Tab1Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
