package com.macielcustodio.gestao_vagas.security;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.macielcustodio.gestao_vagas.providers.JWTCandidateProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityCandidateFilter extends OncePerRequestFilter {
  @Autowired
  private JWTCandidateProvider jwtCandidateProvider;

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain) throws ServletException, IOException {

    SecurityContextHolder.getContext().setAuthentication(null);

    String header = request.getHeader("Authorization");

    if (!isCandidateEndpoint(request) || header == null) {
      filterChain.doFilter(request, response);
      return;
    }

    DecodedJWT decodedJWT = this.jwtCandidateProvider.validateToken(header);

    if (decodedJWT == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    setAuthentication(request, decodedJWT);
    filterChain.doFilter(request, response);
  }

  private boolean isCandidateEndpoint(HttpServletRequest request) {
    return request.getRequestURI().startsWith("/candidate");
  }

  private void setAuthentication(HttpServletRequest request, DecodedJWT decodedJWT) {
    String candidateId = decodedJWT.getSubject();

    request.setAttribute("candidate_id", candidateId);

    List<Object> roles = decodedJWT.getClaim("roles").asList(Object.class);
    List<SimpleGrantedAuthority> grants = roles.stream()
        .map(role -> new SimpleGrantedAuthority(role.toString())).toList();
    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(candidateId, null, grants);
    SecurityContextHolder.getContext().setAuthentication(auth);
  }
}
