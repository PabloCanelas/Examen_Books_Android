package com.example.examen3_canelas.ListFragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.examen3_canelas.BookViewModel
import com.example.examen3_canelas.DB.Book
import com.example.examen3_canelas.R
import kotlinx.android.synthetic.main.fragment_add_book.*
import kotlinx.android.synthetic.main.fragment_add_book.view.*

class AddBookFragment : Fragment() {

    private lateinit var mBookViewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_book, container, false)

        mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        view.addBook_btn.setOnClickListener{
            insertDataToDataBase()
        }
        return  view
    }

    private fun insertDataToDataBase() {
        val Title = addTitle.text.toString()
        val PageCount = addPageCount.text.toString()
        val Author = addAuthor.text.toString()
        val Description = addDescription.text.toString()
        val ImageUrl = addImageUrl.text.toString()
        var Date = addDate.text.toString()
        val Isbm = addIsbm.text.toString()

            val book = Book(
                id = 0,
                title = Title,
                pageCount = PageCount,
                author = Author,
                description = Description,
                imageUrl = ImageUrl,
                date = Date,
                isbn = Isbm
            )
            // Add Data
            mBookViewModel.addBook(book)

    }



}