package com.lahsuak.apps.testexample.api

import com.lahsuak.apps.testexample.utils.Helper
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var newsApi: NewsApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        newsApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }

    @Test
    fun testGetNews_ReturnEmptyResponse() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setBody("{}")
        mockWebServer.enqueue(mockResponse)

        val response = newsApi.getNews()
        mockWebServer.takeRequest()
        Assert.assertEquals(null, response.body()!!.articles)
    }

    @Test
    fun testGetNews_returnNews() = runBlocking {
        val mockResponse = MockResponse()
        val content = Helper.readFileResource("/test.json")
        mockResponse.setResponseCode(200)
        mockResponse.setBody(content)
        mockWebServer.enqueue(mockResponse)

        val response = newsApi.getNews()
        mockWebServer.takeRequest()
        Assert.assertEquals(true, response.body()!!.articles.isNotEmpty())
        Assert.assertEquals(2, response.body()!!.articles.size)
    }

    @Test
    fun testGetNews_returnError() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(404)
        mockResponse.setBody("Something went wrong!")
        mockWebServer.enqueue(mockResponse)

        val response = newsApi.getNews()
        mockWebServer.takeRequest()
        Assert.assertEquals(false, response.isSuccessful)
        Assert.assertEquals(404, response.code())
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
