package example.micronaut.controller;

import example.micronaut.beans.Book;
import example.micronaut.client.BooksFetcher;
import example.micronaut.client.InventoryFetcher;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;

@Controller("/api")
public class BooksController {

    private final BooksFetcher booksFetcher;
    private final InventoryFetcher inventoryFetcher;
    // 依赖注入实例
    public BooksController(BooksFetcher booksFetcher, InventoryFetcher inventoryFetcher) {
        this.booksFetcher = booksFetcher;
        this.inventoryFetcher = inventoryFetcher;
    }

    @Get("/books")
    Flowable<Book> findAll() {

        // 获取到所有的book
        Flowable<Book> bookFlowable = booksFetcher.fetchBooks();
        return bookFlowable
                .flatMapMaybe(b -> inventoryFetcher.inventory(b.getIsbn())  // 获取book的库存
                        .filter(stock -> stock > 0) // 筛选出库存大于0的book
                        .map(stock -> { // 将stock(库存)设置到Book属性中
                            b.setStock(stock);
                            return b;
                        })
                );
    }
}