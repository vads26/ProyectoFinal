package com.equipo6.proyectofinal

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.equipo6.proyectofinal.data.model.LoginUser

class mySqlLiteHelpter(context: Context): SQLiteOpenHelper (
    context, "movies.db", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        var dbCreated = "CREATE TABLE users" +
                "(id TEXT PRIMARY KEY," +
                "userName TEXT, email TEXT, passwd TEXT)"
        db!!.execSQL(dbCreated)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dbDelete = "DROP TABLE IF EXISTS users"

        db!!.execSQL(dbDelete)

        onCreate(db)
    }

    fun addUsers(user: LoginUser){
        val datos = ContentValues()
        datos.put("id", user.id)
        datos.put("userName", user.UserName)
        datos.put("email", user.email)
        datos.put("passwd", user.passwd)

        val db = this.writableDatabase
        db.insert("users",null,datos)
        db.close()
    }
}