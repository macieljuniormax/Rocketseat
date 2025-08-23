package com.macielcustodio.gestao_vagas.modules.candidate.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.macielcustodio.gestao_vagas.modules.candidate.CandidateRepository;
import com.macielcustodio.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import com.macielcustodio.gestao_vagas.modules.candidate.dto.AuthCandidateResponseDTO;

@Service
public class AuthCandidateUseCase {
  @Value(value = "${security.token.secret.candidate}")
  private String tokenSecret;

  @Autowired
  private final PasswordEncoder passwordEncoder;

  @Autowired
  private CandidateRepository candidateRepository;

    AuthCandidateUseCase(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

  public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidateDTO) throws AuthenticationException {
    var candidate = this.candidateRepository
        .findByUsername(authCandidateDTO.username())
        .orElseThrow(() -> {
          throw new UsernameNotFoundException("Username/password incorrect");
        });

    if (this.passwordEncoder.matches(authCandidateDTO.password(), candidate.getPassword())) {
      Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
      var expires_in = Instant.now().plus(Duration.ofMinutes(10));
      var token =  JWT.create()
          .withIssuer("javagas")
          .withExpiresAt(expires_in)
          .withClaim("roles", Arrays.asList("candidate"))
          .withSubject(candidate.getId().toString())
          .sign(algorithm);

      return AuthCandidateResponseDTO.builder()
          .access_token(token)
          .expires_in(expires_in.toEpochMilli())
          .build();
    } else {
      throw new AuthenticationException("Invalid credentials");
    }
  }
}
