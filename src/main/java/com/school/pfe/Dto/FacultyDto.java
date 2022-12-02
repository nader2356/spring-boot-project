package com.school.pfe.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.Faculty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacultyDto {

    private int id;

    private String code;

    private String label;

    private SchoolDto school;

    @JsonIgnore
    private List<LevelDto> levels;

    public static FacultyDto fromEntity(Faculty faculty) {
        if (faculty == null) {
            return null;
        }

        return FacultyDto.builder()
                .id(faculty.getId())
                .code(faculty.getCode())
                .label(faculty.getLabel())
                .school(ConvertSchool.entityToDto(faculty.getSchool()))
                .build();
    }

    public static Faculty toEntity(FacultyDto facultyDto) {
        if (facultyDto == null) {
            return null;
        }

        Faculty faculty = new Faculty();
        faculty.setId(facultyDto.getId());
        faculty.setCode(facultyDto.getCode());
        faculty.setLabel(facultyDto.getLabel());
        faculty.setSchool(ConvertSchool.dtoToEntity(facultyDto.getSchool()));

        return faculty;
    }
}
