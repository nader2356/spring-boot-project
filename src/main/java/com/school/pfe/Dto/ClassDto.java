package com.school.pfe.Dto;

import com.school.pfe.Model.Class;
import com.school.pfe.Model.SchoolYear;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassDto {
    private Long id;

    private  String nameClass;

    private  String labelClass;


    private LevelDto level;


    public static ClassDto fromEntity(Class entity) {
        if (entity == null) {
            return null;
        }

        return ClassDto.builder()
                .id(entity.getId())
                .nameClass(entity.getNameClass())
                .labelClass(entity.getLabelClass())
                .level(LevelDto.fromEntity(entity.getLevel()))
                .build();
    }
    public static Class toEntity(ClassDto dto) {
        if (dto == null) {
            return null;
        }
        return Class.builder()
                .id(dto.getId())
                .nameClass(dto.getNameClass())
                .labelClass(dto.getLabelClass())
                .level(LevelDto.toEntity(dto.getLevel()))
                .build();
    }


}

