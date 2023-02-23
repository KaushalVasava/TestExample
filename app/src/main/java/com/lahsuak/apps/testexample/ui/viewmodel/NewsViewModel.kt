package com.lahsuak.apps.testexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lahsuak.apps.testexample.model.NetworkResult
import com.lahsuak.apps.testexample.model.News
import com.lahsuak.apps.testexample.repo.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val _newsFlow: MutableStateFlow<NetworkResult<List<News>>> =
        MutableStateFlow(NetworkResult.Success(emptyList()))
    val newsFlow: StateFlow<NetworkResult<List<News>>>
        get() = _newsFlow

    private val newsRepo: NewsRepository by lazy {
        NewsRepository()
    }

    fun getNews() {
        viewModelScope.launch {
            val newsParentModel = newsRepo.getNews()
            _newsFlow.value = NetworkResult.Success(newsParentModel.data?.articles ?: emptyList())
        }
    }
}
