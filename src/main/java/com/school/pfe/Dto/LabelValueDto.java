package com.school.pfe.Dto;

import com.school.pfe.Model.Level;
import com.school.pfe.Model.Section;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class LabelValueDto {

    private String label;
    private long value;

    public static LabelValueDto fromEntity(Level level)
    {
        if(level == null )
        {
            return null ;
        }
        return LabelValueDto.builder()
                .label(level.getLabel())
                .value(level.getId())
                .build();
    }

    public static LabelValueDto fromEntitySection(Section section)
    {
        if(section == null )
        {
            return null ;
        }
        return LabelValueDto.builder()
                .label(section.getLabel())
                .value(section.getId())
                .build();
    }

}
