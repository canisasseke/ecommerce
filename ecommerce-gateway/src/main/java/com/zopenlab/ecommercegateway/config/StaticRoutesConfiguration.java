package com.zopenlab.ecommercegateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StaticRoutesConfiguration {

	@Bean
	RouteLocator staticRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
						.route(r -> r.path("/products/**")
									.uri("http://localhost:9001")
									.id("products_path")
							)
						.build();
	}
}
