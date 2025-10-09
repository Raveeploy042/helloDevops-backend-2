// src/main/java/com/example/backend/config/SecurityConfig.java
package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      // ❌ ลบ .cors(Customizer.withDefaults()) ออก (เดี๋ยวให้ CorsConfig จัดการแทน)
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/auth/**").permitAll()
        .anyRequest().permitAll()
      );

    return http.build();
  }
}
