package com.example.news.data.model.news

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class ArticleItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String?,
    var page: Int = 0,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
    val source: SourceModel?
) : Parcelable
