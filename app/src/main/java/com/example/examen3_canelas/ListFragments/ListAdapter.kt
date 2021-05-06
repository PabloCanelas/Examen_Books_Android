package com.example.examen3_canelas.ListFragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.examen3_canelas.DB.Book
import com.example.examen3_canelas.ListFragmentDirections
import com.example.examen3_canelas.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var bookList = emptyList<Book>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book_row, parent, false))
    }

    override fun getItemCount(): Int {
        return  bookList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val picasso = Picasso.get()
        val currentItem =  bookList[position]
        holder.itemView.author_view.text = currentItem.author
        holder.itemView.title_view.text = currentItem.title
        holder.itemView.isbn_view.text = currentItem.isbn
        holder.itemView.date_view.text = currentItem.date
        holder.itemView.pageCount_view.text = currentItem.pageCount
        holder.itemView.description_view.text = currentItem.description
        picasso.load(currentItem.imageUrl)
            .into(holder.itemView.my_image_view)

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    fun setData (books : List <Book>){
        this.bookList = books
        notifyDataSetChanged()
    }



}