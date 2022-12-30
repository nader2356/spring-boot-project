package com.school.pfe.Dto;

import com.school.pfe.Model.Level;
import com.school.pfe.Model.Subject;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SubjectIdDto {
    private Long id;

    public static SubjectIdDto fromEntity(Subject subject)
    {
        if(subject == null )
        {
            return null ;
        }
        return SubjectIdDto.builder()
                .id(subject.getId())
                .build();
    }

    public static Subject fromDtoToEntity(SubjectIdDto subjectIdDto)
    {
        if(subjectIdDto == null )
        {
            return null ;
        }
        return Subject.builder()
                .id(subjectIdDto.getId())
                .build();
    }
}
