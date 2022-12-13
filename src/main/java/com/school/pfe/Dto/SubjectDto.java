package com.school.pfe.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.Subject;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SubjectDto {

    private Long id;

    private String name;

    private Float coefficient;

    private LevelDto level;

    @JsonIgnore
    private List<TeacherDto> teachers;

    public static SubjectDto fromEntity(Subject subject) {
        if (subject == null) {
            return null;
        }

        return SubjectDto.builder()
                .id(subject.getId())
                .name(subject.getName())
                .coefficient(subject.getCoefficient())
                .level(LevelDto.fromEntity(subject.getLevel()))
                .build();
    }

    public static Subject toEntity(SubjectDto subjectDto) {
        if (subjectDto == null) {
            return null;
        }

        Subject subject = new Subject();
        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        subject.setCoefficient(subjectDto.getCoefficient());
        subject.setLevel(LevelDto.toEntity(subjectDto.getLevel()));

        return subject;
    }
}
