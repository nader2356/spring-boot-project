package com.school.pfe.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Builder
public class SchoolDto {
  private Long id;
  private String name;
  private String address;
  @JsonIgnore
  private List <FacultyDto> faculties;
	
}
