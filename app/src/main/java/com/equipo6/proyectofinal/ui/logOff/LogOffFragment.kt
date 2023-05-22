package com.equipo6.proyectofinal.ui.logOff

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.equipo6.proyectofinal.MainActivity
import com.equipo6.proyectofinal.NavigationActivity
import com.equipo6.proyectofinal.R
import com.equipo6.proyectofinal.fragment_login

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [LogOffFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LogOffFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val appContext = requireContext().applicationContext
        val intent = Intent(appContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
            //.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        //finish()

        return view
    }

}