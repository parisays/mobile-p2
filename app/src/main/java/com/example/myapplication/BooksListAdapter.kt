package com.example.myapplication.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.BookEntity
import com.example.myapplication.OnItemClickListener

class BooksListAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<BooksListAdapter.BookViewHolder>() {

    var data = listOf<BookEntity>()

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.book_layout, parent, false)

        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(data[position], onItemClickListener)
    }

    fun reload(books: List<BookEntity>) {
        data = books
        notifyDataSetChanged()
    }

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(bookEntity: BookEntity, onItemClickListener: OnItemClickListener) {
            // TODO: update view
            itemView.setOnClickListener {
                onItemClickListener.onItemClicked(bookEntity)
            }
        }
    }
}