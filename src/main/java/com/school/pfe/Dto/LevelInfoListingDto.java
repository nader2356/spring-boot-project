package com.school.pfe.Dto;

import com.school.pfe.Model.Level;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LevelInfoListingDto {

    private Long id ;

    private String code ;

    private String label ;

    private String facultyName;

    public static LevelInfoListingDto fromEntity(Level level) {
        if (level == null) {
            return null;
        }

        return LevelInfoListingDto.builder()
                .id(level.getId())
                .code(level.getCode())
                .label(level.getLabel())
                .facultyName(level.getFaculty()!=null?level.getFaculty().getLabel():"")
                .build();
    }
}
