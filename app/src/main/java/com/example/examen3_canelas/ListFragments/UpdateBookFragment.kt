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
import androidx.navigation.fragment.navArgs
import com.example.examen3_canelas.BookViewModel
import com.example.examen3_canelas.DB.Book
import com.example.examen3_canelas.R
import kotlinx.android.synthetic.main.fragment_update_book.*
import kotlinx.android.synthetic.main.fragment_update_book.view.*

class UpdateBookFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mBookViewModel : BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_update_book, container, false)

        mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        view.updateTitle.setText(args.currentBook.title)
        view.updatePageCount.setText(args.currentBook.pageCount)
        view.updateIsbm.setText(args.currentBook.isbn)
        view.updateAuthor.setText(args.currentBook.author)
        view.updateDescription.setText(args.currentBook.description)
        view.updateImageUrl.setText(args.currentBook.imageUrl)
        view.updateDate.setText(args.currentBook.date)


        view.updateBook_btn.setOnClickListener {
            updateItem()
        }

        return  view
    }

    private  fun updateItem() {
        val Title = updateTitle.text.toString()
        val PageCount = updatePageCount.text.toString()
        val Author = updateAuthor.text.toString()
        val Description = updateDescription.text.toString()
        val ImageUrl = updateImageUrl.text.toString()
        var Date = updateDate.text.toString()
        val Isbm = updateIsbm.text.toString()

        val updateBook =
            Book( args.currentBook.id, Title, PageCount, Author, Description, ImageUrl, Date,Isbm)
        mBookViewModel.updateBook(updateBook)
    }
}