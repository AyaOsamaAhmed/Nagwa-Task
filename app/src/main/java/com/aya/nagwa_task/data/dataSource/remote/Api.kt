package com.aya.nagwa_task.data.dataSource.remote

import com.aya.nagwa_task.domian.model.MovieResponse
import dagger.Component
import retrofit2.http.GET

// The "modules" attribute in the @Component annotation tells Dagger what Modules
// to include when building the graph
@Component(modules = [ApiClient::class])
interface Api {

    @GET("/movies")
    suspend fun getMovie (): MovieResponse

}