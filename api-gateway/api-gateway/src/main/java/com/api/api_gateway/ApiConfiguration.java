package com.api.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiConfiguration {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p.path("/get").
                        filters(f -> f.addRequestHeader("MyHeader", "MyUri")
                                .addRequestParameter("MyParam", "Nikhil")).
                        uri("http://httpbin.org:80"))
                // this will convert the url into specific format and
                // applying lb means that the service named currency-exchange
                // will be load balanced by naming server.

                .route(p->p.path("/currency-exchange/**").uri("lb://currency-exchange"))
                .route(p->p.path("/currency-conversion/**").uri("lb://currency-conversion"))
                .route(p->p.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
                // to form custom routes and we can rewrite the routes
                .route(p->p.path("/currency-conversion-new/**")
                        .filters(f->f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                        "/currency-conversion-feign/${segment}"))
                                .uri("lb://currency-conversion"))
                .build();
    }

}
