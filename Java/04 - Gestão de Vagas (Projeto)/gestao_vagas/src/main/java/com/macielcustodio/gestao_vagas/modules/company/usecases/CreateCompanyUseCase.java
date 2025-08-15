package com.macielcustodio.gestao_vagas.modules.company.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macielcustodio.gestao_vagas.exceptions.UserFoundException;
import com.macielcustodio.gestao_vagas.modules.company.entities.CompanyEntity;
import com.macielcustodio.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
  @Autowired
  private CompanyRepository companyRepository;

  public CompanyEntity execute(CompanyEntity companyEntity) {
    this.companyRepository
      .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
      .ifPresent((_) -> {
        throw new UserFoundException();
      });

    return this.companyRepository.save(companyEntity);
  }
}
