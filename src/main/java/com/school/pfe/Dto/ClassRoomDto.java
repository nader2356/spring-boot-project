package com.school.pfe.Dto;




import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.school.pfe.Model.ClassRoom;


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


public class ClassRoomDto {
	
	private Long id;
	@NotNull(message="it should be not null")
	
	private String classRoomNumber;

	private String bloc;
	private SchoolDto school ;
	@JsonIgnore
  // private List<SessionDto> sessions;
	
	 public static ClassRoomDto fromEntity(ClassRoom entity) {
	        if (entity== null) {
	            return null;
	        }

	        return ClassRoomDto.builder()
	        		.id(entity.getId())
	                .classRoomNumber(entity.getClassRoomNumber())
	                .bloc(entity.getBloc())
	                .school(SchoolDto.entityToDto(entity.getSchool()))
	                .build();
}
	
	public static ClassRoom toEntity(ClassRoomDto salleDTO) {

        if (salleDTO == null) {
            return null;
        }

        ClassRoom entity = new ClassRoom();
        entity.setId(salleDTO.getId());
        entity.setClassRoomNumber(salleDTO.getClassRoomNumber());
        entity.setBloc(salleDTO.getBloc());
        entity.setSchool(SchoolDto.dtoToEntity(salleDTO.getSchool()));

        return entity;
    }
	    }




