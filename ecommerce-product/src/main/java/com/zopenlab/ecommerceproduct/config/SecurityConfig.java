/*
 * package com.zopenlab.ecommerceproduct.config;
 * 
 * import java.util.Collection; import java.util.Collections; import
 * java.util.List; import java.util.Map; import java.util.stream.Collectors;
 * 
 * import org.springframework.boot.autoconfigure.security.oauth2.resource.
 * OAuth2ResourceServerProperties; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.convert.converter.Converter; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.oauth2.jwt.Jwt; import
 * org.springframework.security.oauth2.jwt.JwtDecoder; import
 * org.springframework.security.oauth2.jwt.JwtDecoders; import
 * org.springframework.security.oauth2.jwt.MappedJwtClaimSetConverter; import
 * org.springframework.security.oauth2.jwt.NimbusJwtDecoder; import
 * org.springframework.security.oauth2.server.resource.authentication.
 * JwtAuthenticationConverter;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter{
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { //
 * Validate tokens through configured OpenID Provider
 * http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(
 * jwtAuthenticationConverter()); // Require authentication for all requests
 * http.authorizeRequests().anyRequest().authenticated(); // Allow showing pages
 * within a frame http.headers().frameOptions().sameOrigin(); }
 * 
 * private JwtAuthenticationConverter jwtAuthenticationConverter() {
 * JwtAuthenticationConverter converter = new JwtAuthenticationConverter(); //
 * Convert realm_access.roles claims to granted authorities, for use in access
 * decisions converter.setJwtGrantedAuthoritiesConverter(new
 * KeycloakRealmRoleConverter()); return converter; }
 * 
 * @Bean public JwtDecoder jwtDecoderByIssuerUri(OAuth2ResourceServerProperties
 * properties) { String issuerUri = properties.getJwt().getIssuerUri();
 * NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
 * JwtDecoders.fromIssuerLocation(issuerUri); // Use preferred_username from
 * claims as authentication name, instead of UUID subject
 * jwtDecoder.setClaimSetConverter(new UsernameSubClaimAdapter()); return
 * jwtDecoder; }
 * 
 * }
 * 
 * @SuppressWarnings("unchecked") class KeycloakRealmRoleConverter implements
 * Converter<Jwt, Collection<GrantedAuthority>> {
 * 
 * @Override public Collection<GrantedAuthority> convert(Jwt jwt) { final
 * Map<String, Object> realmAccess = (Map<String, Object>)
 * jwt.getClaims().get("realm_access"); return ((List<String>)
 * realmAccess.get("roles")).stream() .map(roleName -> "ROLE_" + roleName)
 * .map(SimpleGrantedAuthority::new) .collect(Collectors.toList()); } } class
 * UsernameSubClaimAdapter implements Converter<Map<String, Object>, Map<String,
 * Object>> {
 * 
 * private final MappedJwtClaimSetConverter delegate =
 * MappedJwtClaimSetConverter.withDefaults(Collections.emptyMap());
 * 
 * @Override public Map<String, Object> convert(Map<String, Object> claims) {
 * Map<String, Object> convertedClaims = this.delegate.convert(claims); String
 * username = (String) convertedClaims.get("preferred_username");
 * convertedClaims.put("sub", username); return convertedClaims; } }
 */