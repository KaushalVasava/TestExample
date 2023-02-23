package com.lahsuak.apps.testexample.model

data class NewsParentModel(
    val status: String,
    val totalResults: Int,
    val articles: List<News>
)