package example.micronaut.controller;

import example.micronaut.beans.Book;
import io.micronaut.context.ApplicationContext;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 单元测试类
 * 默认使用 application-test.yml文件测试（需要新建）
 */
public class BooksControllerTest {

    private static EmbeddedServer server; 
    private static HttpClient client;

    @BeforeClass 
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class); 
        client = server .getApplicationContext() .createBean(HttpClient.class, server.getURL());
    }

    @AfterClass 
    public static void stopServer() {
        if (server != null) { 
            server.stop();
        }
        if (client != null) { 
            client.stop();
        }
     }

     @Test 
     public void retrieveBooks() { 
         HttpRequest request = HttpRequest.GET("/api/books");         
         List<Book> books = client.toBlocking().retrieve(request, Argument.of(List.class, Book.class));
         assertNotNull(books); 
         assertEquals(1, books.size());
     } 
}