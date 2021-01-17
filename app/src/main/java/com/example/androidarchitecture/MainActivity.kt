package com.example.androidarchitecture

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MovieListView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MovieListPresenter
    private var adapter: MovieListAdapter = MovieListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.movieListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.movieListRecyclerView.adapter = adapter

        presenter = MovieListPresenterImpl(this)
    }

    override fun displayMovieList(movieList: List<Movie>) {
        with(binding) {
            loading.visibility = View.GONE
            emptyState.visibility = View.GONE
            movieListRecyclerView.visibility = View.VISIBLE
        }
        adapter.setData(movieList)
    }

    override fun displayLoading() {
        with(binding) {
            loading.visibility = View.VISIBLE
            emptyState.visibility = View.GONE
            movieListRecyclerView.visibility = View.GONE
        }
    }

    override fun dismissLoading() {
        binding.loading.visibility = View.GONE
    }

    override fun displayError() {
        with(binding) {
            loading.visibility = View.GONE
            emptyState.visibility = View.VISIBLE
            movieListRecyclerView.visibility = View.GONE
        }
    }

    override fun dismissError() {
        binding.emptyState.visibility = View.GONE
    }
}