package com.school.pfe.Dto;

import com.school.pfe.Model.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeanceDto {
    private Long id;
    private String day;
    private String numSeance;
    private int coursID;
    private ClassRoom classRoom;
    private Teacher teacher;
    private Set<Absence> Absences;
    private TimeTable timeTable;


    public static SeanceDto fromEntity(Seance seance) {
        if (seance==null) {
            return null;
        }
        return SeanceDto.builder()
                .id(seance.getId())
                .day(seance.getDay())
                .numSeance(seance.getNumSeance())
                .coursID(seance.getCoursID())
                .classRoom(ClassRoomDto.fromEntity(seance.getClassRoom()))
                .teacher(TeacherDto.entityToDto(seance.getTeacher()))
                .timeTable(TimeTableDto.fromEntity(seance.getTimeTable()))
                .build();
    }
    public static Seance fromDto(SeanceDto seanceDto) {
        if (seanceDto==null) {
            return null;

        }
        Seance seance=new Seance();
        seance.setId(seanceDto.getId());
        seance.setClassRoom(seanceDto.getClassRoom());
        seance.setTimeTable(seanceDto.getTimeTable());
        seance.setTeacher(seanceDto.getTeacher());
        seance.setCoursID(seanceDto.getCoursID());
        seance.setNumSeance(seanceDto.getNumSeance());
        seance.setDay(seanceDto.getDay());


        return seance;
    }
}
