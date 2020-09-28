package com.example.news.data.model.news

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class SourceModel(
    @PrimaryKey(autoGenerate = true)
    val primaryId: Int,
    val id: String?,
    val name: String?
) : Parcelable