package com.example.androidarchitecture

import android.os.Handler
import java.util.Calendar

class MoviesPresenter(private val moviesView: MoviesView) {
    private val movieList = listOf(
        Movie("Fight Clube", 1, Calendar.getInstance().time),
        Movie("Paprika", 2, Calendar.getInstance().time),
        Movie("Chungking Express", 3, Calendar.getInstance().time),
        Movie("Mononoke Princess", 4, Calendar.getInstance().time),
        Movie("Batman: The Dark Knight", 5, Calendar.getInstance().time)
    )

    init {
        moviesView.displayLoading()

        Handler().postDelayed(
            {
                getMovieList()
            },
            2000
        )
    }

    // Because there's no error here, I'll not call
    // any of error methods
    private fun getMovieList() {
        moviesView.displayMovieList(movieList)
        moviesView.dismissLoading()
    }
}