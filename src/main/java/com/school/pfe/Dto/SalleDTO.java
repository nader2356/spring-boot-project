package com.school.pfe.Dto;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.Faculty;
import com.school.pfe.Model.Salle;
import com.school.pfe.Model.School;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter


public class SalleDTO {
	
	private Long id;
	@NotNull(message="it should be not null")
	
	private String salleNumber;
	
	private String bloc;
	private SchoolDto school ;
	@JsonIgnore
  // private List<PlanningDto> plannings;
	
	 public static SalleDTO fromEntity(Salle entity) {
	        if (entity== null) {
	            return null;
	        }

	        return SalleDTO.builder()
	        		.id(entity.getId())
	                .salleNumber(entity.getSalleNumber())
	                .bloc(entity.getBloc())
	                .school(ConvertSchool.entityToDto(entity.getSchool()))
	                .build();
}
	
	public static Salle toEntity(SalleDTO salleDTO) {

        if (salleDTO == null) {
            return null;
        }

        Salle entity = new Salle();
        entity.setId(salleDTO.getId());
        entity.setSalleNumber(salleDTO.getSalleNumber());
        entity.setBloc(salleDTO.getBloc());
        entity.setSchool(ConvertSchool.dtoToEntity(salleDTO.getSchool()));

        return entity;
    }
	    }




