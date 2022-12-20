package com.school.pfe.Dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.school.pfe.Model.Class;
import com.school.pfe.Model.Inscription;
import com.school.pfe.Model.Seance;
import com.school.pfe.Model.Timetable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimetableDto {

	long idPlanning;
	List<Seance> emploiDuTemps;
	Class classTeam;
	
	public static TimetableDto fromEntity(Timetable timetable) {
        if (timetable == null) {
            return null;

        }
        return Timetable.builder()
                .idPlanning(timetable.getIdPlanning())         
                .emploiDuTemps(TimetableDto.fromEntity(timetable.getEmploiDuTemps()))
                .classTeam(TimetableDto.fromEntity(timetable.getClassTeam()))
                .build();
    }

    public static Timetable toEntity(TimetableDto timetableDto){
        if(timetableDto == null){
            return null;
        }
        Timetable timetable=new Timetable();
        Timetable.setId(timetableDto.getIdPlanning());
        Timetable.setEmploiDuTemps(timetableDto.getEmploiDuTemps());
        Timetable.setClassTeam(timetableDto.getClassTeam());

        return timetable;
    }

}
