package com.example.myapplication.fragments

import com.example.myapplication.entities.BookEntity

interface OnItemClickListener {
    fun onItemClicked(bookEntity: BookEntity)
}
