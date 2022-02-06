package com.aya.nagwa_task.di.components

import com.aya.nagwa_task.di.modules.ApiClient
import com.aya.nagwa_task.presentation.ui.viewModel.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiClient::class] )
interface controllerComponent {

    fun injectActivity(viewModel: MainActivityViewModel)
}