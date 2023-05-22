package com.equipo6.proyectofinal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.equipo6.proyectofinal.ViewPagerTabAdapter
import com.equipo6.proyectofinal.adapter.ParentFragmentPagerAdapter
import com.equipo6.proyectofinal.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    lateinit var myViewPagerTabAdapter: ViewPagerTabAdapter


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var tabLayout: TabLayout = binding.tabLayout
        var viewPager2: ViewPager2 = binding.viewpager
        myViewPagerTabAdapter = ViewPagerTabAdapter(this)

        viewPager2.adapter =myViewPagerTabAdapter

        TabLayoutMediator(
            tabLayout,
            viewPager2,
        ) { tab, position ->
            val tabNames = listOf("Ciencia", "Categories", "Wishlist", "Needs")
            tab.text = tabNames[position]
        }.attach()

   /*     ViewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}