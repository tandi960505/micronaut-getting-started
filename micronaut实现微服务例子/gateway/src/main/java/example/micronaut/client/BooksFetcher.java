package example.micronaut.client;

import example.micronaut.beans.Book;
import io.reactivex.Flowable;

public interface BooksFetcher { 
    Flowable<Book> fetchBooks();
}