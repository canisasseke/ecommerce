package com.zopenlab.ecommercegateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration{

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http,
	    ReactiveClientRegistrationRepository clientRegistrationRepository) {
	  // Authenticate through configured OpenID Provider
	  http.oauth2Login();
	  // Also logout at the OpenID Connect provider
	  http.logout(logout -> logout.logoutSuccessHandler(
	    new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository)));
	  // Require authentication for all requests except actautor endpoint
	  http.csrf().disable();
	  return http.build();
	}

	
	  @Bean public CorsWebFilter corsWebFilter() { CorsConfiguration
	  corsConfiguration = new CorsConfiguration();
	  corsConfiguration.setAllowCredentials(true);
	  corsConfiguration.addAllowedHeader("*");
	  corsConfiguration.addAllowedMethod("*");
	  corsConfiguration.addAllowedOrigin("*"); UrlBasedCorsConfigurationSource
	  corsConfigurationSource = new UrlBasedCorsConfigurationSource();
	  corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
	  return new CorsWebFilter(corsConfigurationSource); }
	 
	
}

