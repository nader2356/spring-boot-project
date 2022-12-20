package com.school.pfe.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
public class Seance {
	
	@Id
    @GeneratedValue
	int IdSéance;
	int NumSéance;
	int IdSalle;
	String matière;
	String jour;
	int IdProf;
	
	@ManyToOne
	Timetable timetable;
	
	@ManyToOne
	Teacher teacher;
	
	@ManyToOne
	ClassRoom classroom;

}
