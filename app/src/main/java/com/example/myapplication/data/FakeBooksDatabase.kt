package com.example.myapplication.data

import com.example.myapplication.BookEntity

object FakeBooksDatabase {
    val book1 = BookEntity(
        id = 1,
        name = "Oliver Twist",
        writer = "Charles Dickens",
        image = "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/chameleon/title-movie/252681_oliver_twist_2005_1400x2100_2.jpg",
        genres="Novel",
        page_count = 506
    )

    val book2 = BookEntity(
        id = 2,
        name = "Oliver Twist",
        writer = "Charles Dickens",
        image = "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/chameleon/title-movie/252681_oliver_twist_2005_1400x2100_2.jpg",
        genres="Novel",
        page_count = 506
    )

    val book3 = BookEntity(
        id = 3,
        name = "Oliver Twist",
        writer = "Charles Dickens",
        image = "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/chameleon/title-movie/252681_oliver_twist_2005_1400x2100_2.jpg",
        genres="Novel",
        page_count = 506
    )

    val book4 = BookEntity(
        id = 4,
        name = "Oliver Twist",
        writer = "Charles Dickens",
        image = "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/chameleon/title-movie/252681_oliver_twist_2005_1400x2100_2.jpg",
        genres="Novel",
        page_count = 506
    )

    fun getAllBooks(): Array<BookEntity>{
        return arrayOf(book1,book2,book3,book4)
    }
}