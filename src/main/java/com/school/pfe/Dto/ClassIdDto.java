package com.school.pfe.Dto;

import com.school.pfe.Model.Class;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClassIdDto {
    private Long id;

    public static ClassIdDto fromEntity(Class classe)
    {
        if(classe == null )
        {
            return null ;
        }
        return ClassIdDto.builder()
                .id(classe.getId())
                .build();
    }

    public static Class fromDtoToEntity(ClassIdDto classIdDto)
    {
        if(classIdDto == null )
        {
            return null ;
        }
        return Class.builder()
                .id(classIdDto.getId())
                .build();
    }
}
