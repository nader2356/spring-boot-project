package com.school.pfe.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.Level;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class LevelDto {

    private Long id ;

    private String code ;

    private String label ;

    private SectionDto section;

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
                .section(SectionDto.fromEntity(level.getSection()))
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
                .section(SectionDto.toEntity(levelDto.getSection()))
                .build();

    }
}
