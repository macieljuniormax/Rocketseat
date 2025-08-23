package com.macielcustodio.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.macielcustodio.gestao_vagas.exceptions.UserFoundException;
import com.macielcustodio.gestao_vagas.modules.candidate.CandidateEntity;
import com.macielcustodio.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((_) -> {
          throw new UserFoundException();
        });

    var hashedPassword = passwordEncoder.encode(candidateEntity.getPassword());
    candidateEntity.setPassword(hashedPassword);

    return this.candidateRepository.save(candidateEntity);
  }
}
