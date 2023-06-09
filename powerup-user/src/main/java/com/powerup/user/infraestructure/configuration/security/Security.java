package com.powerup.user.infraestructure.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class Security {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()

                // Allows to visualize Swagger without authentication
                .antMatchers( "/api/v1/auth/**","/swagger-ui/**", "/swagger-resources/**",
                        "/v2/api-docs/**", "/v3/api-docs/**")
                .permitAll()

                // Validating permits to access the endpoints

                // User microservice
                .antMatchers("/user/proprietary", "/api/user/proprietary").hasAuthority("ROLE_ADMIN")
                .antMatchers("/user/employee").hasAnyAuthority("ROLE_ADMIN","ROLE_PROPRIETARY")
                .antMatchers("/user/client**", "/user/email/**").permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }


}