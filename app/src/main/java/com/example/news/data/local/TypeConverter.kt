package com.example.news.data.local

import android.text.TextUtils
import androidx.room.TypeConverter
import com.example.news.data.model.news.ArticleItem
import com.example.news.data.model.news.NewsModel
import com.example.news.data.model.news.SourceModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object TypeConverter {

    @JvmStatic
    @TypeConverter
    fun newsModelToString(model: NewsModel): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun newsModelToObject(text: String): NewsModel? {
        if (TextUtils.isEmpty(text))
            return null
        return Gson().fromJson(text, NewsModel::class.java)
    }

    @JvmStatic
    @TypeConverter
    fun articleItemToString(model: List<ArticleItem>): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun articleItemToObject(text: String?): List<ArticleItem>? {
        if (text == null) return mutableListOf()
        val typeToken = object : TypeToken<List<ArticleItem>>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun sourceModelToString(model: SourceModel): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun sourceModelToObject(text: String): SourceModel? {
        if (TextUtils.isEmpty(text))
            return null
        return Gson().fromJson(text, SourceModel::class.java)
    }
}