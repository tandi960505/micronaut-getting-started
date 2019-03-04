package example.micronaut.client.impl;

import example.micronaut.beans.Book;
import example.micronaut.client.BooksFetcher;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client("books") /** 发现服务books */
//@Requires(notEnv = Environment.TEST)
public interface BooksClient extends BooksFetcher {

    @Override
    @Get("/api/books") /**调用服务端点*/
    Flowable<Book> fetchBooks();

}