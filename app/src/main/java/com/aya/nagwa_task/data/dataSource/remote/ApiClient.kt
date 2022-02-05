package com.aya.nagwa_task.data.dataSource.remote

import com.aya.nagwa_task.presentation.utils.Constant.BASE_URL_API
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// @Module informs Dagger that this class is a Dagger Module
@Module
object ApiClient {

    // @Provides tell Dagger how to create instances of the type that this function
    @Provides
    private fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gSon()))
            .client(okHttpClient())
            .baseUrl(BASE_URL_API)
            .build()
    }

    private fun okHttpClient(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val cashSize: Long = (5 * 1024 * 1024).toLong()
     //   val cache = Cache(application.cacheDir, cashSize)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
         //   .cache(cache)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headersInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }
    private fun headersInterceptor() = Interceptor { chain ->
        chain.proceed(
            chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json,*/*")
                .build()
        )
    }
    private fun gSon (): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    val api: Api by lazy {
        retrofitService().create(Api::class.java)
    }


    val retrofit: Retrofit by lazy {
        retrofitService()
    }

}