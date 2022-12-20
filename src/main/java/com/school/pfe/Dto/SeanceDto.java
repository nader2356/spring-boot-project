package com.school.pfe.Dto;

import com.school.pfe.Model.ClassRoom;
import com.school.pfe.Model.Seance;
import com.school.pfe.Model.Teacher;
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
public class SeanceDto {

	int IdSéance;
	int NumSéance;
	String matière;
	String jour;
	Timetable timetable;
	Teacher teacher;
	ClassRoom classroom;
	
	
	public static SeanceDto fromEntity(Seance seance) {
        if (seance == null) {
            return null;

        }
        return Seance.builder()
                .IdSéance(seance.getIdSéance())
                .NumSéance(seance.getNumSéance())
                .matière(seance.getMatière())
                .timetable(TimetableDto.fromEntity(seance.getTimetable()))
                .teacher(TimetableDto.fromEntity(seance.getTeacher()))
                .classroom(TimetableDto.fromEntity(seance.getClassRoom()))
                .build();
    }

    public static Seance toEntity(SeanceDto seanceDto){
        if(seanceDto == null){
            return null;
        }
        Seance seance=new Seance();
        seance.setId(seanceDto.getIdSéance());
        seance.setNumSéance(seanceDto.getNumSéance());        
        seance.setMatière(seanceDto.getMatière());
        seance.setJour(seanceDto.getJour());
        seance.setJour(seanceDto.getTimetable());
        seance.setJour(seanceDto.getTeacher());
        seance.setClassroom(seanceDto.getClassroom());

        return seance;
    }

}
