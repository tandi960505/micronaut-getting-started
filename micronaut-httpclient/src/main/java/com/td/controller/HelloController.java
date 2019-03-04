package com.td.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.HttpClient;
import org.reactivestreams.Publisher;

import java.net.URL;

@Controller
public class HelloController {

    @Get("/show")
    public Publisher<String> show() throws Exception{
        Publisher<String> retrieve = HttpClient.create(new URL("http://localhost:8080")).retrieve(HttpRequest.GET("/"));
        return retrieve;
    }

}
