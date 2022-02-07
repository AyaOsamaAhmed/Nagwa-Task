package com.aya.nagwa_task.data.dataSource.remote

import com.aya.nagwa_task.domian.model.MovieResponse
import dagger.Component
import io.reactivex.Flowable
import retrofit2.http.GET

interface Api {

    @GET("/movies")
     fun getMovie (): Flowable<MovieResponse>

}