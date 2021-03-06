package com.example.myapplication.data

import com.example.myapplication.entities.BookEntity

object BookDataSource {
    fun getAllBooks(): List<BookEntity> {
        return FakeBooksDatabase.getAllBooks()
    }

    fun getBook(id: Int): BookEntity {
        return FakeBooksDatabase.getBook(id)
    }

}