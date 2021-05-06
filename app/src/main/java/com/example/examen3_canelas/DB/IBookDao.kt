package com.example.examen3_canelas.DB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IBookDao {

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun addBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Query( "SELECT * FROM book_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Book>>
}