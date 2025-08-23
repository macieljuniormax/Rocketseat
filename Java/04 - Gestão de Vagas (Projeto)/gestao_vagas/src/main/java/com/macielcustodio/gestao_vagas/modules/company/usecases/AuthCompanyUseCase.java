package com.macielcustodio.gestao_vagas.modules.company.usecases;

import java.time.Duration;
import java.time.Instant;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.macielcustodio.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import com.macielcustodio.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {
  @Value(value = "${security.token.secret.company}")
  private String tokenSecret;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
    var company = this.companyRepository
        .findByUsername(authCompanyDTO.getUsername())
        .orElseThrow(() -> {
          throw new UsernameNotFoundException("Username/Password incorrect");
        });

    if (this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword())) {
      Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
      return JWT.create()
          .withIssuer("javagas")
          .withExpiresAt(Instant.now().plus((Duration.ofHours(2))))
          .withSubject(company.getId().toString())
          .sign(algorithm);
    } else {
      throw new AuthenticationException("Invalid credentials");
    }
  }
}
