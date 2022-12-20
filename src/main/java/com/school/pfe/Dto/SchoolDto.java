package com.school.pfe.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.School;

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
	public static SchoolDto entityToDto(School school) {
        if (school == null) {
            return null;
        }
        return SchoolDto.builder()
                .id(school.getId())
                .name(school.getName())
                .address(school.getAddress())
                .build();
        }
    public static School dtoToEntity(SchoolDto schoolDto) {

        if (schoolDto == null) {
            return null;
        }
        School school = new School();
          school.setId(schoolDto.getId());
          school.setName(schoolDto.getName());
          school.setAddress(schoolDto.getAddress());
          return school;
    }

	


	
}
