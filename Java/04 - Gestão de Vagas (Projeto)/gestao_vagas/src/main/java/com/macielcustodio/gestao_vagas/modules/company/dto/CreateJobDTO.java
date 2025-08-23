package com.macielcustodio.gestao_vagas.modules.company.dto;

import lombok.Data;

@Data
public class CreateJobDTO {
  private String level;
  private String description;
  private String benefits;
}
