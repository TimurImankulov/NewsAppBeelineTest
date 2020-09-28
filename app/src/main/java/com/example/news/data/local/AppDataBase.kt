package com.example.news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.news.data.model.news.ArticleItem
import com.example.news.data.model.news.NewsModel
import com.example.news.data.model.news.SourceModel

@Database(
    entities = [ArticleItem::class, SourceModel::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(value = [TypeConverter::class])
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): NewsDao
}