package com.equipo6.proyectofinal

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.equipo6.proyectofinal.data.model.LoginUser

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_login.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_login : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var usersDBHelper: mySqlLiteHelpter

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

        communicator = activity as Comunicator

        register.setOnClickListener {
            loading.visibility = View.VISIBLE
            communicator.register()

        }

        val appContext = requireContext().applicationContext

        usersDBHelper = mySqlLiteHelpter(appContext)

        login.setOnClickListener {

            if(TextUtils.isEmpty(userName.text.toString()))
            {
                userName.requestFocus()
                Toast.makeText(getActivity(), "Correo electrónico obligatorio", Toast.LENGTH_SHORT).show();
            }else{
                if(TextUtils.isEmpty(password.text.toString()))
                {
                    password.requestFocus()
                    Toast.makeText(getActivity(), "Contraseña es obligatorio", Toast.LENGTH_SHORT).show();
                }else
                {
                    loading.visibility = View.VISIBLE
                    val db: SQLiteDatabase = usersDBHelper.readableDatabase
                    var sqlQuerys = "SELECT * FROM users WHERE email = '" + userName.text + "' AND passwd = '" + password.text + "'"
                    var selectDb = db.rawQuery(sqlQuerys, null)

                    if(!selectDb.moveToFirst()) {
                        loading.visibility = View.INVISIBLE
                        Toast.makeText(getActivity(), "Correo no registrado", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        var userId = ""
                        var email = ""
                        do{
                            userId= selectDb.getString(0).toString()
                            email= selectDb.getString(2).toString()
                        }while(selectDb.moveToNext())

                        val parametros = Bundle()
                        parametros.putString("userId", userId)
                        parametros.putString("email", email)

                        val intent = Intent(appContext, NavigationActivity::class.java)
                        intent.putExtras(parametros)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    }
                }
            }
        }
        // Inflate the layout for this fragment
        return view
    }

}