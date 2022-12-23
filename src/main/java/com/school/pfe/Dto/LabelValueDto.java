package com.school.pfe.Dto;

import com.school.pfe.Model.Level;
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

}
