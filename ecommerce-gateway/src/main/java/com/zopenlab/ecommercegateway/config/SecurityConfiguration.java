package com.zopenlab.ecommercegateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter.Mode;

@EnableWebFluxSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http,
	    ReactiveClientRegistrationRepository clientRegistrationRepository) {
	  // Authenticate through configured OpenID Provider
	  http.oauth2Login();
	  // Also logout at the OpenID Connect provider
	  http.logout(logout -> logout.logoutSuccessHandler(
	    new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository)));

	  // Require authentication for all requests
	  http.authorizeExchange().anyExchange().authenticated();

	  // Allow showing /home within a frame
	  http.headers().frameOptions().mode(Mode.SAMEORIGIN);

	  // Disable CSRF in the gateway to prevent conflicts with proxied service CSRF
	  http.csrf().disable();
	  return http.build();
	}
	
	/*
	 * class CustomAuthenticationConverter implements Converter<Jwt,
	 * Mono<AbstractAuthenticationToken>> {
	 * 
	 * @Override public Mono<AbstractAuthenticationToken> convert(Jwt source) { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * }
	 */
			
		
}
