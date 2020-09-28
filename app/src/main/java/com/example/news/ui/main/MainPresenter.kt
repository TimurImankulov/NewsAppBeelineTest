package com.example.news.ui.main

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.news.data.NewsDataSource
import com.example.news.data.model.news.ArticleItem


class MainPresenter : MainContract.Presenter {

    private var view: MainContract.View? = null

    var postsLiveData: LiveData<PagedList<ArticleItem>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()
        postsLiveData = initializedPagedListBuilder(config).build()
    }

    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<Int, ArticleItem> {

        val dataSourceFactory = object : DataSource.Factory<Int, ArticleItem>() {
            override fun create(): DataSource<Int, ArticleItem> {
                return NewsDataSource()
            }
        }

        return LivePagedListBuilder(dataSourceFactory, config)
    }

    override fun reset() {
        postsLiveData.value?.dataSource?.invalidate()
    }

    override fun bind(view: MainContract.View) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }
}