package com.example.androidarchitecture

interface MoviesView {
    fun displayMovieList(movieList: List<Movie>)
    fun displayLoading()
    fun dismissLoading()
    fun displayError()
    fun dismissError()
}