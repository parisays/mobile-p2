package com.example.myapplication

import com.example.myapplication.domain.BookDataRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    val book = MutableLiveData<BookEntity>()

    fun getBook(id:Int){
        book.value = BookDataRepository.getBook(id)
    }
}