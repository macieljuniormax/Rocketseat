package com.macielcustodio.gestao_vagas.modules.company.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macielcustodio.gestao_vagas.modules.company.dto.CreateJobDTO;
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
  public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest httpServletRequest) {
    var companyId = httpServletRequest.getAttribute("company_id");

    var jobEntity = JobEntity.builder()
        .level(createJobDTO.getLevel())
        .description(createJobDTO.getDescription())
        .benefits(createJobDTO.getBenefits())
        .companyId(UUID.fromString(companyId.toString()))
        .build();

    return this.createJobUseCase.execute(jobEntity);
  }
}
