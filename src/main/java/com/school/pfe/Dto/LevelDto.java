package com.school.pfe.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.Level;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LevelDto {

    private Long id ;

    private String code ;

    private String label ;

    private FacultyDto faculty;

    @JsonIgnore
    private List<ClassDto> classes;

    public static LevelDto fromEntity(Level level) {

        if (level == null) {
            return null;
        }

        return LevelDto.builder()
                .id(level.getId())
                .code(level.getCode())
                .label(level.getLabel())
                .faculty(FacultyDto.fromEntity(level.getFaculty()))
                .build();

    }

    public static Level toEntity(LevelDto levelDto) {

        if (levelDto == null) {
            return null;
        }

        return Level.builder()
                .id(levelDto.getId())
                .code(levelDto.getCode())
                .label(levelDto.getLabel())
                .faculty(FacultyDto.toEntity(levelDto.getFaculty()))
                .build();

    }
}
