
  package com.zopenlab.ecommercegateway.config;
  
  import org.springframework.cloud.gateway.route.RouteLocator; import
  org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder; import
  org.springframework.context.annotation.Bean; import
  org.springframework.context.annotation.Configuration;
  
  @Configuration 
  public class StaticRoutesConfiguration {
  
  
  @Bean 
  RouteLocator staticRoutes(RouteLocatorBuilder builder) { return
  builder.routes() .route("products_path",r -> r.path("/products/**")
  .uri("lb://ecommerce-products"))
  
  
  .route("customers-path",r -> r.path("/customers/**")
  .uri("lb://ecommerce-customers"))
  
  
  .route("orders_path",r -> r.path("/orders/**") .uri("lb://ecommerce-orders"))
  
  
  .build(); }
  
  
  }
 