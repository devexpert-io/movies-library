package com.devexperto.damproject.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.damproject.R
import com.devexperto.damproject.databinding.ViewMovieBinding
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.ui.inflate
import com.devexperto.damproject.ui.loadUrl

class MoviesAdapter(var movies: List<Movie> = emptyList(), private val listener: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_movie, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { listener(movie) }
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewMovieBinding.bind(view)
        fun bind(movie: Movie) {
            binding.title.text = movie.title
            binding.thumb.loadUrl(movie.url)
        }
    }
}