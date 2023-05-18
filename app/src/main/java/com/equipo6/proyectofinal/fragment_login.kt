package com.equipo6.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.equipo6.proyectofinal.data.model.LoginUser
import com.google.gson.Gson

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_login.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_login : Fragment() {
    // TODO: Rename and change types of parameters
private lateinit var communicator: Comunicator

    private var userLst = ArrayList<LoginUser>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val register: Button = view.findViewById(R.id.signOn)
        val login: Button = view.findViewById(R.id.login)
        val loading: ProgressBar = view.findViewById(R.id.loading)
        val userName: EditText = view.findViewById(R.id.username)
        val password: EditText = view.findViewById(R.id.password)

       val objectJson = arguments?.getString("userLogin")

        if(objectJson != null)
        {
            val gson = Gson()
            val listUsers = gson.fromJson<ArrayList<LoginUser>>(objectJson, ArrayList::class.java)

            userLst = listUsers
        }


        communicator = activity as Comunicator

        register.setOnClickListener {
            loading.visibility = View.VISIBLE
            communicator.register()

        }

        login.setOnClickListener {
            var existe: Boolean = false;
            for(item in userLst){
                if(userName.text.toString().equals(item.email) && password.text.toString().equals(item.passwd))
                {
                    var existe: Boolean = true;
                    Toast.makeText(getActivity(), "existe", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            if(!existe) {
                Toast.makeText(getActivity(), "Correo no registrado", Toast.LENGTH_SHORT).show();
            }
        }
        // Inflate the layout for this fragment
        return view
    }

}