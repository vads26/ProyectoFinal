package com.equipo6.proyectofinal.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.equipo6.proyectofinal.ui.filter.Tab1Fragment
import com.equipo6.proyectofinal.ui.filter.Tab2Fragment
import com.equipo6.proyectofinal.ui.filter.Tab3Fragment

class ParentFragmentPagerAdapter(
    fragmentActivity: Fragment
) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            2 -> Tab3Fragment()
            else -> Tab1Fragment()
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}
