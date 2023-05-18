package com.equipo6.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.equipo6.proyectofinal.data.model.LoginUser

class MainActivity : AppCompatActivity(),Comunicator {

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.Theme_ProyectoFinal)
        getSupportActionBar()?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment_login()).commit()
    }

    override fun register() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, RegisterFragment()).commit()
    }

    override fun logIn() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment_login()).commit()
    }

    override fun signUp(loginUsers: String) {
        val bundle = Bundle()
        bundle.putString("userLogin", loginUsers)
        val fragmentManager = supportFragmentManager.beginTransaction()
        val fragmentLogIn = fragment_login()
        fragmentLogIn.arguments = bundle

        fragmentManager.replace(R.id.fragment_container, fragmentLogIn).commit()
    }
}