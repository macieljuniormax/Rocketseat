package com.macielcustodio.gestao_vagas.modules.company.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macielcustodio.gestao_vagas.modules.company.entities.JobEntity;
import com.macielcustodio.gestao_vagas.modules.company.usecases.CreateJobUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/job")
public class JobController {
  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping("/")
  public JobEntity create(@Valid @RequestBody JobEntity jobEntity, HttpServletRequest httpServletRequest) {
    var companyId = httpServletRequest.getAttribute("company_id");

    jobEntity.setCompanyId(UUID.fromString(companyId.toString()));

    return this.createJobUseCase.execute(jobEntity);
  }
}
