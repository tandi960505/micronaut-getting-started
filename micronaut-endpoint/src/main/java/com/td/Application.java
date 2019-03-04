package com.td;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

/* 启用swagger */
@OpenAPIDefinition(
    info = @Info(
        title = "Endpoints-Swagger",
        version = "0.1",
        description = "第一次使用swagger",
        license = @License(name = "netty", url = "http://localhost:9097"),
        contact = @Contact(url = "http://tandi.cc", name = "TanDi", email = "tandi@163.com")
    )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}

/**
 * Built-In Endpoints micronaut内置端点
 * 1. BeansEndpoint         /beans
 * 2. InfoEndpoint          /info
 * 3. HealthEndpoint        /health
 * 4. MetricsEndpoint       /metrics
 * 5. RefreshEndpoint       /refresh
 * 6. RoutesEndpoint        /routes
 * 7. LoggersEndpoint       /loggers
 * 8. ServerStopEndpoint    /stop
 *
 * 配置方式-例子（application.yml）
 * endpoints:
 *     beans:
 *         enabled: Boolean
 *         sensitive: Boolean
 * */