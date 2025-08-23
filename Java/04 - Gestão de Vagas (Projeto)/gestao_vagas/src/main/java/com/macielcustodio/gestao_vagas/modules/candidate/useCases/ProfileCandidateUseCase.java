package com.macielcustodio.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.macielcustodio.gestao_vagas.modules.candidate.CandidateRepository;
import com.macielcustodio.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;

@Service
public class ProfileCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public ProfileCandidateResponseDTO execute(UUID idCandidate) {
    var candidate = this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
          throw new UsernameNotFoundException("User not found.");
        });

    return ProfileCandidateResponseDTO.builder()
        .id(candidate.getId())
        .name(candidate.getName())
        .username(candidate.getUsername())
        .email(candidate.getEmail())
        .description(candidate.getDescription())
        .build();
  }
}
