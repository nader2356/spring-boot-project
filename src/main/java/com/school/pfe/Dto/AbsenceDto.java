package com.school.pfe.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.pfe.Model.Absence;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@Builder
@Data
public class AbsenceDto {
    private int id;

    private String jourabsence;


    private Date datedebut;


    private Date dateFin;


    private String type;


    private MatiereDto matiere;



    private EleveDto eleve;



    public static AbsenceDto fromEntity(Absence absence) {
        if (absence == null) {
            return null;

        }
        return AbsenceDto.builder()
                .jourabsence(absence.getJourabsence())
                .datedebut(absence.getDatedebut())
                .dateFin(absence.getDateFin())
                .type(absence.getType())
                .matiere(MatiereDto.fromEntity(absence.getMatiere()))
                .eleve(EleveDto.fromEntity(absence.getEleve()))
                .id(absence.getId())



                .build();
    }

    public static Absence toEntity(AbsenceDto absenceDto){
        if(absenceDto==null){
            return null;
        }
        Absence absence=new Absence();

        absence.setId(absenceDto.getId());
        absence.setJourabsence(absenceDto.getJourabsence());
        absence.setDatedebut(absenceDto.getDatedebut());
        absence.setDateFin(absenceDto.getDateFin());
        absence.setType(absenceDto.getType());

        return absence;
    }

}
