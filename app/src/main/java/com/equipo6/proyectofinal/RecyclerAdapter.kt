package com.equipo6.proyectofinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.equipo6.proyectofinal.data.model.Movies

class RecyclerAdapter(var context: Context, private val movies : List<Movies>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.tvTitulo)
        val category = view.findViewById<TextView>(R.id.tvCategoria)
        val classification = view.findViewById<TextView>(R.id.tvClasificacion)
        val imageMovie = view.findViewById<ImageView>(R.id.imgPortada)
        val review = view.findViewById<TextView>(R.id.tvReview)

        fun bind(movie: Movies, context: Context){
            title.text = movie.title
            category.text = movie.category
            classification.text = movie.raiting
            review.text = movie.review
            imageMovie.setImageResource(movie.imageMovie)

            //Gestionando los eventos e interacciones con la vista
            itemView.setOnClickListener{
                Toast.makeText(context, "Acabas de calificar a ${movie.title}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        holder.bind(movie,context)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}