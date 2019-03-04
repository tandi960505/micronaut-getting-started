package com.td;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 启用swagger */
@OpenAPIDefinition(
    info = @Info(
        title = "Hello Swagger",
        version = "0.1",
        description = "第一次使用swagger",
        license = @License(name = "netty", url = "http://localhost:8080"),
        contact = @Contact(url = "http://tandi.cc", name = "TanDi", email = "tandi@163.com")
    )
)
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext run = Micronaut.run(Application.class);
        logger.info( "DataSource = " + run.getBean(DatabaseBean.class).dataSource );
    }

}