package com.example.myapplication.domain

import com.example.myapplication.BookEntity
import com.example.myapplication.data.BookDataSource

object BookDataRepository {
    fun getAllBooks(): List<BookEntity> {
        return BookDataSource.getAllBooks()
    }

    fun getBook(id: Int): BookEntity {
        return BookDataSource.getBook(id)
    }
}