package com.equipo6.proyectofinal

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.equipo6.proyectofinal.data.model.LoginUser
import java.util.*

class mySqlLiteHelpter(context: Context): SQLiteOpenHelper (
    context, "movies.db", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        var dbCreatedUsers = "CREATE TABLE users" +
                "(id TEXT PRIMARY KEY," +
                "userName TEXT, email TEXT, passwd TEXT)"
        db!!.execSQL(dbCreatedUsers)

        var dbCreatedMovies = "CREATE TABLE movie" +
                "(id TEXT PRIMARY KEY," +
                "title TEXT, category TEXT, anio INTEGER, review TEXT, time TEXT, country TEXT, raiting INTEGER, imageP INTEGER)"
        db!!.execSQL(dbCreatedMovies)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dbDelete = "DROP TABLE IF EXISTS users"

        db!!.execSQL(dbDelete)

        onCreate(db)

        val dbDeleteMovies = "DROP TABLE IF EXISTS movie"

        db!!.execSQL(dbDeleteMovies)

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

    fun addMovies(){
        val datos = ContentValues()
        datos.put("id", UUID.randomUUID().toString())
        datos.put("title", "Guardians of the Galaxy Vol. 3")
        datos.put("category", "Ciencia ficción")
        datos.put("anio", 2023)
        datos.put("review", "Guardianes de la Galaxia vol. 3 es una película de superhéroes estadounidense basada en el equipo de superhéroes Guardianes de la Galaxia, perteneciente a Marvel Comics")
        datos.put("time", "02:29m")
        datos.put("country", "EU")
        datos.put("raiting", "8.1")
        datos.put("imageP", 1)

        val db = this.writableDatabase
        db.insert("movie",null,datos)

        val movie = ContentValues()
        movie.put("id", UUID.randomUUID().toString())
        movie.put("title", "Ant-Man y la Avispa: Quantumanía")
        movie.put("category", "Ciencia ficción")
        movie.put("anio", 2023)
        movie.put("review", "Los superhéroes se encuentran atrapados en el reino cuántico, donde conocen a nuevas y extrañas criaturas y luchan contra un nuevo enemigo: Kang, el Conquistador.")
        movie.put("time", "02:29m")
        movie.put("country", "EU")
        movie.put("raiting", "8.5")
        datos.put("imageP", 2)

        db.insert("movie",null,movie)

        val movie1 = ContentValues()
        movie1.put("id", UUID.randomUUID().toString())
        movie1.put("title", "65: Al borde de la extinción")
        movie1.put("category", "Ciencia ficción")
        movie1.put("anio", 2023)
        movie1.put("review", "Tras sufrir un accidente y caer a un planeta desconocido, los supervivientes de la nave descubren que han llegado a la Tierra, pero hace 65 millones de años. Ahora, deben cruzar un territorio inhóspito, poblado de bestias prehistóricas, para salir.")
        movie1.put("time", "01:30m")
        movie1.put("country", "EU")
        movie1.put("raiting", "6.0")
        movie1.put("imageP", 3)

        db.insert("movie",null,movie1)

        val movie2 = ContentValues()
        movie2.put("id", UUID.randomUUID().toString())
        movie2.put("title", "Jung E")
        movie2.put("category", "Ciencia ficción")
        movie2.put("anio", 2023)
        movie2.put("review", "En un futuro cercano posapocalíptico, una investigadora dirige las iniciativas para poner fin a una guerra civil mediante la clonación del cerebro de una soldado heroica: su madre.")
        movie2.put("time", "01:30m")
        movie2.put("country", "EU")
        movie2.put("raiting", "6.0")
        movie2.put("imageP", 4)

        db.insert("movie",null,movie2)

        val movie3 = ContentValues()
        movie3.put("id", UUID.randomUUID().toString())
        movie3.put("title", "Evil Dead Rise")
        movie3.put("category", "Terror")
        movie3.put("anio", 2023)
        movie3.put("review", "En un edificio de apartamentos de Los Ángeles, dos hermanas luchan contra los demonios sedientos de sangre que han salido de un libro antiguo.")
        movie3.put("time", "01:36m")
        movie3.put("country", "EU")
        movie3.put("raiting", "7.0")
        movie3.put("imageP", 5)

        db.insert("movie",null,movie3)

        val movie4 = ContentValues()
        movie4.put("id", UUID.randomUUID().toString())
        movie4.put("title", "El exorcista del Papa")
        movie4.put("category", "Terror")
        movie4.put("anio", 2023)
        movie4.put("review", "El exorcista líder del Vaticano investiga la posesión de un niño y descubre una conspiración vaticana.")
        movie4.put("time", "01:46m")
        movie4.put("country", "EU")
        movie4.put("raiting", "9.0")
        movie4.put("imageP", 6)

        db.insert("movie",null,movie4)

        val movie5 = ContentValues()
        movie5.put("id", UUID.randomUUID().toString())
        movie5.put("title", "Consecration")
        movie5.put("category", "Terror")
        movie5.put("anio", 2023)
        movie5.put("review", "Consecration es una película de suspenso y terror sobrenatural de 2023 dirigida por Cristopher Smith a partir de un guión que coescribió con Laurie Cook y protagonizada por Jena Malone, Danny Huston y Janet Suzman. ")
        movie5.put("time", "01:30m")
        movie5.put("country", "EU")
        movie5.put("raiting", "4.0")
        movie5.put("imageP", 7)

        db.insert("movie",null,movie5)
        db.close()
    }
}