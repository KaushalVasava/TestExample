package com.lahsuak.apps.testexample.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lahsuak.apps.testexample.model.NetworkResult
import com.lahsuak.apps.testexample.model.News
import com.lahsuak.apps.testexample.model.NewsParentModel
import com.lahsuak.apps.testexample.repo.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NewsViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    private val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: NewsRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_getNews() = runTest {
        Mockito.`when`(repository.getNews()).thenReturn(
            NetworkResult.Success(
                NewsParentModel(
                    "", 0,
                    emptyList()
                )
            )
        )
        val viewModel = NewsViewModel()
        viewModel.getNews()
        val result = viewModel.newsFlow.value
        Assert.assertEquals(0, result.data?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_getNews_expected_error() = runTest {
        Mockito.`when`(repository.getNews()).thenReturn(
            NetworkResult.Error("Something went wrong!")
        )
        val viewModel = NewsViewModel()
        viewModel.getNews()
        val result = viewModel.newsFlow.value
        Assert.assertEquals(true, result is NetworkResult.Error)
        Assert.assertEquals("Something went wrong!", result.message)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}