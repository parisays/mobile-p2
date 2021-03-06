package com.example.myapplication.data

import com.example.myapplication.entities.BookEntity

object FakeBooksDatabase {
    val book1 = BookEntity(
        id = 1,
        name = "Oliver Twist",
        writer = "Charles Dickens",
        image = "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/chameleon/title-movie/252681_oliver_twist_2005_1400x2100_2.jpg",
        genres = "Fiction, Romance",
        page_count = 506
    )

    val book2 = BookEntity(
        id = 2,
        name = "Kafka on the Shore",
        writer = "Haruki Murakami",
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHFU_j93PPsbQGqoaZJnHH6-Emk_sIxG823SkoRTL0nvdEP41f",
        genres = "Magical Realism, Fantasy Fiction",
        page_count = 467
    )

    val book3 = BookEntity(
        id = 3,
        name = "Dune",
        writer = "Frank Herbert",
        image = "https://d30a6s96kk7rhm.cloudfront.net/original/978/057/508/9780575081505.jpg",
        genres = "Science Fiction",
        page_count = 500
    )

    val book4 = BookEntity(
        id = 4,
        name = "The Call of Cthulhu",
        writer = "H. P. Lovecraft",
        image = "https://images-na.ssl-images-amazon.com/images/I/81JSqv9QqAL.jpg",
        genres = "Horror",
        page_count = 420
    )

    val book5 = BookEntity(
        id = 5,
        name = "When Nietzsche Wept",
        writer = "Irvin D. Yalom",
        image = "https://blackwells.co.uk/jacket/l/9780062009302.jpg",
        genres = "Biographical Fiction",
        page_count = 352
    )


    fun getAllBooks(): List<BookEntity> {
        return listOf(book1, book2, book3, book4, book5)
    }

    fun getBook(id: Int): BookEntity {
        return getAllBooks().single {
            it.id == id
        }
    }
}