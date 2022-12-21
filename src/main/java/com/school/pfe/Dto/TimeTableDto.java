package com.school.pfe.Dto;

import java.util.List;
import com.school.pfe.Model.TimeTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeTableDto {
    private Long id;
    private SchoolYearDto schoolYear;
    private ClassDto classe;
    private List<SeanceDto> Seances;

    public static TimeTableDto fromEntity(TimeTable timeTable) {
        if (timeTable == null) {
            return null;

        }
        return TimeTableDto.builder()
                .id(timeTable.getId())
                .schoolYear(SchoolYearDto.fromEntity(timeTable.getSchoolYear()))
                .classe(ClassDto.fromEntity(timeTable.getClasse()))
                .build();
    }

    public static TimeTable toEntity(TimeTableDto timeTableDto){
        if(timeTableDto==null){
            return null;
        }
        TimeTable timeTable=new TimeTable();

        timeTable.setId(timeTableDto.getId());
        timeTable.setSchoolYear(SchoolYearDto.toEntity(timeTableDto.getSchoolYear()));
        timeTable.setClasse(ClassDto.toEntity(timeTableDto.getClasse()));
        return timeTable;
    }


}