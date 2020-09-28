package com.example.news.data.model.news

data class NewsModel(
    val id: Int,
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleItem>
)

