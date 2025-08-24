package com.macielcustodio.gestao_vagas.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JWTCandidateProvider {
  @Value(value = "${security.token.secret.candidate}")
  private String tokenSecret;

  public DecodedJWT validateToken(String token) {
    if (token == null)
      return null;

    token = token.replace("Bearer ", "");
    Algorithm algorithm = Algorithm.HMAC256(tokenSecret);

    try {
      return JWT.require(algorithm).build().verify(token);
    } catch (JWTVerificationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
