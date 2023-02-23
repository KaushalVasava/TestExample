package com.lahsuak.apps.testexample

import android.app.Application
import com.lahsuak.apps.testexample.api.NewsApi
import com.lahsuak.apps.testexample.repo.NewsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestApp : Application() {

    lateinit var newsApi: NewsApi
    lateinit var newsRepository: NewsRepository

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl(NewsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsApi = retrofit.create(NewsApi::class.java)
        newsRepository = NewsRepository(newsApi)
    }
}