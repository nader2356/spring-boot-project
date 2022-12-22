package com.school.pfe.Dto;

import com.school.pfe.Model.Level;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LevelInfoDto {

    private Long id ;

    private String code ;

    private String label ;

    private String sectionName;

    public static LevelInfoDto fromEntity(Level level) {
        if (level == null) {
            return null;
        }

        return LevelInfoDto.builder()
                .id(level.getId())
                .code(level.getCode())
                .label(level.getLabel())
                .sectionName(level.getSection()!=null?level.getSection().getLabel():"")
                .build();
    }
}
