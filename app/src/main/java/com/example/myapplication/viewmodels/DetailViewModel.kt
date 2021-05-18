package com.example.myapplication.viewmodels

import com.example.myapplication.domain.BookDataRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.entities.BookEntity

class DetailViewModel : ViewModel() {
    val book = MutableLiveData<BookEntity>()

    fun getBook(id:Int){
        book.value = BookDataRepository.getBook(id)
    }
}