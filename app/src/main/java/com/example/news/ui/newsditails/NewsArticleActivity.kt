package com.example.news.ui.newsditails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news.R
import com.example.news.data.model.news.ArticleItem
import com.example.news.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_news_article.*

class NewsArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_article)
        val data = intent.getParcelableExtra<ArticleItem>(MainActivity.ARTICLE)
        fillViews(data)
    }

    private fun fillViews(data: ArticleItem?) {

        tvTitle.text = data?.title
        tvDesc.text = data?.description
        tvContent.text = data?.content
        tvAuthor.text = data?.author
        tvSource.text = data?.source?.name
        tvURL.text = data?.url
        tvURLTolmage.text = data?.urlToImage
        tvPublishedAt.text = data?.publishedAt
    }
}