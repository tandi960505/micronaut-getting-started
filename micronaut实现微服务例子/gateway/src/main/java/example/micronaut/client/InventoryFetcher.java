package example.micronaut.client;

import io.reactivex.Maybe;

public interface InventoryFetcher { 
    Maybe<Integer> inventory(String isbn); 
}