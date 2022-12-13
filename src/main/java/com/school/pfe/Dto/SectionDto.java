package com.school.pfe.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.Section;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SectionDto {

    private Long id;

    private String code;

    private String label;

    @JsonIgnore
    private List<LevelDto> levels;

    public static SectionDto fromEntity(Section section) {
        if (section == null) {
            return null;
        }

        return SectionDto.builder()
                .id(section.getId())
                .code(section.getCode())
                .label(section.getLabel())
                .build();
    }

    public static Section toEntity(SectionDto sectionDto) {

        if (sectionDto == null) {
            return null;
        }

        Section section = new Section();
        section.setId(sectionDto.getId());
        section.setCode(sectionDto.getCode());
        section.setLabel(sectionDto.getLabel());

        return section;
    }
}
