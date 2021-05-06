package com.example.examen3_canelas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.examen3_canelas.DB.Book
import com.example.examen3_canelas.DB.BookDB
import com.example.examen3_canelas.DB.BookRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Book>>
    private val repository: BookRepo
    init{
        val bookDao= BookDB.getDatabase(
            application
        ).bookDao()
        repository = BookRepo(bookDao)
        readAllData = repository.readAllData
    }

    fun addBook (book: Book){
        viewModelScope.launch(Dispatchers.IO){
            repository.addBook(book)
        }
    }

    fun updateBook (book: Book){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateBook(book)
        }
    }
}