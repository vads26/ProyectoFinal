package com.equipo6.proyectofinal.ui.gallery

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.equipo6.proyectofinal.R
import com.equipo6.proyectofinal.RecyclerAdapter
import com.equipo6.proyectofinal.data.model.Movies
import com.equipo6.proyectofinal.databinding.FragmentGalleryBinding
import com.equipo6.proyectofinal.mySqlLiteHelpter

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    lateinit var usersDBHelper: mySqlLiteHelpter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

              val appContext = requireContext().applicationContext
              val recycler : RecyclerView = binding.recycler

              usersDBHelper = mySqlLiteHelpter(appContext)

              val db: SQLiteDatabase = usersDBHelper.readableDatabase
              var sqlQuerys = "SELECT * FROM movie"
              var selectDb = db.rawQuery(sqlQuerys, null)
              val lstmovies = ArrayList<Movies>()

              if(selectDb.moveToFirst()) {
                 do{
                     var idImage = selectDb.getInt(8)

                     when(idImage)
                     {
                         1 -> {
                             var movie = Movies(selectDb.getString(0),selectDb.getString(1),selectDb.getString(2), selectDb.getInt(3),selectDb.getString(4),selectDb.getString(5),selectDb.getString(6),selectDb.getString(7), R.drawable.guardians)

                             lstmovies.add(movie)
                         }
                         2 ->{
                             var movie = Movies(selectDb.getString(0),selectDb.getString(1),selectDb.getString(2), selectDb.getInt(3),selectDb.getString(4),selectDb.getString(5),selectDb.getString(6),selectDb.getString(7), R.drawable.antman)

                             lstmovies.add(movie)
                         }
                         3 ->{
                             var movie = Movies(selectDb.getString(0),selectDb.getString(1),selectDb.getString(2), selectDb.getInt(3),selectDb.getString(4),selectDb.getString(5),selectDb.getString(6),selectDb.getString(7), R.drawable.extincion)

                             lstmovies.add(movie)
                         }
                         4 ->{
                             var movie = Movies(selectDb.getString(0),selectDb.getString(1),selectDb.getString(2), selectDb.getInt(3),selectDb.getString(4),selectDb.getString(5),selectDb.getString(6),selectDb.getString(7), R.drawable.jung)

                             lstmovies.add(movie)
                         }
                         5 ->{
                             var movie = Movies(selectDb.getString(0),selectDb.getString(1),selectDb.getString(2), selectDb.getInt(3),selectDb.getString(4),selectDb.getString(5),selectDb.getString(6),selectDb.getString(7), R.drawable.evildead)

                             lstmovies.add(movie)
                         }
                         6 ->{
                             var movie = Movies(selectDb.getString(0),selectDb.getString(1),selectDb.getString(2), selectDb.getInt(3),selectDb.getString(4),selectDb.getString(5),selectDb.getString(6),selectDb.getString(7), R.drawable.exorcista)

                             lstmovies.add(movie)
                         }
                         7 ->{
                             var movie = Movies(selectDb.getString(0),selectDb.getString(1),selectDb.getString(2), selectDb.getInt(3),selectDb.getString(4),selectDb.getString(5),selectDb.getString(6),selectDb.getString(7), R.drawable.consecration)

                             lstmovies.add(movie)
                         }
                     }

                  }while(selectDb.moveToNext())

                  val adapter = RecyclerAdapter(appContext,lstmovies)
                  // this creates a vertical layout Manager
                  recycler.layoutManager = LinearLayoutManager(appContext)

                  recycler.adapter = adapter
              }

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}