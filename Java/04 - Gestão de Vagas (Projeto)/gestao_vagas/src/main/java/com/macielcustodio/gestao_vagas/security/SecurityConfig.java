package com.macielcustodio.gestao_vagas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {
  @Autowired
  private SecurityCompanyFilter securityCompanyFilter;

  @Autowired
  private SecurityCandidateFilter securityCandidateFilter;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> {
          auth.requestMatchers("/candidate/", "/candidate/auth").permitAll();
          auth.requestMatchers("/company/", "/company/auth").permitAll();
          auth.anyRequest().authenticated();
        })
        .addFilterBefore(securityCompanyFilter, BasicAuthenticationFilter.class)
        .addFilterBefore(securityCandidateFilter, BasicAuthenticationFilter.class);

    return httpSecurity.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
