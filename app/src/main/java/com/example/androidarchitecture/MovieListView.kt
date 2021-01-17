package com.example.androidarchitecture

interface MovieListView {
    fun displayMovieList(movieList: List<Movie>)
    fun displayLoading()
    fun dismissLoading()
    fun displayError()
    fun dismissError()
}