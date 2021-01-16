package com.example.androidarchitecture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitecture.databinding.MovieListItemBinding

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private var movieList: List<Movie> = emptyList()

    fun setData(movieList: List<Movie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) = holder.bind(movieList[position])

    override fun getItemCount(): Int = movieList.size

    inner class ViewHolder (private val binding: MovieListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
        }
    }
}