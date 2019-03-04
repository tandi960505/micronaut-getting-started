package example.micronaut.client.impl;

import example.micronaut.client.InventoryFetcher;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Maybe;


/** 发现服务inventory */
@Client("inventory")
//@Requires(notEnv = Environment.TEST)
public interface InventoryClient extends InventoryFetcher {

    @Override
    @Get("/api/inventory/{isbn}")  /**调用服务端点*/
    Maybe<Integer> inventory(String isbn);
}