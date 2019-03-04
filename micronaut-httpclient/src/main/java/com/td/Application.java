package com.td;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
    info = @Info(
        title = "Hello Swagger",
        version = "0.1",
        description = "第一次使用swagger",
        license = @License(name = "Apache 2.0", url = "http://localhost:8888"),
        contact = @Contact(url = "http://tandi.cc", name = "TanDi", email = "tandi@163.com")
    )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}