package com.aya.nagwa_task.presentation.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aya.nagwa_task.domian.model.Movie
import com.aya.nagwa_task.domian.model.MovieResponse

class MainActivityViewModel ( movieResponse: MovieResponse) : ViewModel() {

    var movieResponse: MovieResponse = movieResponse
    var listMovies : MutableLiveData<Movie>  = MutableLiveData ()

    init {
        fetchListMovie()
    }
    fun fetchListMovie(){

    }

    @JvmName("getListMovies1")
    fun getListMovies(): MutableLiveData<Movie> {
        return  listMovies
    }

}