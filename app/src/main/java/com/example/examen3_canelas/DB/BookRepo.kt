package com.example.examen3_canelas.DB

import androidx.lifecycle.LiveData

class BookRepo (private val bookDao: IBookDao) {

    val readAllData: LiveData<List<Book>> = bookDao.readAllData()

    suspend fun  addBook  (book: Book){
        bookDao.addBook(book)
    }

    suspend fun updateBook(book: Book){
        bookDao.updateBook(book)
    }
}