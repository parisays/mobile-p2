package com.example.myapplication.domain

import com.example.myapplication.BookEntity
import com.example.myapplication.data.BookDataSource

class BookDataRepository {
    fun getAllBooks(): Array<BookEntity> {
        return BookDataSource.getAllBooks()
    }

    fun getBook(id: Int): BookEntity {
        return BookDataSource.getBook(id)
    }
}