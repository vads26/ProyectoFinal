package com.equipo6.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.Theme_ProyectoFinal)
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val register: Button = findViewById(R.id.signOn)
        val loading: ProgressBar = findViewById(R.id.loading)

        register.setOnClickListener {
            //loading.visibility = View.VISIBLE
            Toast.makeText(this@LoginActivity, "Hola", Toast.LENGTH_LONG).show()

            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}