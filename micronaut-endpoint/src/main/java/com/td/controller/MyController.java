package com.td.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.management.endpoint.annotation.Endpoint;
import io.micronaut.management.endpoint.annotation.Read;
import io.micronaut.management.endpoint.annotation.Write;
import lombok.extern.slf4j.Slf4j;

/**
 * defaultSensitive：设置端点是否敏感，简单来说就是端点是否需要受权才能访问
 * 如果设置为true需要有相应的header字段
 */
// 配置自定义端点
@Endpoint(id = "my", defaultSensitive = false)
@Slf4j
@Controller
public class MyController {

    @Read // 读端点 对应 HTTP-GET
    @Get("/check")
    public String check() {
        log.info("--------------- into check() ---------------");
        return "ok";
    }

//    同一个 endpoint id下 各种端点只能有一个，以下方法会放开注解会出现
//    More than 1 route matched the incoming request. The following routes matched /my: POST - /my, POST - /my
//    @Read
//    @Get("/check1")
//    public String check1() {
//        log.info("--------------- into check1() ---------------");
//        return "ok";
//    }

    @Write // 写端点 对应 HTTP-POST
    @Get("/print")
    public String print() {
        log.info("--------------- into print() ---------------");
        return "print success";
    }

    // 删除端点 对应 HTTP-DELETE
    @io.micronaut.management.endpoint.annotation.Delete
    @Delete("/delete")
    public void delete(){
        log.info("--------------- into delete() ---------------");
    }

}
