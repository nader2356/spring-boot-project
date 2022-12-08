package com.school.pfe.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.Faculty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FacultyDto {

    private Long id;

    private String code;

    private String label;

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

        return faculty;
    }
}
