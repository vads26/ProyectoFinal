package com.equipo6.proyectofinal

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.equipo6.proyectofinal.databinding.ActivityNavigationBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class NavigationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationBinding
    lateinit var usersDBHelper: mySqlLiteHelpter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var userId: String? = ""
        var email: String? = ""

        val parametros = this.intent.extras
        if (parametros != null) {
            userId = parametros.getString("userId")
            email = parametros.getString("email")
        }

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNavigation.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        val headView: View = navigationView.getHeaderView(0)
        val headerEmail: TextView = headView.findViewById(R.id.txtEmail)

        headerEmail.text = email

        dataMovie()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_logOff, R.id.nav_about
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun dataMovie(){
        usersDBHelper = mySqlLiteHelpter(this)
        val db: SQLiteDatabase = usersDBHelper.readableDatabase
        var sqlQuerys = "SELECT * FROM movie"
        var selectDb = db.rawQuery(sqlQuerys, null)

        if(!selectDb.moveToFirst()) {
            usersDBHelper.addMovies()
        }
    }
}