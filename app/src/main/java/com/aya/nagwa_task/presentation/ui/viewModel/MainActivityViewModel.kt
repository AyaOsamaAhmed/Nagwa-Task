package com.aya.nagwa_task.presentation.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aya.nagwa_task.data.dataSource.remote.Api
import com.aya.nagwa_task.di.modules.ApiClient
import com.aya.nagwa_task.domian.model.Movie
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel () : ViewModel() {

    var apiClient: Api = ApiClient.api
    var listMovies : MutableLiveData<ArrayList<Movie>>  = MutableLiveData ()

    init {

        apiClient.getMovie()
            .toObservable()
            .subscribeOn(Schedulers.io())
           // .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                listMovies.value = it.data
            }
    }


    fun getListMovie(): MutableLiveData<ArrayList<Movie>> {
        return  listMovies
    }

}