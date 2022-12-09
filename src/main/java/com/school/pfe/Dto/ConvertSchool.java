package com.school.pfe.Dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.school.pfe.Model.School;

public class ConvertSchool {

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
