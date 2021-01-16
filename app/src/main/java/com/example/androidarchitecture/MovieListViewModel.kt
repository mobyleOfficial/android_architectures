package com.example.androidarchitecture

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Calendar

class MovieListViewModel : ViewModel() {
    private val movieList = listOf(
        Movie("Fight Clube", 1, Calendar.getInstance().time),
        Movie("Paprika", 2, Calendar.getInstance().time),
        Movie("Chungking Express", 3, Calendar.getInstance().time),
        Movie("Mononoke Princess", 4, Calendar.getInstance().time),
        Movie("Batman: The Dark Knight", 5, Calendar.getInstance().time)
    )

    private val stateEventLiveDate = MutableLiveData<StateEvent>()
    fun getStateEventLiveDate(): LiveData<StateEvent> = stateEventLiveDate

    private val moviesLiveData = MutableLiveData<List<Movie>>()
    fun getMoviesLiveData(): LiveData<List<Movie>> = moviesLiveData

    init {
        stateEventLiveDate.postValue(StateEvent.LOADING)
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
        moviesLiveData.postValue(movieList)
        stateEventLiveDate.postValue(StateEvent.SUCCESS)
    }

}