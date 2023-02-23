package com.lahsuak.apps.testexample.api

import com.lahsuak.apps.testexample.model.NewsParentModel
import retrofit2.Response
import retrofit2.http.GET


interface NewsApi {
    companion object {
        const val BASE_URL = "https://saurav.tech"
    }

    @GET("/NewsAPI/top-headlines/category/general/in.json")
    suspend fun getNews(): Response<NewsParentModel>
}