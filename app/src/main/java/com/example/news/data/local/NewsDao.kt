package com.example.news.data.local

import androidx.room.*
import com.example.news.data.model.news.ArticleItem

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(data: List<ArticleItem>)

    @Query("SELECT * FROM ArticleItem WHERE page = :page")
    fun getAll(page: Int): List<ArticleItem>
}