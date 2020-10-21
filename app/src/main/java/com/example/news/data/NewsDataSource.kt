package com.example.news.data


import androidx.paging.PageKeyedDataSource
import com.example.news.BuildConfig.API_KEY_NEWS
import com.example.news.NewsApp
import com.example.news.data.model.news.ArticleItem
import com.example.news.data.remote.RetrofitBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewsDataSource : PageKeyedDataSource<Int, ArticleItem>() {

    //private val scope = CoroutineScope(Job())

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ArticleItem>
    ) {
        GlobalScope.launch {
            runCatching {
                val result = RetrofitBuilder.getService()?.getNews(
                    "us", "business", 1, 10)

                result?.articles?.map { it.page = 1 }
                result?.articles?.let { NewsApp.getApp()?.getDb()?.getDao()?.add(it) }
                val data = NewsApp.getApp()?.getDb()?.getDao()?.getAll(1)
                data?.let { callback.onResult(it, 1, 2) }
            }.onFailure {
                val data = NewsApp.getApp()?.getDb()?.getDao()?.getAll(1)
                data?.let { callback.onResult(it, 1, 2) }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleItem>) {
        GlobalScope.launch {
            runCatching {
                val result = RetrofitBuilder.getService()?.getNews(
                    "us", "business", params.key, 10)

                result?.articles?.map { it.page = params.key }
                result?.articles?.let { NewsApp.getApp()?.getDb()?.getDao()?.add(it) }
                val data = NewsApp.getApp()?.getDb()?.getDao()?.getAll(params.key)
                data?.let { callback.onResult(it, params.key + 1) }
            }.onFailure {
                val data = NewsApp.getApp()?.getDb()?.getDao()?.getAll(params.key)
                data?.let { callback.onResult(it, params.key + 1) }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleItem>) {}
}