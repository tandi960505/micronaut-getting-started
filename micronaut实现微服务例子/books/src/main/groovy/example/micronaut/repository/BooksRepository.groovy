package example.micronaut.repository

import example.micronaut.beans.Book

interface BooksRepository {
    List<Book> findAll()
}