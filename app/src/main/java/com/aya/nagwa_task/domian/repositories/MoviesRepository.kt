package com.aya.nagwa_task.domian.repositories

import com.aya.nagwa_task.domian.model.Movie
import io.reactivex.rxjava3.core.Observable


interface MoviesRepository {

    fun requestAllMovies(): Observable<List<Movie>>

}