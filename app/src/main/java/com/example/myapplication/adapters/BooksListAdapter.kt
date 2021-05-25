package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.entities.BookEntity
import com.example.myapplication.fragments.OnItemClickListener
import com.squareup.picasso.Picasso
import kotlin.properties.Delegates
import kotlinx.android.synthetic.main.book_layout.view.*

class BooksListAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<BooksListAdapter.BookViewHolder>(), AutoUpdatableAdapter {


    var data: List<BookEntity> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.id == n.id }
    }

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
        private val name = itemView.findViewById<TextView>(R.id.book_item_name)
        private val image = itemView.findViewById<ImageView>(R.id.book_item_image)
        private val writer = itemView.findViewById<TextView>(R.id.book_item_writer)

        fun bind(bookEntity: BookEntity, onItemClickListener: OnItemClickListener) {
            Picasso.get().load(bookEntity.image?.toUri()).into(image)
            name.text = bookEntity.name
            writer.text = bookEntity.writer
            itemView.setOnClickListener {
                onItemClickListener.onItemClicked(bookEntity)
            }
        }

    }
}