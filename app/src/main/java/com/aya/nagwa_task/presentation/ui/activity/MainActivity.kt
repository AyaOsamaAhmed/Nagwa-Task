package com.aya.nagwa_task.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aya.nagwa_task.R
import com.aya.nagwa_task.databinding.ActivityMainBinding
import com.aya.nagwa_task.presentation.ui.adapter.AdapterMovies
import com.aya.nagwa_task.presentation.ui.viewModel.MainActivityViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    private lateinit var  binging : ActivityMainBinding
    private lateinit var adapter: AdapterMovies
    //@Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binging = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(
                application
            )
        )[MainActivityViewModel::class.java]
        //ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getListMovie().observe(this , Observer {

            adapter = AdapterMovies(it)
            binging.recyler.adapter = adapter

        })


    }
}