package com.macielcustodio.gestao_vagas.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.macielcustodio.gestao_vagas.providers.JWTCompanyProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityCompanyFilter extends OncePerRequestFilter {
  @Autowired
  private JWTCompanyProvider jwtCompanyProvider;

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain) throws ServletException, IOException {

    SecurityContextHolder.getContext().setAuthentication(null);

    String header = request.getHeader("Authorization");

    if (!isCompanyEndpoint(request) || header == null) {
      filterChain.doFilter(request, response);
      return;
    }

    DecodedJWT decodedJWT = this.jwtCompanyProvider.validateToken(header);

    if (decodedJWT == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    setAuthentication(request, decodedJWT);
    filterChain.doFilter(request, response);
  }

  private boolean isCompanyEndpoint(HttpServletRequest request) {
    return request.getRequestURI().startsWith("/company");
  }

  private void setAuthentication(HttpServletRequest request, DecodedJWT decodedJWT) {
    String companyId = decodedJWT.getSubject();

    request.setAttribute("company_id", companyId);

    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(companyId, null,
        Collections.emptyList());
    SecurityContextHolder.getContext().setAuthentication(auth);
  }
}
