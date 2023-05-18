package com.equipo6.proyectofinal

import com.equipo6.proyectofinal.data.model.LoginUser

interface Comunicator {
    fun register()
    fun logIn()
    fun signUp(loginUsers: String)
}