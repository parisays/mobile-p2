package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.BookDataRepository
import com.example.myapplication.BookEntity

class HomeViewModel : ViewModel() {
    val books =
        MutableLiveData<Array<BookEntity>>()

    init {
        this.books.value = BookDataRepository.getAllBooks()
    }
}