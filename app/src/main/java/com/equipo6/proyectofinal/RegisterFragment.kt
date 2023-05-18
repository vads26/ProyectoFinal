package com.equipo6.proyectofinal

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.equipo6.proyectofinal.data.model.LoginUser
import com.google.gson.Gson;
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var communicator: Comunicator
    val loginUsers = arrayListOf<LoginUser>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val cancel: Button = view.findViewById(R.id.btn_cancelar)
        val register: Button = view.findViewById(R.id.btn_register)
        val userName: EditText = view.findViewById(R.id.et_name)
        val email: EditText = view.findViewById(R.id.et_email)
        val passwd: EditText = view.findViewById(R.id.et_password)
        val rePasswd: EditText = view.findViewById(R.id.et_repassword)

        communicator = activity as Comunicator

        register.setOnClickListener {
            if(TextUtils.isEmpty(userName.text.toString()))
            {
                Toast.makeText(getActivity(), "Nombre obligatorio", Toast.LENGTH_SHORT).show();
            }else{
                if(TextUtils.isEmpty(email.text.toString()))
                {
                    Toast.makeText(getActivity(), "Correo electrónico obligatorio", Toast.LENGTH_SHORT).show();
                }else{
                    if(TextUtils.isEmpty(passwd.text.toString()))
                    {
                        Toast.makeText(getActivity(), "Contraseña obligatorio", Toast.LENGTH_SHORT).show();
                    }else{
                        if(TextUtils.isEmpty(rePasswd.text.toString()))
                        {
                            Toast.makeText(getActivity(), "Confirmar la contraseña es obligatorio", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            if(passwd.text.toString().equals(rePasswd.text.toString()))
                            {
                                var existe: Boolean = false;
                                for(item in loginUsers){
                                    if(email.text.toString().equals(item.email))
                                    {
                                        existe = true;
                                        Toast.makeText(getActivity(), "Correo ya registrado anteriormente, intenta con otro", Toast.LENGTH_SHORT).show();
                                        break;
                                    }
                                }

                                if(!existe) {

                                    var user = LoginUser()
                                    user.UserName = userName.text.toString()
                                    user.email = email.text.toString()
                                    user.passwd = passwd.text.toString()
                                    user.id = UUID.randomUUID().toString()

                                    loginUsers.add(user)

                                    Toast.makeText(
                                        getActivity(),
                                        "Registro exitoso!",
                                        Toast.LENGTH_SHORT
                                    ).show();

                                    val gson = Gson();
                                    val lstJson = gson.toJson(loginUsers);

                                    communicator.signUp(lstJson)
                                }
                            }else
                            {
                                Toast.makeText(getActivity(), "La contraseña no es la misma", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        }

        cancel.setOnClickListener {
            communicator.logIn()

        }
        // Inflate the layout for this fragment
        return view
    }

}