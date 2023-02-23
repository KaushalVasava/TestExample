package com.lahsuak.apps.testexample.repo

import com.lahsuak.apps.testexample.api.ApiClient
import com.lahsuak.apps.testexample.api.NewsApi
import com.lahsuak.apps.testexample.model.NetworkResult
import com.lahsuak.apps.testexample.model.NewsParentModel

class NewsRepository(private val apiInterface: NewsApi = ApiClient.apiInterface) {
    suspend fun getNews(): NetworkResult<NewsParentModel> {
        val response = apiInterface.getNews()
        return if (response.isSuccessful) {
            val responseData = response.body()
            if (responseData != null) {
                NetworkResult.Success(responseData)
            } else {
                NetworkResult.Error("Something went wrong")
            }
        } else {
            NetworkResult.Error("Something went wrong")
        }
    }
}