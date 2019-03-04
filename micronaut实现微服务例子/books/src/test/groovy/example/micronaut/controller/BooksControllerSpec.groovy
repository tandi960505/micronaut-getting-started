package example.micronaut.controller

import example.micronaut.beans.Book
import io.micronaut.context.ApplicationContext
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

/** 功能测试类 */
class BooksControllerSpec extends Specification {

    /** 容器 */
    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup 
    RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL())

    void "test books retrieve"() { 
        when:
        HttpRequest request = HttpRequest.GET('/api/books')
        List<Book> books = client.toBlocking().retrieve(request, Argument.of(List, Book))

        then:
        books books.size() == 2
    }
}