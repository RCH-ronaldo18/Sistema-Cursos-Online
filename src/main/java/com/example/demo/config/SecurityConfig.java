package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 🔹 forma nueva de desactivar CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 🔹 permite todo sin autenticación
                )
                .httpBasic(Customizer.withDefaults()); // 🔹 para pruebas básicas
        return http.build();
    }
}
