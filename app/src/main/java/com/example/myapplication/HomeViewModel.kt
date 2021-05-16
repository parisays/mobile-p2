package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.BookDataRepository
import com.example.myapplication.BookEntity

class HomeViewModel : ViewModel() {
    private  val _books = MutableLiveData<List<BookEntity>>().apply {
        value = BookDataRepository.getAllBooks()
    }

    val books: LiveData<List<BookEntity>> = _books

}