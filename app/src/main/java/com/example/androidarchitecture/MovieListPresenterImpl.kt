package com.example.androidarchitecture

import android.os.Handler
import java.util.Calendar

class MovieListPresenterImpl(private val movieListView: MovieListView) : MovieListPresenter {
    private val movieList = listOf(
        Movie("Fight Clube", 1, Calendar.getInstance().time),
        Movie("Paprika", 2, Calendar.getInstance().time),
        Movie("Chungking Express", 3, Calendar.getInstance().time),
        Movie("Mononoke Princess", 4, Calendar.getInstance().time),
        Movie("Batman: The Dark Knight", 5, Calendar.getInstance().time)
    )

    init {
        movieListView.displayLoading()

        Handler().postDelayed(
            {
                getMovieList()
            },
            2000
        )
    }

    // Because there's no error here, I'll not call
    // any of error methods
    override fun getMovieList() {
        movieListView.displayMovieList(movieList)
        movieListView.dismissLoading()
    }
}