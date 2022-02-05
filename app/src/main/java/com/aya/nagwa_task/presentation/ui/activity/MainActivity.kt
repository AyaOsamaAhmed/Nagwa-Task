package com.aya.nagwa_task.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aya.nagwa_task.R
import com.aya.nagwa_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var  binging : ActivityMainBinding

   // @Inject lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binging = DataBindingUtil.setContentView(this, R.layout.activity_main)



    }
}