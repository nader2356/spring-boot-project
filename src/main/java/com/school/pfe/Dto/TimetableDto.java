package com.school.pfe.Dto;

import java.util.List;
import java.util.Set;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.school.pfe.Model.Class;
import com.school.pfe.Model.Inscription;
import com.school.pfe.Model.Seance;
import com.school.pfe.Model.TimeTable;
import com.school.pfe.Model.Timetable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeTableDto {
    private Long id;
    private AcademicYear academicYear;
    private ClassDto Classe;
    private Set<SeanceDto> Seances;

    public static TimeTableDto fromEntity(TimeTable timeTable) {
        if (timeTable == null) {
            return null;

        }
        return TimeTableDto.builder()
                .id(timeTable.getId())
                .academicYear(AcademicYearDto.fromEntity(timeTable.getAcademicYear())
                        .classe(ClassDto.fromEntity(timeTable.getClass())
                                .build();
    }

    public static TimeTable toEntity(TimeTableDto timeTableDto){
        if(timeTableDto==null){
            return null;
        }
        TimeTable timeTable=new TimeTable();

        timeTable.setId(timeTableDto.getId());
        timeTable.setAcademicYear(timeTableDto.getAcademicYear());
        timeTable.setClasse(timeTableDto.getClasse());
        return timeTable;
    }


}