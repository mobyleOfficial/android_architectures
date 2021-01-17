package com.example.androidarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieListViewModel
    private var adapter: MovieListAdapter = MovieListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.movieListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.movieListRecyclerView.adapter = adapter

        observeLiveData()
    }

    // Observe all live datas
    private fun observeLiveData() {
        with(viewModel) {
            getStateEventLiveDate().observe(this@MainActivity, { viewStatus ->
                with(binding) {
                    when(viewStatus) {
                        StateEvent.LOADING -> {
                            loading.visibility = View.VISIBLE
                            emptyState.visibility = View.GONE
                            movieListRecyclerView.visibility = View.GONE
                        }
                        StateEvent.ERROR -> {
                            loading.visibility = View.GONE
                            emptyState.visibility = View.VISIBLE
                            movieListRecyclerView.visibility = View.GONE
                        }
                        else -> {
                            loading.visibility = View.GONE
                            emptyState.visibility = View.GONE
                            movieListRecyclerView.visibility = View.VISIBLE
                        }
                    }
                }
            })

            getMoviesLiveData().observe(this@MainActivity, {
                binding.loading.visibility = View.GONE
                adapter.setData(it)
            })
        }
    }
}