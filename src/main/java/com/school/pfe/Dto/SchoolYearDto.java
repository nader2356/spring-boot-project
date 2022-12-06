package com.school.pfe.Dto;

import com.school.pfe.Model.Level;
import com.school.pfe.Model.SchoolYear;
import lombok.*;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolYearDto {
    private Long id ;

    private String year;

    private Instant startDateSemestre1;

    private Instant startDateSemestre2;

    private Instant endDateSemestre1;

    private Instant endDateSemestre2;

    public static SchoolYearDto fromEntity(SchoolYear entity) {
        if (entity == null) {
            return null;
        }

        return SchoolYearDto.builder()
                .id(entity.getId())
                .year(entity.getYear())
                .startDateSemestre1(entity.getStartDateSemestre1())
                .startDateSemestre2(entity.getStartDateSemestre2())
                .endDateSemestre1(entity.getEndDateSemestre1())
                .endDateSemestre1(entity.getEndDateSemestre2())
                .build();
    }
    public static SchoolYear toEntity(SchoolYearDto schoolYearDto) {
        if (schoolYearDto == null) {
            return null;
        }
        return SchoolYear.builder()
                .id(schoolYearDto.getId())
                .year(schoolYearDto.getYear())
                .startDateSemestre1(schoolYearDto.getStartDateSemestre1())
                .startDateSemestre2(schoolYearDto.getStartDateSemestre2())
                .endDateSemestre1(schoolYearDto.getEndDateSemestre1())
                .endDateSemestre1(schoolYearDto.getEndDateSemestre2())
                .build();
    }
}
