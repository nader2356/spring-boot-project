package com.school.pfe.Dto;


import com.school.pfe.Model.Absence;

import lombok.Builder;
import lombok.Data;


import java.util.Date;
@Builder
@Data
public class AbsenceDto {
    private Long id ;
    private Date dateAbsence;
    private String type;
    private StudentDto student;

    private SeanceDto seance;



    public static AbsenceDto fromEntity(Absence absence) {
        if (absence == null) {
            return null;

        }
        return AbsenceDto.builder()
                .dateAbsence(absence.getDateAbsence())
                .type(absence.getType())
                .student(StudentDto.fromEntity(absence.getStudent()))
                .seance(SeanceDto.fromEntity(absence.getSeance()))
                .id(absence.getId())
                .build();
    }

    public static Absence toEntity(AbsenceDto absenceDto){
        if(absenceDto==null){
            return null;
        }
        Absence absence=new Absence();

        absence.setId(absenceDto.getId());
        absence.setDateAbsence(absenceDto.getDateAbsence());
        absence.setType(absenceDto.getType());

        return absence;
    }

}
