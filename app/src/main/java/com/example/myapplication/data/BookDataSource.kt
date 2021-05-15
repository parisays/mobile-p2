package com.example.myapplication.data

import com.example.myapplication.BookEntity

object BookDataSource {
    fun getAllBooks(): Array<BookEntity> {
        return FakeBooksDatabase.getAllBooks()
    }

    fun getBook(id: Int): BookEntity {
        return getAllBooks().first { it.id == id }
    }

}