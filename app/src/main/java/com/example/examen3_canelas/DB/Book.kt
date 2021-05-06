package com.example.examen3_canelas.DB
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity  (tableName="book_table")
data class Book (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val pageCount: String,
    val  isbn: String,
    val author: String,
    val description: String,
    val imageUrl:String,
    val date:String
) : Parcelable